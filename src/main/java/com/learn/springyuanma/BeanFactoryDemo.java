package com.learn.springyuanma;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanFactoryDemo {
    public static void main(String[] args) {
       /* AbstractApplicationContext bean = new ClassPathXmlApplicationContext("xml/hispring.xml");
        HiSpring  hiSpring =(HiSpring) bean.getBean("hiSpring");
        System.out.println("----"+hiSpring.getTestStr());
        bean.registerShutdownHook();*/

        Resource resource = new ClassPathResource("xml/hispring.xml");
        BeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
        beanDefinitionReader.loadBeanDefinitions(resource);
        HiSpring hiSpring = (HiSpring)beanFactory.getBean("hiSpring");
        System.out.println(hiSpring.getTestStr());
    }
}
