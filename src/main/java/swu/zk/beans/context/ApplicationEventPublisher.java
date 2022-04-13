package swu.zk.beans.context;

/**
 * @Classname ApplicationEventPublisher
 * @Description TODO
 * @Date 2022/4/12 15:58
 * @Created by brain
 */
public interface ApplicationEventPublisher {
    /**
     * Notify all listeners registered with this application of an application
     * event. Events may be framework events (such as RequestHandledEvent)
     * or application-specific events.
     * @param event the event to publish
     */
    void publishEvent(ApplicationEvent event);
}
