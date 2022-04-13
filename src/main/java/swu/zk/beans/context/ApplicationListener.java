package swu.zk.beans.context;

import java.util.EventListener;

/**
 * @Classname ApplicationListener
 * @Description 泛型E接收 ApplicationEvent本身或其子类
 * @Date 2022/4/12 15:55
 * @Created by brain
 *
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    /**
     * Handle an application event.
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);

}
