package com.basic_dl.lazyLookup;

import com.basic_dl.withanno.bean.Dog;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhuYi
 * @create 2024/7/16 8:31
 */
public class LazyLookupApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/basic_dl/lazylookup.xml");
        System.out.println(context.containsBean("dog"));

        //获取之前检查，containsBean();
        Dog dog = context.containsBean("dog") ? (Dog) context.getBean("dog") : new Dog();
        System.out.println(dog.toString());

//        Dog dog2 = context.getBean(Dog.class);
//        System.out.println(dog2.toString());

        //延迟查找,如果使用这种方式，运行 main 方法后发现并没有报错，只有调用 dogProvider 的 getObject ，真正要取包装里面的 Bean 时，才会报异常
        ObjectProvider<Dog> dogProvider = context.getBeanProvider(Dog.class);

        //延迟查找--方案实现
        Dog dog3 = dogProvider.getIfAvailable();
        if (dog3 == null) {
            System.out.println("------");
            dog3 = new Dog();
            System.out.println(dog3.toString());
        }

        System.out.println("----------");

        //这行代码使用Lambda表达式来创建一个Dog实例，
        // 并通过getIfAvailable方法检查dogProvider中是否已经存在一个Dog实例。
        // 如果不存在，则使用Lambda表达式创建一个新的Dog实例并返回。
        // 如果已经存在，则返回现有的Dog实例
        dogProvider.getIfAvailable(() -> new Dog());
        //方法引用
        //这行代码使用方法引用来创建一个Dog实例，
        // 并通过getIfAvailable方法检查dogProvider中是否已经存在一个Dog实例。
        // 与上一行代码相同，如果不存在，则使用方法引用创建一个新的Dog实例并返回。
        // 如果已经存在，则返回现有的Dog实例。方法引用是Lambda表达式的另一种写法，
        dogProvider.getIfAvailable(Dog::new);
        //Bean存在时执行Consumer接口的方法
        //这行代码使用Lambda表达式来定义一个Consumer接口的实现，该
        // 实现将打印传入的Dog实例。
        // ifAvailable方法检查dogProvider中是否存在一个Dog实例。
        // 如果存在，则将该实例传递给Lambda表达式定义的Consumer接口实现，
        // 并执行其中的方法。如果不存在，则不执行任何操作。
        dogProvider.ifAvailable(dog4 -> System.out.println(dog4));

    }
}
