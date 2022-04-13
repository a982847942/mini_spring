package swu.zk.beans.context.annotation;

import cn.hutool.core.util.StrUtil;
import swu.zk.beans.factory.config.BeanDefinition;
import swu.zk.beans.factory.support.BeanDefinitionRegistry;

import java.util.Set;

/**
 * @Classname ClassPathBeanDefinitionScanne
 * @Description TODO
 * @Date 2022/4/13 15:35
 * @Created by brain
 */
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider {

    private BeanDefinitionRegistry registry;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }


    /**
     * 扫描basePackages下的注解  findCandidateComponents()扫描包含Component注解的类并包装为BeanDefinition对象返回
     *
     * @param basePackages
     */
    public void doScan(String... basePackages) {
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
            for (BeanDefinition beanDefinition : candidates) {
                // 解析 Bean 的作用域 singleton、prototype
                String beanScope = resolveBeanScope(beanDefinition);
                if (StrUtil.isNotEmpty(beanScope)) {
                    beanDefinition.setScope(beanScope);
                }
                //注册到beanDefinitionMap<beanName,Definition>
                registry.registryBeanDefinition(determineBeanName(beanDefinition), beanDefinition);
            }
        }
    }

    private String resolveBeanScope(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Scope scope = beanClass.getAnnotation(Scope.class);
        if (null != scope) return scope.value();
        return StrUtil.EMPTY;
    }

    private String determineBeanName(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        String value = null;
        if (beanClass.isAssignableFrom(Component.class)){
            Component component = beanClass.getAnnotation(Component.class);
            value = component.value();
        }else if (beanClass.isAssignableFrom(Service.class)){
            Service service = beanClass.getAnnotation(Service.class);
            value = service.value();
        }else if (beanClass.isAssignableFrom(Repository.class)){
            Repository repository = beanClass.getAnnotation(Repository.class);
            value = repository.value();
        }
        if (StrUtil.isEmpty(value)) {
            value = StrUtil.lowerFirst(beanClass.getSimpleName());
        }
        return value;
    }

}
