/*******************************************************************************
 * Copyright (c) 2019 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.websphere.servlet.cache;

import javax.servlet.http.HttpServletRequest;

import com.ibm.websphere.cache.EntryInfo;
import com.ibm.ws.jsp.runtime.HttpJspBase;

/**
 * This class identifies cacheable JSPs to the fragment cache. 
 * The cache will call the getId() and getSharingPolicy() methods to 
 * obtain the caching metadata for a given execution of the JSP.
 * @ibm-api 
 */
public abstract class CacheableJspPage extends HttpJspBase implements CacheableServlet {

    /**
     * This executes the algorithm to compute the cache id.
     *
     * @param request The HTTP request object.
     * @return The cache id.  A null indicates that the JSP should 
     * not be cached.
     * @ibm-api 
     */
    public String getId(HttpServletRequest request) {
       return null;
    }

    /**
     * This returns the sharing policy for this cache entry.
     * See com.ibm.websphere.servlet.cache.EntryInfo for possible
     * values.
     *
     * @param request The HTTP request object.
     * @return The sharing policy.
     * @ibm-api 
     */
    public int getSharingPolicy(HttpServletRequest request) {
       return EntryInfo.NOT_SHARED;
    }

}
