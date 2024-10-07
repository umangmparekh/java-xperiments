package org.example;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class DynamicBeanLoader {
    public static void main (String[] args) {
        DefaultListableBeanFactory beanFactory =
                new DefaultListableBeanFactory();
        BeanDefinitionBuilder b =
                BeanDefinitionBuilder.rootBeanDefinition(MyBean.class)
                        .addPropertyValue("str", "testingBeanLoader");
        beanFactory.registerBeanDefinition("myBean", b.getBeanDefinition());
        MyBean bean = beanFactory.getBean(MyBean.class);
        String result = bean.doSomething();
        System.out.println("result >> "+result);
    }

}
