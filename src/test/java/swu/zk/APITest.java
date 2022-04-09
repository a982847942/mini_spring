package swu.zk;

import org.junit.Test;
import swu.zk.bean.UserService;
import swu.zk.factory.BeanFactory;
import swu.zk.factory.config.BeanDefinition;
import swu.zk.factory.support.BeanDefinitionRegistry;
import swu.zk.factory.support.DefaultListableBeanFactory;
import swu.zk.factory.support.SimpleInstantiationStrategy;

/**
 * @Classname APITest
 * @Description TODO
 * @Date 2022/4/8 20:54
 * @Created by brain
 */
public class APITest {
    @Test
    public void test_beanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registryBeanDefinition("userService", beanDefinition);
        System.out.println("第一次获取bean");
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        System.out.println("第二次获取bean");
        UserService userService1 = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

    @Test
    public void test_paramsConstructor(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
//        beanFactory.setInstantiationStrategy(new SimpleInstantiationStrategy());
        beanFactory.registryBeanDefinition("userService",beanDefinition);
        UserService userService = (UserService)beanFactory.getBean("userService","brain");
//        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();

    }
}
