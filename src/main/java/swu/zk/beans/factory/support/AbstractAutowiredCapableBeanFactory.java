package swu.zk.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import swu.zk.beans.BeansException;
import swu.zk.beans.PropertyValue;
import swu.zk.beans.PropertyValues;
import swu.zk.beans.factory.config.AutowireCapableBeanFactory;
import swu.zk.beans.factory.config.BeanDefinition;
import swu.zk.beans.factory.config.BeanPostProcessor;
import swu.zk.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @Classname AbstractAutowiredCapableBeanFactory
 * @Description TODO
 * @Date 2022/4/8 21:35
 * @Created by brain
 */
public abstract class AbstractAutowiredCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

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
        /**
         * bean实例化
         */
        try {
            bean = createBeanInstance(beanName,definition,args);
            //填充属性
            applyPropertyValues(beanName,bean,definition);
            // 执行 Bean 的初始化方法和 BeanPostProcessor 的前置和后置处理方法
            bean = initializeBean(beanName, bean, definition);
        }catch (Exception e){
            throw new BeansException("Instantiation of bean failed",e);
        }


        /**
         * 添加到单例池
         */
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
                    constructor.setAccessible(true);
                    break;
                }
            }
        }
        return getInstantiationStrategy().instantiate(definition,beanName,constructor,args);
    }

    protected  void applyPropertyValues(String beanName, Object bean, BeanDefinition definition){
        try{
            PropertyValues propertyValues = definition.getPropertyValues();
            for (PropertyValue pv : propertyValues.getPropertyValues()) {
                String name = pv.getName();
                Object value = pv.getValue();
                if (value instanceof BeanReference){
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充 hutools-all
                BeanUtil.setFieldValue(bean, name, value);
            }
        }catch (Exception e){
            throw new RuntimeException("Error setting property values：" + beanName);
        }
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


    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        // 1. 执行 BeanPostProcessor Before 处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

        // 待完成内容：invokeInitMethods(beanName, wrappedBean, beanDefinition);
        invokeInitMethods(beanName, wrappedBean, beanDefinition);

        // 2. 执行 BeanPostProcessor After 处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition) {

    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }
}