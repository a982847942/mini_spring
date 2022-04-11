package swu.zk.beans.context;

import swu.zk.beans.BeansException;
import swu.zk.beans.factory.Aware;

/**
 * @Classname ApplicationContextAware
 * @Description TODO
 * @Date 2022/4/11 15:09
 * @Created by brain
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
