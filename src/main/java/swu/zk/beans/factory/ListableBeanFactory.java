package swu.zk.beans.factory;

import swu.zk.beans.BeansException;

import java.util.Map;

/**
 * @Classname ListableBeanFactory
 * @Description 主要用于扩展BeanFactory
 * @Date 2022/4/9 18:02
 * @Created by brain
 */
public interface ListableBeanFactory extends BeanFactory{
    /**
     * 按照类型返回 Bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans defined in this registry.
     *
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();
}
