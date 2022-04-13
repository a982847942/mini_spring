package swu.zk.placeholder;

import org.junit.Test;
import swu.zk.beans.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname plTest
 * @Description TODO
 * @Date 2022/4/13 16:01
 * @Created by brain
 */
public class plTest {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService);
    }

    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }
}
