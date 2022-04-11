package swu.zk.beans.factory;

/**
 * @Classname DisposableBean
 * @Description TODO
 * @Date 2022/4/11 10:05
 * @Created by brain
 */
public interface DisposableBean {
    void destroy() throws Exception;
}
