package swu.zk.beans.factory.support;

import swu.zk.io.DefaultResourceLoader;
import swu.zk.io.ResourceLoader;

/**
 * @Classname AbstractBeanDefinitionReader
 * @Description TODO
 * @Date 2022/4/9 14:36
 * @Created by brain
 */
public abstract class AbstractBeanDefinitionReader implements  BeanDefinitionReader{
    private BeanDefinitionRegistry beanDefinitionRegistry;
    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        this(beanDefinitionRegistry,new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry, ResourceLoader resourceLoader) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return this.beanDefinitionRegistry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return this.resourceLoader;
    }
}
