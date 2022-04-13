package swu.zk.beans.context;

import java.util.EventObject;

/**
 * @Classname ApplicationEvent
 * @Description TODO
 * @Date 2022/4/12 15:43
 * @Created by brain
 */
public abstract class ApplicationEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
