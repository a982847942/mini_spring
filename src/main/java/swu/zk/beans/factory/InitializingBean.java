package swu.zk.beans.factory;

/**
 * @Classname InitializingBean
 * @Description TODO
 * @Date 2022/4/11 10:04
 * @Created by brain
 */
public interface InitializingBean {

    /**
     * Bean 处理了属性填充后调用
     *
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
