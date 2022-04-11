package swu.zk.beans.factory;

import swu.zk.beans.BeansException;

/**
 * @Classname BeanFactoryAware
 * @Description TODO
 * @Date 2022/4/11 15:08
 * @Created by brain
 */
public interface BeanFactoryAware extends Aware{
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
