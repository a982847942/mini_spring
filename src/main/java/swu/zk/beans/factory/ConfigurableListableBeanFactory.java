package swu.zk.beans.factory;

import swu.zk.beans.BeansException;
import swu.zk.beans.factory.config.AutowireCapableBeanFactory;
import swu.zk.beans.factory.config.BeanDefinition;
import swu.zk.beans.factory.config.BeanPostProcessor;
import swu.zk.beans.factory.config.ConfigurableBeanFactory;

/**
 * @Classname ConfigurableListableBeanFactory
 * @Description TODO
 * @Date 2022/4/9 18:00
 * @Created by brain
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    //提前实例化单例bean对象
    void preInstantiateSingletons() throws BeansException;


}
