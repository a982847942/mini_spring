package swu.zk.factory.support;

import swu.zk.factory.config.BeanDefinition;

/**
 * @Classname BeanDefinitionRegistry
 * @Description TODO
 * @Date 2022/4/8 21:44
 * @Created by brain
 */
public interface BeanDefinitionRegistry {
    /**
     * 注册beanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registryBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
