/*******************************************************************************
 * Copyright (c) 2015, 2019 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.concurrent.persistent.fat.timers;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.testcontainers.containers.JdbcDatabaseContainer;

import com.ibm.websphere.simplicity.ShrinkHelper;

import componenttest.annotation.TestServlet;
import componenttest.custom.junit.runner.FATRunner;
import componenttest.topology.impl.LibertyServer;
import componenttest.topology.utils.FATServletClient;
import web.PersistentTimersTestServlet;

/**
 * Tests for persistent scheduled executor with task execution disabled
 */
@RunWith(FATRunner.class)
public class PersistentExecutorTimersTest extends FATServletClient {

    private static final String APP_NAME = "timersapp";
    private static final String DB_NAME = "persisttimers";
    
    @TestServlet(servlet = PersistentTimersTestServlet.class, path = APP_NAME)
    public static final LibertyServer server = FATSuite.server;
    
    @ClassRule
    public static final JdbcDatabaseContainer<?> testContainer = DatabaseContainerFactory.create(DB_NAME);

    /**
     * Before running any tests, start the server
     */
    @BeforeClass
    public static void setUp() throws Exception {
    	
    	//Get type
		DatabaseContainerType dbContainerType = DatabaseContainerType.valueOf(testContainer);

    	//Get driver info
    	String driverName = dbContainerType.getDriverName();
    	server.addEnvVar("DB_DRIVER", driverName);

    	//Setup server DataSource properties
    	DatabaseContainerUtil.setupDataSourceProperties(server, testContainer);

		//Initialize database
		DatabaseContainerUtil.initDatabase(testContainer, DB_NAME);
		
		//Add application to server
        ShrinkHelper.defaultDropinApp(server, APP_NAME, "web", "ejb");

        //Start Server
        server.startServer();

    }

    /**
     * After completing all tests, stop the server.
     */
    @AfterClass
    public static void tearDown() throws Exception {
        if (server != null && server.isStarted())
            server.stopServer("CWWKZ0022W");
    }
}