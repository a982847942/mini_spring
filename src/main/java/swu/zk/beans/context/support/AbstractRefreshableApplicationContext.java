package swu.zk.beans.context.support;

import swu.zk.beans.BeansException;
import swu.zk.beans.factory.ConfigurableListableBeanFactory;
import swu.zk.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Classname AbstractRefreshableApplicationContext
 * @Description TODO
 * @Date 2022/4/9 20:50
 * @Created by brain
 */
public abstract class AbstractRefreshableApplicationContext  extends AbstractApplicationContext{
    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
