package swu.zk.factory.support;

import swu.zk.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Classname DefaultSingletonBeanRegistry
 * @Description TODO
 * @Date 2022/4/8 21:22
 * @Created by brain
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String,Object> singletonObjects = new ConcurrentHashMap<>();
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 添加单例bean  第一次没有的话在createBean之后会调用该方法
     * @param beanName
     * @param singletonObject
     */

    protected void addSingleton(String beanName,Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }
}
