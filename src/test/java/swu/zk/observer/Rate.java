package swu.zk.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Rate
 * @Description TODO
 * @Date 2022/4/13 9:48
 * @Created by brain
 */
public abstract class Rate {
    List<Company> companies = new ArrayList<>();
    public void addCompany(Company company){
        companies.add(company);
    }
    //删除观察者方法
    public void remove(Company company) {
        companies.remove(company);
    }

    public abstract void change(int number);
}
