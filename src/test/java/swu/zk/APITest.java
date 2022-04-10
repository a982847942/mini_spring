package swu.zk;

import org.junit.Test;
import swu.zk.bean.UserDao;
import swu.zk.bean.UserService;
import swu.zk.beans.PropertyValue;
import swu.zk.beans.PropertyValues;
import swu.zk.beans.factory.config.BeanDefinition;
import swu.zk.beans.factory.config.BeanReference;
import swu.zk.beans.factory.support.DefaultListableBeanFactory;

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


    @Test
    public void test_property(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registryBeanDefinition("userDao",new BeanDefinition(UserDao.class));


        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class,propertyValues);

        beanFactory.registryBeanDefinition("userService",beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
