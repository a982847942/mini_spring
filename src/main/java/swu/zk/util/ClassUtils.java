package swu.zk.util;

/**
 * @Classname ClassUtils
 * @Description TODO
 * @Date 2022/4/9 14:14
 * @Created by brain
 */
public class ClassUtils {
    public static ClassLoader getDefaultClassloader() {
        ClassLoader c1 = null;
        try {
            c1 = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {
            // Cannot access thread context ClassLoader - falling back to system class loader...
        }
        if (c1 == null) {
            c1 = ClassUtils.class.getClassLoader();
        }
        return c1;
    }
}
