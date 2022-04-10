package swu.zk.beans.context.support;

import swu.zk.beans.factory.support.DefaultListableBeanFactory;
import swu.zk.beans.factory.xml.XMLBeanDefinitionReader;

/**
 * @Classname AbstractXmlApplicationContext
 * @Description TODO
 * @Date 2022/4/9 20:58
 * @Created by brain
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        //将beanfactory 和 resourceLoader传给BeanDefinitionReader
        XMLBeanDefinitionReader beanDefinitionReader = new XMLBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            //将BeanDefinition注册到 beanDefinitionMap
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
