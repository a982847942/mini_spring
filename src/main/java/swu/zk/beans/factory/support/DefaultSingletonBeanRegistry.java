package swu.zk.beans.factory.support;

import swu.zk.beans.BeansException;
import swu.zk.beans.factory.DisposableBean;
import swu.zk.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Classname DefaultSingletonBeanRegistry
 * @Description TODO
 * @Date 2022/4/8 21:22
 * @Created by brain
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    /**
     * Internal marker for a null singleton object:
     * used as marker value for concurrent Maps (which don't support null values).
     * concurrentHashMap不支持null键  null值
     */
    protected static final Object NULL_OBJECT = new Object();
    /**
     *单例池
     */
    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    /**
     * 单例对象且实现了DisposableBean接口或xml配置了destroy方法  这里DisposableBean其实都是DisposableBeanAdapter对象
     */
    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();


    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 添加单例bean  第一次没有的话在createBean之后会调用该方法
     *
     * @param beanName
     * @param singletonObject
     */

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }


    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }

    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
