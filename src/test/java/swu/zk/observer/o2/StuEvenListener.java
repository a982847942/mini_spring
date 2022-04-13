package swu.zk.observer.o2;

/**
 * @Classname StuEvenListener
 * @Description TODO
 * @Date 2022/4/13 10:09
 * @Created by brain
 */
public class StuEvenListener implements BellEventListener{
    @Override
    public void heardBell(RingEvent e) {
        if (e.isSound()){
            System.out.println("同学们，上课了...");
        } else {
            System.out.println("同学们，下课了...");
        }
    }
}
