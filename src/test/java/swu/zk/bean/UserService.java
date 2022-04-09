package swu.zk.bean;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2022/4/8 20:52
 * @Created by brain
 */
public class UserService {
    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public UserService() {
    }

    public void queryUserInfo(){
        System.out.println("查询用户信息" + name);
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }
}
