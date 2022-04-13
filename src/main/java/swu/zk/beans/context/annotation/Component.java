package swu.zk.beans.context.annotation;

import java.lang.annotation.*;

/**
 * @Classname Component
 * @Description TODO
 * @Date 2022/4/13 15:32
 * @Created by brain
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public  @interface Component {
    String value() default "";
}
