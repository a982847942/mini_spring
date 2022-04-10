package swu.zk.beans.factory.support;

import swu.zk.beans.BeansException;
import swu.zk.io.Resource;
import swu.zk.io.ResourceLoader;

/**
 * @Classname BeanDefinitionLoader
 * @Description TODO
 * @Date 2022/4/9 14:33
 * @Created by brain
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;
    void loadBeanDefinitions(String location) throws BeansException;
    void loadBeanDefinitions(Resource...resources) throws BeansException;
    void loadBeanDefinitions(String[] locations) throws BeansException;
}
