package swu.zk.bean;

import javafx.scene.input.DataFormat;
import swu.zk.beans.context.ApplicationListener;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname CustomEventListener
 * @Description TODO
 * @Date 2022/4/12 16:09
 * @Created by brain
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("收到：" + event.getSource() + "消息;时间：" + dateFormat.format(new Date()));
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }
}
