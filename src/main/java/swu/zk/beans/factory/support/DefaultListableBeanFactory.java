package swu.zk.beans.factory.support;

import swu.zk.beans.BeansException;
import swu.zk.beans.factory.ConfigurableListableBeanFactory;
import swu.zk.beans.factory.config.BeanDefinition;
import swu.zk.beans.factory.config.BeanPostProcessor;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname DefaultListableBeanFactory
 * @Description TODO
 * @Date 2022/4/8 21:42
 * @Created by brain
 */
public class DefaultListableBeanFactory extends AbstractAutowiredCapableBeanFactory implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {
   //保存beanDefinition
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 获取beanDefinitioon
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) throw  new BeansException("No bean named '" + beanName + "' is defined");
        return beanDefinition;
    }

    @Override
    public void preInstantiateSingletons() throws BeansException {
        beanDefinitionMap.keySet().forEach(this::getBean);
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

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> result = new HashMap<>();
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            Class beanClass = beanDefinition.getBeanClass();
            if (type.isAssignableFrom(beanClass)) {
                result.put(beanName, (T) getBean(beanName));
            }
        });
        return result;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }
}
