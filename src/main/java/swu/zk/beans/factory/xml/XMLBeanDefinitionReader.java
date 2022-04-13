package swu.zk.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
//import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import swu.zk.beans.BeansException;
import swu.zk.beans.PropertyValue;
import swu.zk.beans.context.annotation.ClassPathBeanDefinitionScanner;
import swu.zk.beans.factory.config.BeanDefinition;
import swu.zk.beans.factory.config.BeanReference;
import swu.zk.beans.factory.support.AbstractBeanDefinitionReader;
import swu.zk.beans.factory.support.BeanDefinitionRegistry;
import swu.zk.io.Resource;
import swu.zk.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Classname XMLBeanDefinitionReader
 * @Description TODO
 * @Date 2022/4/9 14:41
 * @Created by brain
 */
public class XMLBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public XMLBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XMLBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }



    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            try (InputStream inputStream = resource.getInputStream()) {
                doLoadBeanDefinitions(inputStream);
            }
        } catch (IOException | ClassNotFoundException | DocumentException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }


    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String[] locations) throws BeansException {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }


    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }


    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException, DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        org.dom4j.Element root = document.getRootElement();

        // 解析 context:component-scan 标签，扫描包中的类并提取相关信息，用于组装 BeanDefinition
        Element componentScan = root.element("component-scan");
        if (null != componentScan) {
            String scanPath = componentScan.attributeValue("base-package");
            if (StrUtil.isEmpty(scanPath)) {
                throw new BeansException("The value of base-package attribute can not be empty or null");
            }
            scanPackage(scanPath);
        }

        List<Element> beanList = root.elements("bean");
        for (Element bean : beanList) {

            String id = bean.attributeValue("id");
            String name = bean.attributeValue("name");
            String className = bean.attributeValue("class");
            String initMethod = bean.attributeValue("init-method");
            String destroyMethodName = bean.attributeValue("destroy-method");
            String beanScope = bean.attributeValue("scope");

            // 获取 Class，方便获取类中的名称
            Class<?> clazz = Class.forName(className);
            // 优先级 id > name
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            // 定义Bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            beanDefinition.setInitMethodName(initMethod);
            beanDefinition.setDestroyMethodName(destroyMethodName);

            if (StrUtil.isNotEmpty(beanScope)) {
                beanDefinition.setScope(beanScope);
            }

            List<Element> propertyList = bean.elements("property");
            // 读取属性并填充
            for (Element property : propertyList) {
                // 解析标签：property
                String attrName = property.attributeValue("name");
                String attrValue = property.attributeValue("value");
                String attrRef = property.attributeValue("ref");
                // 获取属性值：引入对象、值对象
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
                // 创建属性信息
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            // 注册 BeanDefinition
            getRegistry().registryBeanDefinition(beanName, beanDefinition);
        }
    }

    private void scanPackage(String scanPath) {
        String[] basePackages = StrUtil.splitToArray(scanPath, ',');
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(getRegistry());
        scanner.doScan(basePackages);
    }





//    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
//        /**
//         * 使用dom解析
//         */
//        Document doc = XmlUtil.readXML(inputStream);
//        Element root = doc.getDocumentElement();
//        NodeList childNodes = root.getChildNodes();
//
//        for (int i = 0; i < childNodes.getLength(); i++) {
//            // 判断元素
//            if (!(childNodes.item(i) instanceof Element)) continue;
//            // 判断对象
//            if (!"bean".equals(childNodes.item(i).getNodeName())) continue;
//
//            // 解析标签
//            Element bean = (Element) childNodes.item(i);
//            String id = bean.getAttribute("id");
//            String name = bean.getAttribute("name");
//            String className = bean.getAttribute("class");
//            String initMethod = bean.getAttribute("init-method");
//            String destroyMethodName = bean.getAttribute("destroy-method");
//            String beanScope = bean.getAttribute("scope");
//
//
//            // 获取 Class，方便获取类中的名称
//            Class<?> clazz = Class.forName(className);
//            // 优先级 id > name
//            String beanName = StrUtil.isNotEmpty(id) ? id : name;
//            if (StrUtil.isEmpty(beanName)) {
//                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
//            }
//
//            // 定义Bean
//            BeanDefinition beanDefinition = new BeanDefinition(clazz);
//            beanDefinition.setInitMethodName(initMethod);
//            beanDefinition.setDestroyMethodName(destroyMethodName);
//            if (StrUtil.isNotEmpty(beanScope)) {
//                beanDefinition.setScope(beanScope);
////               if (beanScope.equals("prototype")){
////                   beanDefinition.setSingleton(false);
////                   beanDefinition.setPrototype(true);
////               }
//            }
//
//            // 读取属性并填充
//            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
//                if (!(bean.getChildNodes().item(j) instanceof Element)) continue;
//                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) continue;
//                // 解析标签：property xml格式见resource目录
//                Element property = (Element) bean.getChildNodes().item(j);
//                String attrName = property.getAttribute("name");
//                String attrValue = property.getAttribute("value");
//                String attrRef = property.getAttribute("ref");
//                // 获取属性值：引入对象、值对象
//                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
//                // 创建属性信息
//                PropertyValue propertyValue = new PropertyValue(attrName, value);
//                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
//            }
//            if (getRegistry().containsBeanDefinition(beanName)) {
//                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
//            }
//            // 注册 BeanDefinition
//            getRegistry().registryBeanDefinition(beanName, beanDefinition);
//        }
//    }

}
