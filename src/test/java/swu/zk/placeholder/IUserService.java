package swu.zk.placeholder;

/**
 * @Classname IUserService
 * @Description TODO
 * @Date 2022/4/13 16:00
 * @Created by brain
 */
public interface IUserService {
    String queryUserInfo();

    String register(String userName);
}
