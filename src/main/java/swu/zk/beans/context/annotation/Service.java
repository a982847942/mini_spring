package swu.zk.beans.context.annotation;

import java.lang.annotation.*;

/**
 * @Classname Service
 * @Description TODO
 * @Date 2022/4/13 18:49
 * @Created by brain
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Service {
    String value() default "";
}
