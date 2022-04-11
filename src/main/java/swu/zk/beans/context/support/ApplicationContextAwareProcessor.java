package swu.zk.beans.context.support;

import swu.zk.beans.BeansException;
import swu.zk.beans.context.ApplicationContext;
import swu.zk.beans.context.ApplicationContextAware;
import swu.zk.beans.factory.config.BeanPostProcessor;

/**
 * @Classname ApplicationContextAwareProcessor
 * @Description TODO
 * @Date 2022/4/11 15:10
 * @Created by brain
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
