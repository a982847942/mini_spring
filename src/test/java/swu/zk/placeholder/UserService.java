package swu.zk.placeholder;

import swu.zk.beans.context.annotation.Component;
import swu.zk.beans.context.annotation.Repository;
import swu.zk.beans.context.annotation.Service;

import java.util.Random;

/**
 * @Classname UseService
 * @Description TODO
 * @Date 2022/4/13 16:00
 * @Created by brain
 */
@Service("userService")
public class UserService implements IUserService{
    private String token;

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "brain，100001，深圳";
    }

    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }

    @Override
    public String toString() {
        return "UserService#token = { " + token + " }";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
