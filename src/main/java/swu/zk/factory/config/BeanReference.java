package swu.zk.factory.config;

/**
 * @Classname BeanReference
 * @Description TODO
 * @Date 2022/4/9 11:29
 * @Created by brain
 */
public class BeanReference {
    private String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

//    public void setBeanName(String beanName) {
//        this.beanName = beanName;
//    }

    public String getBeanName() {
        return beanName;
    }
}
