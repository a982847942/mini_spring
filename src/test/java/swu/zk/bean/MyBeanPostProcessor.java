package swu.zk.bean;

import swu.zk.beans.BeansException;
import swu.zk.beans.factory.config.BeanPostProcessor;

/**
 * @Classname MyBeanPostProcessor
 * @Description TODO
 * @Date 2022/4/10 17:45
 * @Created by brain
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
