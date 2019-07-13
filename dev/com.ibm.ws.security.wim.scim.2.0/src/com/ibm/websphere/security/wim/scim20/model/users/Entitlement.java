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

package com.ibm.websphere.security.wim.scim20.model.users;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ibm.ws.security.wim.scim20.model.users.EntitlementImpl;

/**
 * A single entitlement for the user that represents a thing the user has.
 */
@JsonDeserialize(as = EntitlementImpl.class)
public interface Entitlement {

    /**
     * Get a human-readable name, primarily used for display purposes.
     *
     * @return A human-readable name, primarily used for display purposes.
     */
    public String getDisplay();

    /**
     * Get a Boolean value indicating the 'primary' or preferred attribute value
     * for this attribute. The primary attribute value 'true' MUST appear no
     * more than once.
     *
     * @return A Boolean value indicating the 'primary' or preferred attribute
     *         value for this attribute.
     */
    public Boolean getPrimary();

    /**
     * Get a label indicating the attribute's function.
     *
     * @return A label indicating the attribute's function.
     */
    public String getType();

    /**
     * Get the value of an entitlement.
     *
     * @return The value of an entitlement.
     */
    public String getValue();

    /**
     * Set a human-readable name, primarily used for display purposes.
     *
     * @param display
     *            A human-readable name, primarily used for display purposes.
     */
    // TODO Description says READ-ONLY, but mutability is readWrite.
    public void setDisplay(String display);

    /**
     * Set a Boolean value indicating the 'primary' or preferred attribute value
     * for this attribute. The primary attribute value 'true' MUST appear no
     * more than once.
     *
     * @param primary
     *            A Boolean value indicating the 'primary' or preferred
     *            attribute value for this attribute.
     */
    public void setPrimary(Boolean primary);

    /**
     * Set a label indicating the attribute's function.
     *
     * @param type
     *            A label indicating the attribute's function.
     */
    public void setType(String type);

    /**
     * Set the value of an entitlement.
     *
     * @param value
     *            The value of an entitlement.
     */
    public void setValue(String value);
}
