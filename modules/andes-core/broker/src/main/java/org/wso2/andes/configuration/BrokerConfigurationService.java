/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.andes.configuration;

import org.wso2.andes.configuration.models.BrokerConfiguration;
import org.wso2.carbon.config.ConfigProviderFactory;
import org.wso2.carbon.config.provider.ConfigProvider;
import org.wso2.carbon.config.ConfigurationException;


import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Provide the broker configurations instance
 */
public class BrokerConfigurationService {
    private static BrokerConfigurationService brokerConfigurationService = new BrokerConfigurationService();
    private BrokerConfiguration brokerConfiguration;

    // Create new configuration provider
    Path deploymentConfigPath = Paths.get(System.getProperty(AndesConfigurationManager.CARBON_HOME), "conf", "broker",
            "deployment.yaml");

    private BrokerConfigurationService() {
        // Get configuration
        try {
            ConfigProvider configProvider = ConfigProviderFactory.getConfigProvider(deploymentConfigPath);
            brokerConfiguration = configProvider.getConfigurationObject(BrokerConfiguration.class);
        } catch (ConfigurationException e) {
//            logger.error("Error in getting configuration", e);
        }
    }

    public static BrokerConfigurationService getInstance() {
        return brokerConfigurationService;
    }

    public BrokerConfiguration getBrokerConfiguration() {
        return brokerConfiguration;
    }
}
