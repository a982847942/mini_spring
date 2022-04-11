package swu.zk.beans.factory;

/**
 * @Classname BeanClassLoaderAware
 * @Description TODO
 * @Date 2022/4/11 15:08
 * @Created by brain
 */
public interface BeanClassLoaderAware extends Aware{
    void setBeanClassLoader(ClassLoader classLoader);
}
