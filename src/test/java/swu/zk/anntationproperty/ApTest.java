package swu.zk.anntationproperty;

import org.junit.Test;
import swu.zk.beans.context.annotation.Component;
import swu.zk.beans.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Annotation;

/**
 * @Classname ApTest
 * @Description TODO
 * @Date 2022/4/14 9:57
 * @Created by brain
 */
public class ApTest {
    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }


    @Test
    public void test2(){
       Annotation annotation = UserDao.class.getAnnotation(Component.class);
        System.out.println(annotation instanceof Component );
    }
}
