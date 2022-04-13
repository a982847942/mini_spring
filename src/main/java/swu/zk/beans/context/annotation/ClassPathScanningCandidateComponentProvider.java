package swu.zk.beans.context.annotation;

import cn.hutool.core.util.ClassUtil;
import swu.zk.beans.factory.config.BeanDefinition;
import swu.zk.util.ClassUtils;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Classname ClassPathScanningCandidateComponentProvider
 * @Description TODO
 * @Date 2022/4/13 15:34
 * @Created by brain
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        Set<Class<?>> tempClasses = ClassUtil.scanPackageByAnnotation(basePackage, Service.class);
        classes.addAll(tempClasses);
        tempClasses = ClassUtil.scanPackageByAnnotation(basePackage,Repository.class);
        classes.addAll(tempClasses);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
