package swu.zk.bean;

import swu.zk.beans.BeansException;
import swu.zk.beans.PropertyValue;
import swu.zk.beans.PropertyValues;
import swu.zk.beans.factory.ConfigurableListableBeanFactory;
import swu.zk.beans.factory.config.BeanDefinition;
import swu.zk.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @Classname MyBeanFactoryPostProcessor
 * @Description TODO
 * @Date 2022/4/10 17:44
 * @Created by brain
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
