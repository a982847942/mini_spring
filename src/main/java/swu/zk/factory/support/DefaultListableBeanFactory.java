package swu.zk.factory.support;

import swu.zk.BeansException;
import swu.zk.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname DefaultListableBeanFactory
 * @Description TODO
 * @Date 2022/4/8 21:42
 * @Created by brain
 */
public class DefaultListableBeanFactory extends AbstractAutowiredCapableBeanFactory implements BeanDefinitionRegistry {
   //保存beanDefinition
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 获取beanDefinitioon
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) throw  new BeansException("No bean named '" + beanName + "' is defined");
        return beanDefinition;
    }

    /**
     * 将注册beanDefinition和获取beanDefinition分开 更加体现了单一职责原则
     * @param beanName
     * @param beanDefinition
     */
    @Override
    public void registryBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);
    }
}
