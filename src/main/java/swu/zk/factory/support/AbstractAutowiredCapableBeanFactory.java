package swu.zk.factory.support;

import swu.zk.BeansException;
import swu.zk.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Classname AbstractAutowiredCapableBeanFactory
 * @Description TODO
 * @Date 2022/4/8 21:35
 * @Created by brain
 */
public abstract class AbstractAutowiredCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();


    /**
     * 创建bean
     * @param beanName
     * @param definition
     * @return
     * @throws BeansException
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition definition,Object[] args) throws BeansException {
        Object bean = null;
//        try {
//            bean = definition.getBeanClass().newInstance();
//        } catch (InstantiationException e) {
//            throw new BeansException("Instantiation of bean failed", e);
//        } catch (IllegalAccessException e) {
//            throw new BeansException("Instantiation of bean failed", e);
//        }
        try {
            bean = createBeanInstance(beanName,definition,args);
        }catch (Exception e){
            throw new BeansException("Instantiation of bean failed",e);
        }
        addSingleton(beanName,bean);
        return bean;
    }

    protected  Object createBeanInstance(String beanName, BeanDefinition definition, Object[] args){
        Constructor constructor = null;
        Class<?> beanClass = definition.getBeanClass();
        Constructor<?>[] constructors = beanClass.getConstructors();
        if (null != args){
            for (Constructor<?> ctor : constructors) {
                if (ctor.getParameterTypes().length == args.length){
                    constructor = ctor;
                    break;
                }
            }
        }
        return getInstantiationStrategy().instantiate(definition,beanName,constructor,args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    /**
     * 默认是cglib  可以选择不同的策略 也可以实现自己的策略 只需实现InstantiationStrategy接口 然后调用该方法即可
     * @param instantiationStrategy
     */
    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
