/*
 * ========================================================================
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ========================================================================
 */
package com.example.javapersistence.ch02.hibernate;

import com.example.javapersistence.entities.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldHibernateToJPATest {

    private static EntityManagerFactory createEntityManagerFactory() {
        Configuration configuration = new Configuration();
        configuration.configure().addAnnotatedClass(Message.class);

        Map<String, String> properties = new HashMap<>();
        Enumeration<?> propertyNames = configuration.getProperties().propertyNames();
        while (propertyNames.hasMoreElements()) {
            String element = (String) propertyNames.nextElement();
            properties.put(element, configuration.getProperties().getProperty(element));
        }

        return Persistence.createEntityManagerFactory("ch02", properties);
    }

    @Test
    public void storeLoadMessage() {

        try (EntityManagerFactory emf = createEntityManagerFactory(); 
                EntityManager em = emf.createEntityManager()) {

            em.getTransaction().begin();

            Message message = new Message();
            message.setText("Hello World from Hibernate to JPA!");

            em.persist(message);

            em.getTransaction().commit();
            //INSERT into MESSAGE (ID, TEXT) values (1, 'Hello World from Hibernate to JPA!')

            List<Message> messages
                    = em.createQuery("select m from Message m", Message.class).getResultList();
            //SELECT * from MESSAGE

            assertAll(
                    () -> assertEquals(1, messages.size()),
                    () -> assertEquals("Hello World from Hibernate to JPA!", messages.get(0).getText())
            );
        }
    }

}
