package swu.zk.factory.config;

/**
 * @Classname BeanDedinition
 * @Description TODO
 * @Date 2022/4/8 20:47
 * @Created by brain
 */

import swu.zk.PropertyValues;

/**
 * 对bean的映射，包括bean对应的class(交给容器去创建 不要自己手动new)以及 后续的id 等
 */
public class BeanDefinition {
    private Class beanClass;
    private PropertyValues propertyValues;


    public BeanDefinition(Class beanDefinition) {
        this.beanClass = beanDefinition;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues == null ? new PropertyValues():propertyValues;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
