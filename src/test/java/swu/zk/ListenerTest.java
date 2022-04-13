package swu.zk;

import org.junit.Test;
import swu.zk.bean.CustomEvent;
import swu.zk.beans.context.support.ClassPathXmlApplicationContext;
import swu.zk.observer.o2.BellEventSource;
import swu.zk.observer.o2.StuEvenListener;
import swu.zk.observer.o2.TeacherEventListener;

import java.lang.reflect.InvocationHandler;

/**
 * @Classname ListenerTest
 * @Description TODO
 * @Date 2022/4/12 16:11
 * @Created by brain
 */
public class ListenerTest {
    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }

    @Test
    public void test_event2(){
        BellEventSource bellEventSource = new BellEventSource();
        bellEventSource.addListener(new StuEvenListener());
        bellEventSource.addListener(new TeacherEventListener());
        bellEventSource.ring(true);

    }


    @Test
    public void test3(){
        StringBuilder buffer = new StringBuilder("abcdefg");
        System.out.println(buffer.indexOf("b"));
        buffer.replace(1,4,"ha");
        System.out.println(buffer.toString());
    }

}
