package swu.zk.beans.factory;

/**
 * @Classname BeanNameAware
 * @Description TODO
 * @Date 2022/4/11 15:09
 * @Created by brain
 */
public interface BeanNameAware extends Aware{
    void setBeanName(String name);
}
