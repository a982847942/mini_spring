package swu.zk.factory.support;

import swu.zk.BeansException;
import swu.zk.factory.BeanFactory;
import swu.zk.factory.config.BeanDefinition;

/**
 * @Classname AbstractBeanFactory
 * @Description TODO
 * @Date 2022/4/8 21:19
 * @Created by brain
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

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

    protected <T> T doGetBean(final  String beanName,Object[] args){
        Object bean = getSingleton(beanName);
        if (bean != null) return (T)bean;
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        bean = createBean(beanName,beanDefinition,args);
        return (T)bean;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
    protected abstract Object createBean(String beanName,BeanDefinition definition,Object[] args) throws BeansException;
}
