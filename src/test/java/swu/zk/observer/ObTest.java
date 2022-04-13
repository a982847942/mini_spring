package swu.zk.observer;

import org.junit.Test;

/**
 * @Classname ObTest
 * @Description TODO
 * @Date 2022/4/13 9:54
 * @Created by brain
 */
public class ObTest {

    @Test
    public void test1(){
        RMBrate rmBrate = new RMBrate();
        rmBrate.addCompany(new ImportCompany());
        rmBrate.addCompany(new ExportCompany());
        rmBrate.change(10);
        rmBrate.change(-9);
    }
}
