package swu.zk.beans.context;

import swu.zk.beans.BeansException;

/**
 * @Classname ConfigureApplicationContext
 * @Description TODO
 * @Date 2022/4/9 20:23
 * @Created by brain
 */
public interface ConfigureApplicationContext extends ApplicationContext{
    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();
}
