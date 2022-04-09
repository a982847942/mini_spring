package swu.zk.factory;

import swu.zk.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Classname BeanFactory
 * @Description TODO
 * @Date 2022/4/8 20:48
 * @Created by brain
 */
public  interface BeanFactory {
   Object getBean(String name);
}
