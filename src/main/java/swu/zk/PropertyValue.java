package swu.zk;

/**
 * @Classname PropertyValues
 * @Description TODO
 * @Date 2022/4/9 11:11
 * @Created by brain
 */
public class PropertyValue {
    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
