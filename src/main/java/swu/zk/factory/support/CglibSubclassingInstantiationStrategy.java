package swu.zk.factory.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import swu.zk.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Classname CglibSubclassingInstantiationStrategy
 * @Description TODO
 * @Date 2022/4/9 8:28
 * @Created by brain
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{
    /**
     * Instantiation by cglib
     * @param beanDefinition
     * @param beanName
     * @param ctor
     * @param args
     * @return
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == ctor) return enhancer.create();
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
