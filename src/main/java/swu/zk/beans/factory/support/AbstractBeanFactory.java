package swu.zk.beans.factory.support;

import swu.zk.beans.BeansException;
import swu.zk.beans.factory.BeanFactory;
import swu.zk.beans.factory.FactoryBean;
import swu.zk.beans.factory.config.BeanDefinition;
import swu.zk.beans.factory.config.BeanPostProcessor;
import swu.zk.beans.factory.config.ConfigurableBeanFactory;
import swu.zk.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname AbstractBeanFactory
 * @Description TODO
 * @Date 2022/4/8 21:19
 * @Created by brain
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {
    /** BeanPostProcessors to apply in createBean */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    private ClassLoader classLoader = ClassUtils.getDefaultClassloader();
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
//        Object bean = getSingleton(beanName);
//        if (bean != null) return (T)bean;
//        BeanDefinition beanDefinition = getBeanDefinition(beanName);
//        bean = createBean(beanName,beanDefinition,args);
//        return (T)bean;

        Object sharedInstance = getSingleton(beanName);
        if (sharedInstance != null) {
            // 如果是 FactoryBean，则需要调用 FactoryBean#getObject
            return (T) getObjectForBeanInstance(sharedInstance, beanName);
        }

        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        Object bean = createBean(beanName, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, beanName);
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        //不是FactoryBean 则直接返回即可
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }

        //先从缓存池获取
        Object object = getCachedObjectForFactoryBean(beanName);

        //获取池获取为null
        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            //尝试重新创建bean
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }

        return object;
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

    public ClassLoader getClassLoader() {
        return this.classLoader;
    }
}
