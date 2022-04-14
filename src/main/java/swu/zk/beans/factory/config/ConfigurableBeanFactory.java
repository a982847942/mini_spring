package swu.zk.beans.factory.config;

import swu.zk.beans.factory.HierarchicalBeanFactory;
import swu.zk.util.StringValueResolver;

/**
 * @Classname ConfigurableBeanFactory
 * @Description TODO
 * @Date 2022/4/9 17:56
 * @Created by brain
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry{
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    //添加beanPostProcessor
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
    //销毁单例对象
    void destroySingletons();

    /**
     * Add a String resolver for embedded values such as annotation attributes.
     * @param valueResolver the String resolver to apply to embedded values
     * @since 3.0
     */
    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    /**
     * Resolve the given embedded value, e.g. an annotation attribute.
     * @param value the value to resolve
     * @return the resolved value (may be the original value as-is)
     * @since 3.0
     */
    String resolveEmbeddedValue(String value);
}
