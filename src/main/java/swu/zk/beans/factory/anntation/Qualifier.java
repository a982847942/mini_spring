package swu.zk.beans.factory.anntation;

import java.lang.annotation.*;

/**
 * @Classname Qualifier
 * @Description TODO
 * @Date 2022/4/14 9:33
 * @Created by brain
 */

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Qualifier {
    String value() default "";
}
