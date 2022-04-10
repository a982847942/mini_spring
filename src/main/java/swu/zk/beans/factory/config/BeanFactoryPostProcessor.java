package swu.zk.beans.factory.config;

import swu.zk.beans.BeansException;
import swu.zk.beans.factory.ConfigurableListableBeanFactory;

/**
 * @Classname BeanFactoryPostProcessor
 * @Description TODO
 * @Date 2022/4/9 20:15
 * @Created by brain
 */
public interface BeanFactoryPostProcessor {
    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
