package swu.zk;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname PropertyValues
 * @Description TODO
 * @Date 2022/4/9 11:12
 * @Created by brain
 */
public class PropertyValues {
    /**
     * 线性查找的容器，如果属性特别多，get操作也很多可能存在效率问题？
     * 可以改变容器选择，hash等
     */
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue){
        this.propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue propertyValue : this.propertyValueList) {
            if (propertyName.equals(propertyValue.getName())){
                return propertyValue;
            }
        }
        return null;
    }
}
