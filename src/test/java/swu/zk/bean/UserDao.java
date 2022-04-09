package swu.zk.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname UserDao
 * @Description TODO
 * @Date 2022/4/9 11:40
 * @Created by brain
 */
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "brain");
        hashMap.put("10002", "陈士硕");
        hashMap.put("10003", "shell");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
