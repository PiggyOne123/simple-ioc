package com.zhuyi.factoty;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * @author ZhuYi
 * @create 2024/6/16 18:29
 */
public class BeanFactory {

    private static Properties property;
    //缓存，构造单例模式
    private static HashMap<String, Object> beanMap = new HashMap<>();

    static {
        //从配置文件中获取类的全类名
        property = new Properties();
        try {
            // 从类路径下加载bean.properties文件，并将其属性加载到property对象中
            property.load(BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties"));
        } catch (IOException e) {
            // BeanFactory类的静态初始化都失败了，那后续也没有必要继续执行了
            throw new ExceptionInInitializerError("BeanFactory initialize error, cause: " + e.getMessage());
        }

    }

    /**
     * 根据bean的名称获取实例对象。
     * 该方法通过反射机制，根据bean的名称从属性文件中获取对应的类名，然后实例化该类并返回其对象。
     * 这种方式允许在运行时动态地创建和使用不同的bean实例，提高了系统的灵活性和可配置性。
     *
     * @param beanName bean的名称，对应属性文件中的键，用于查找类名。
     * @return 根据beanName实例化的对象。
     * @throws RuntimeException 如果找不到对应的类或者实例化对象时发生错误，则抛出运行时异常。
     */
    public static Object getBean(String beanName) {
        //双检锁，执行双重检测是因为，如果多个线程通过了第一次检测，此时因为synchronized，
        //其中一个线程会首先通过了第二次检测并实例化了对象，剩余的线程不会再重复实例化对象。

        //双检锁，确保单例
        if (!beanMap.containsKey(beanName)) {
            synchronized (BeanFactory.class) {
                if (!beanMap.containsKey(beanName)) {
                    try {
                        // 通过类名从属性文件中获取对应的类，并实例化该类返回其对象。
                        Class<?> bean = Class.forName(property.getProperty(beanName));
                        return bean.newInstance();
                    } catch (ClassNotFoundException e) {
                        // 如果找不到类，则抛出运行时异常，并附带错误信息。
                        throw new RuntimeException("Bean " + beanName + " not found!", e);
                    } catch (InstantiationException | IllegalAccessException e) {
                        // 如果实例化类时发生错误，则抛出运行时异常，并附带错误信息。
                        throw new RuntimeException("Bean factory cannot be instantiated!", e);
                    }
                }
            }
        }
        //如果已经实例化，则直接返回
        return beanMap.get(beanName);
    }

}
