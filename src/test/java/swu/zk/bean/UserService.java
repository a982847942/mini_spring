package swu.zk.bean;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2022/4/8 20:52
 * @Created by brain
 */
public class UserService {

    private String uId;
    private String company;
    private String location;
    private UserDao userDao;

    public UserService() {
    }

    public UserService(String uId, String company, String location, UserDao userDao) {
        this.uId = uId;
        this.company = company;
        this.location = location;
        this.userDao = userDao;
    }

    public String queryUserInfo() {
        return userDao.queryUserName(uId);
    }


    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "uId='" + uId + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", userDao=" + userDao +
                '}';
    }
}
