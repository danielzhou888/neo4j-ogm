/*
 * Copyright (c) 2002-2017 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This product is licensed to you under the Apache License, Version 2.0 (the "License").
 * You may not use this product except in compliance with the License.
 *
 * This product may include a number of subcomponents with
 * separate copyright notices and license terms. Your use of the source
 * code for these subcomponents is subject to the terms and
 *  conditions of the subcomponent's license, as noted in the LICENSE file.
 */

package org.neo4j.ogm.drivers.bolt;

import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.neo4j.ogm.config.ClasspathConfigurationSource;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.drivers.AbstractDriverTestSuite;
import org.neo4j.ogm.testutil.TestServer;


/**
 * @author Luanne Misquitta
 * @author Vince Bickers
 */
public class BoltDriverTest extends AbstractDriverTestSuite {

    private static TestServer testServer;

    private Configuration configuration;

    @BeforeClass
    public static void configure() {
        testServer = new TestServer.Builder().enableBolt(true).build();
    }

    @AfterClass
    public static void reset() {
        testServer.shutdown();
    }

    @Override
    protected Configuration getConfiguration() {
        if (configuration == null) {
            configuration = new Configuration.Builder(new ClasspathConfigurationSource("ogm-bolt.properties")).uri(testServer.getUri()).credentials(testServer.getUsername(), testServer.getPassword()).build();
        }
        return configuration;
    }

}