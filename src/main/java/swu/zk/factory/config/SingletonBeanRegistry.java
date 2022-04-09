package swu.zk.factory.config;

/**
 * @Classname SingletonBeanRegistry
 * @Description TODO
 * @Date 2022/4/8 21:15
 * @Created by brain
 */

/**
 * 单例bean的接口
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
