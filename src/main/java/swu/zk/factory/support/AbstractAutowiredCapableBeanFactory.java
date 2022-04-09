package swu.zk.factory.support;

import swu.zk.BeansException;
import swu.zk.factory.config.BeanDefinition;

/**
 * @Classname AbstractAutowiredCapableBeanFactory
 * @Description TODO
 * @Date 2022/4/8 21:35
 * @Created by brain
 */
public abstract class AbstractAutowiredCapableBeanFactory extends AbstractBeanFactory{

    /**
     * 创建bean
     * @param beanName
     * @param definition
     * @return
     * @throws BeansException
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition definition) throws BeansException {
        Object bean = null;
        try {
            bean = definition.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            throw new BeansException("Instantiation of bean failed", e);
        } catch (IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName,bean);
        return bean;
    }
}
