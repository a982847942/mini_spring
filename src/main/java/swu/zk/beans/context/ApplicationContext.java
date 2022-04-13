package swu.zk.beans.context;

import swu.zk.beans.factory.HierarchicalBeanFactory;
import swu.zk.beans.factory.ListableBeanFactory;
import swu.zk.io.ResourceLoader;

/**
 * @Classname ApplicationContext
 * @Description TODO
 * @Date 2022/4/9 20:22
 * @Created by brain
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {

}
