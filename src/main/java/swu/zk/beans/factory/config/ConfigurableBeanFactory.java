package swu.zk.beans.factory.config;

import swu.zk.beans.factory.HierarchicalBeanFactory;

/**
 * @Classname ConfigurableBeanFactory
 * @Description TODO
 * @Date 2022/4/9 17:56
 * @Created by brain
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry{
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
    void destroySingletons();
}
