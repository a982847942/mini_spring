# mini_spring
一个简化版的Spring：
1.实现了bean的配置 加载 初始化包含容器事件和事件监听器
2.实现了spring中对循环问题的解决方案
3.支持AOP
4.支持注解
5.有相应的Aware以及BeanFactoryPostProcessor BeanPostProcessor的扩展
6.支持FactoryBean

未完成功能：
1.没有对XML做相应的DTD XSD约束
2.XML支持的属性和标签个数有限  不支持Spring中的非默认命名空间的标签
3.Configuration注解未做相应实现
4.事务等功能未做响应实现

