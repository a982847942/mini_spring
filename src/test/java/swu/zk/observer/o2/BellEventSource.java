package swu.zk.observer.o2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname BellEventSource
 * @Description TODO
 * @Date 2022/4/13 10:05
 * @Created by brain
 */
public class BellEventSource {
    List<BellEventListener> listeners = new ArrayList<>();
    public void addListener(BellEventListener listener){
        this.listeners.add(listener);
    }
    public void removeListener(BellEventListener listener){
        this.listeners.remove(listener);
    }

    public void ring(boolean sound){
        String type = sound ? "上课铃" : "下课铃";
        System.out.println(type + "响！");
        RingEvent ringEvent = new RingEvent(this, sound);
        notifies(ringEvent);
    }

    private void notifies(RingEvent ringEvent) {
        this.listeners.forEach(listener -> listener.heardBell(ringEvent));
    }

}
