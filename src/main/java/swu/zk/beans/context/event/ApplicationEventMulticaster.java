package swu.zk.beans.context.event;

import swu.zk.beans.context.ApplicationEvent;
import swu.zk.beans.context.ApplicationListener;

/**
 * @Classname ApplicationEventMulticaster
 * @Description TODO
 * @Date 2022/4/12 15:48
 * @Created by brain
 */
public interface ApplicationEventMulticaster {
    /**
     * Add a listener to be notified of all events.
     * @param listener the listener to add
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * Remove a listener from the notification list.
     * @param listener the listener to remove
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * Multicast the given application event to appropriate listeners.
     * @param event the event to multicast
     */
    void multicastEvent(ApplicationEvent event);
}
