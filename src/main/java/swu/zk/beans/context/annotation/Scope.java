package swu.zk.beans.context.annotation;

import java.lang.annotation.*;

/**
 * @Classname Scope
 * @Description TODO
 * @Date 2022/4/13 15:31
 * @Created by brain
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {
    String value() default "singleton";
}
