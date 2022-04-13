package swu.zk.observer;

/**
 * @Classname RMBrate
 * @Description TODO
 * @Date 2022/4/13 9:50
 * @Created by brain
 */
public class RMBrate extends Rate{
    @Override
    public void change(int number) {
        this.companies.forEach(company -> company.response(number));
    }
}
