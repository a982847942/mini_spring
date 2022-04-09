package swu.zk.factory.support;

import swu.zk.BeansException;
import swu.zk.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Classname SimpleInstantiationStrategy
 * @Description TODO
 * @Date 2022/4/9 8:20
 * @Created by brain
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    /**
     * Instantiation by JDK
     *
     * @param beanDefinition
     * @param beanName
     * @param ctor
     * @param args
     * @return
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (null != ctor) {
                //有参
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }
            //无参
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]\", e");
        }
    }
}

