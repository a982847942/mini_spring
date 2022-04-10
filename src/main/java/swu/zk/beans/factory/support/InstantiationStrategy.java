package swu.zk.beans.factory.support;

import swu.zk.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Classname InstantiationStrategy
 * @Description TODO
 * @Date 2022/4/9 8:16
 * @Created by brain
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor,
                       Object[] args);
}

