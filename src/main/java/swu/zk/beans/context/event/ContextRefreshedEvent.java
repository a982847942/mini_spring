package swu.zk.beans.context.event;

import swu.zk.beans.context.ApplicationEvent;

/**
 * @Classname ContextRefreshedEvent
 * @Description TODO
 * @Date 2022/4/12 15:47
 * @Created by brain
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }

}
