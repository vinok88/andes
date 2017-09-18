/*
 * Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License, 
 * Version 2.0 (the "License"); you may not use this file except 
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.andes.configuration.models;

import org.wso2.carbon.config.annotation.Configuration;
import org.wso2.carbon.config.annotation.Element;

/**
 * Configuration model for broker coordination
 */
@Configuration(description = "Broker coordination config")
public class CoordinationConfig {

    @Element(description = "The node ID of each member")
    private String nodeID = "test123";

    @Element(description = "Thrift is used to maintain and sync slot (message groups) ranges between MB nodes.")
    private String thriftServerHost = "localhost";

    public String getNodeID() {
        return nodeID;
    }

    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    public String getThriftServerHost() {
        return thriftServerHost;
    }

    public void setThriftServerHost(String thriftServerHost) {
        this.thriftServerHost = thriftServerHost;
    }
}
