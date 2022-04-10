package swu.zk.beans.context.support;

import swu.zk.beans.BeansException;
import swu.zk.beans.context.ConfigureApplicationContext;
import swu.zk.beans.factory.BeanFactory;
import swu.zk.beans.factory.ConfigurableListableBeanFactory;
import swu.zk.beans.factory.config.BeanFactoryPostProcessor;
import swu.zk.beans.factory.config.BeanPostProcessor;
import swu.zk.beans.factory.config.ConfigurableBeanFactory;
import swu.zk.io.DefaultResourceLoader;

import java.util.Map;

/**
 * @Classname AbstarctApplicationContext
 * @Description TODO
 * @Date 2022/4/9 20:24
 * @Created by brain
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigureApplicationContext {

    @Override
    public void refresh() throws BeansException {
        //1.创建beanFactory 并注册相关beanDefinition
        refreshBeanFactory();

        //2.获取beanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        //3.在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessors(beanFactory);

        // 4. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);
        // 5. 提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
    }

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }


    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }
}
