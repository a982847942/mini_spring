package swu.zk.bean;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2022/4/8 20:52
 * @Created by brain
 */
public class UserService {

    private String uId;

    private UserDao userDao;

    public void queryUserInfo(){
        System.out.println("查询用户信息"  + userDao.queryUserName(uId));
    }

    public UserService() {
    }
    public UserService(String uId, UserDao userDao) {
        this.uId = uId;
        this.userDao = userDao;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }





}
