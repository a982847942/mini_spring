package swu.zk.beans.factory;

import swu.zk.beans.BeansException;

/**
 * @Classname BeanFactory
 * @Description TODO
 * @Date 2022/4/8 20:48
 * @Created by brain
 */
public  interface BeanFactory {
   Object getBean(String name);
   Object getBean(String name,Object...args);
   <T> T getBean(String name, Class<T> requiredType) throws BeansException;
   <T> T getBean(Class<T> requiredType) throws BeansException;
}
