package swu.zk.observer.o2;

import java.util.EventObject;

/**
 * @Classname RingEvent
 * @Description TODO
 * @Date 2022/4/13 10:03
 * @Created by brain
 */
public class RingEvent extends EventObject {
    private static final long serialVersionUID = 1L;
    private boolean sound;
    public RingEvent(Object source,boolean sound) {
        super(source);
        this.sound = sound;
    }

    public boolean isSound() {
        return sound;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }
}
