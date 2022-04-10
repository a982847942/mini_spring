package swu.zk.beans.factory.support;

import swu.zk.beans.BeansException;
import swu.zk.beans.factory.BeanFactory;
import swu.zk.beans.factory.config.BeanDefinition;
import swu.zk.beans.factory.config.BeanPostProcessor;
import swu.zk.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname AbstractBeanFactory
 * @Description TODO
 * @Date 2022/4/8 21:19
 * @Created by brain
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {
    /** BeanPostProcessors to apply in createBean */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    @Override
    public Object getBean(String name) {
//        Object bean = getSingleton(name);
//        if (bean != null){
//            return bean;
//        }
//        /**
//         * 模板方法 具体实现交给子类
//         */
//        BeanDefinition beanDefinition = getBeanDefinition(name);
//        bean = createBean(name,beanDefinition);
//        return bean;
        return doGetBean(name,null);
    }

    @Override
    public Object getBean(String name, Object... args) {
        return doGetBean(name,args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T)getBean(name);
    }

    protected <T> T doGetBean(final  String beanName, Object[] args){
        Object bean = getSingleton(beanName);
        if (bean != null) return (T)bean;
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        bean = createBean(beanName,beanDefinition,args);
        return (T)bean;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
    protected abstract Object createBean(String beanName,BeanDefinition definition,Object[] args) throws BeansException;


    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }
}
