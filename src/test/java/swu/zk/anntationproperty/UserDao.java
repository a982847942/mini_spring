package swu.zk.anntationproperty;

import swu.zk.beans.context.annotation.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname UserDao
 * @Description TODO
 * @Date 2022/4/14 9:50
 * @Created by brain
 */
@Component("userDaom")
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "brain，河南，南阳");
        hashMap.put("10002", "pa，山东，青岛");
        hashMap.put("10003", "xixi，上海，浦东");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
