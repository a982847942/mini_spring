package swu.zk.beans.context.event;

import swu.zk.beans.context.ApplicationEvent;

/**
 * @Classname ContextClosedEvent
 * @Description TODO
 * @Date 2022/4/12 15:46
 * @Created by brain
 */
public class ContextClosedEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
