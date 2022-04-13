package swu.zk.observer.o2;

/**
 * @Classname TeacherEventListener
 * @Description TODO
 * @Date 2022/4/13 10:10
 * @Created by brain
 */
public class TeacherEventListener implements BellEventListener {
    @Override
    public void heardBell(RingEvent e) {
        if (e.isSound()) {
            System.out.println("老师上课了...");
        } else {
            System.out.println("老师下课了...");
        }
    }
}
