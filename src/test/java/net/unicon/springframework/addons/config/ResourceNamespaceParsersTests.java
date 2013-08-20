package net.unicon.springframework.addons.config;

import net.unicon.springframework.addons.resource.ResourceChangeDetectingEventNotifier;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Dmitriy Kopylenko
 * @author Unicon, inc.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ResourceNamespaceParsersTests {

    @Autowired
    ApplicationContext applicationContext;

    private static final String RESOURCE_CHANGE_DETECTOR_BEAN_NAME = "testChangeDetector";


    @Test
    public void resourceChangeDetectingEventNotifierBeanDefinitionCorrectlyParsed() {
        assertTrue(applicationContext.containsBean(RESOURCE_CHANGE_DETECTOR_BEAN_NAME));
        assertTrue(applicationContext.getBeansOfType(ResourceChangeDetectingEventNotifier.class).size() == 1);
    }
}
