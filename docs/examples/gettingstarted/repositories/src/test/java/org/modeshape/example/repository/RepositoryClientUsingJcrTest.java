/*
 * ModeShape (http://www.modeshape.org)
 * See the COPYRIGHT.txt file distributed with this work for information
 * regarding copyright ownership.  Some portions may be licensed
 * to Red Hat, Inc. under one or more contributor license agreements.
 * See the AUTHORS.txt file in the distribution for a full listing of 
 * individual contributors. 
 *
 * ModeShape is free software. Unless otherwise indicated, all code in ModeShape
 * is licensed to you under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * ModeShape is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.modeshape.example.repository;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.modeshape.example.repository.RepositoryClient.Api;
import org.picketbox.config.PicketBoxConfiguration;
import org.picketbox.factories.SecurityFactory;

/**
 * @author Randall Hauch
 */
public class RepositoryClientUsingJcrTest extends RepositoryClientTest {

    @Before
    @Override
    public void beforeEach() {
        super.beforeEach();
    }

    @BeforeClass
    public static void beforeAll() {
        SecurityFactory.prepare();
        try {
            PicketBoxConfiguration idtrustConfig = new PicketBoxConfiguration();
            idtrustConfig.load("security/jaas.conf.xml");
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.modeshape.example.repository.RepositoryClientTest#getApi()
     */
    @Override
    protected Api getApi() {
        return RepositoryClient.Api.JCR;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.modeshape.example.repository.RepositoryClientTest#shouldHaveContentFromVehiclesRepository()
     */
    @Ignore
    @Override
    public void shouldHaveContentFromVehiclesRepository() throws Throwable {
        super.shouldHaveContentFromVehiclesRepository();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.modeshape.example.repository.RepositoryClientTest#shouldBeAbleToExecuteTestsRepeatedly()
     */
    @Ignore
    @Override
    public void shouldBeAbleToExecuteTestsRepeatedly() throws Throwable {
        // super.shouldBeAbleToExecuteTestsRepeatedly();
    }
}
