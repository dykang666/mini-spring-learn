package org.springframework.test.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/8/4 16:14
 */
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor
{
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("CustomBeanFactoryPostProcessor#postProcessBeanFactory");
        BeanDefinition personBeanDefiniton = beanFactory.getBeanDefinition("person");
        PropertyValues propertyValues = personBeanDefiniton.getPropertyValues();
        //将person的name属性改为ivy
        propertyValues.addPropertyValue(new PropertyValue("name", "ivy"));
    }
}
