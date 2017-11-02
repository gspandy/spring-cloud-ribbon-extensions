/*
 * Copyright (c) 2017 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.enadim.spring.cloud.ribbon.support.favorite;

import com.github.enadim.spring.cloud.ribbon.rule.PredicateBasedRuleSupport;
import com.github.enadim.spring.cloud.ribbon.support.FavoriteZoneConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FavoriteZoneConfig.class, properties = {
        "ribbon.client.name=application",
        "ribbon.extensions.client.application.rule.favorite-zone.enabled=false"})
public class FavoriteZoneClientDisabledTest {

    @Inject
    ApplicationContext applicationContext;

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void should_not_be_instantiated() {
        applicationContext.getBean(PredicateBasedRuleSupport.class);
    }
}