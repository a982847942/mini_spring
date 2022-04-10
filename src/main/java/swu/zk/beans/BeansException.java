package swu.zk.beans;

/**
 * @Classname BeansException
 * @Description TODO
 * @Date 2022/4/8 21:28
 * @Created by brain
 */
public class BeansException extends RuntimeException{
    public BeansException(String msg){
        super(msg);
    }
    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
