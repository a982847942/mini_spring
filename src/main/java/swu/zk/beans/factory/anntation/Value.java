package swu.zk.beans.factory.anntation;

import java.lang.annotation.*;

/**
 * @Classname Value
 * @Description TODO
 * @Date 2022/4/14 9:34
 * @Created by brain
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {
    /**
     * The actual value expression: e.g. "#{systemProperties.myProp}".
     */
    String value();
}
