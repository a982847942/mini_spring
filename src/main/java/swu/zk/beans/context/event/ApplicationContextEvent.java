package swu.zk.beans.context.event;

import swu.zk.beans.context.ApplicationContext;
import swu.zk.beans.context.ApplicationEvent;

/**
 * @Classname ApplicationContextEvent
 * @Description TODO
 * @Date 2022/4/12 15:45
 * @Created by brain
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * Get the <code>ApplicationContext</code> that the event was raised for.
     */
    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
