package swu.zk.beans.context.event;

import swu.zk.beans.context.ApplicationEvent;
import swu.zk.beans.context.ApplicationListener;
import swu.zk.beans.factory.BeanFactory;

/**
 * @Classname SimpleApplicationEventMulticaster
 * @Description TODO
 * @Date 2022/4/12 16:05
 * @Created by brain
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{
    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
