package swu.zk.beans.context.annotation;

import java.lang.annotation.*;

/**
 * @Classname Repository
 * @Description TODO
 * @Date 2022/4/13 19:03
 * @Created by brain
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Repository {
    String value() default "";
}
