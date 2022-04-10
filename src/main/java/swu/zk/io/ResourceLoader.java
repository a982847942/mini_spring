package swu.zk.io;

/**
 * @Classname ResourceLoader
 * @Description TODO
 * @Date 2022/4/9 14:25
 * @Created by brain
 */
public interface ResourceLoader {
   String CLASS_PATH_PREFIX = "classpath:";

   Resource getResource(String location);
}
