package swu.zk;

import cn.hutool.core.io.IoUtil;
import org.junit.Before;
import org.junit.Test;
import swu.zk.bean.UserService;
import swu.zk.beans.factory.support.DefaultListableBeanFactory;
import swu.zk.beans.factory.xml.XMLBeanDefinitionReader;
import swu.zk.io.DefaultResourceLoader;
import swu.zk.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname IOTest
 * @Description TODO
 * @Date 2022/4/9 15:04
 * @Created by brain
 */
public class IOTest {

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
//        String content = IoUtil.readUtf8(inputStream);
        String content = IoUtil.read(inputStream, "utf-8");
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/main/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
//        String content = IoUtil.readUtf8(inputStream);
        String content = IoUtil.read(inputStream, "utf-8");
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/important.properties");
        InputStream inputStream = resource.getInputStream();
//        String content = IoUtil.readUtf8(inputStream);
        String content = IoUtil.read(inputStream, "utf-8");
        System.out.println(content);
    }


    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XMLBeanDefinitionReader reader = new XMLBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取Bean对象调用方法
        UserService userService = (UserService) beanFactory.getBean("userService");
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
}
