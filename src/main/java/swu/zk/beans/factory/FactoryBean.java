package swu.zk.beans.factory;

/**
 * @Classname FactoryBean
 * @Description TODO
 * @Date 2022/4/12 8:05
 * @Created by brain
 */
public interface FactoryBean<T> {
    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
