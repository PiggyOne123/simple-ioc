package com.basic_dl.annotationContext;

import com.basic_dl.annotationContext.config.QuickStartConfiguration;
import com.basic_dl.annotationContext.config.ScanCofiguration;
import com.basic_dl.set.bean.Cat;
import com.basic_dl.set.bean.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhuYi
 * @create 2024/7/16 17:55
 */
public class AnnotionConfigApplication {
    public static void main(String[] args) {
        //注解驱动ioc容器
        ApplicationContext ctx = new AnnotationConfigApplicationContext(QuickStartConfiguration.class);
        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
        //注解驱动的依赖注入
        Cat cat = (Cat) ctx.getBean("cat");
        System.out.println(cat);

        System.out.println("------------");

        //组件扫描
        ApplicationContext context = new AnnotationConfigApplicationContext(ScanCofiguration.class);
//        ApplicationContext context= new AnnotationConfigApplicationContext("com.basic_dl.set.bean");
        Person person2 = (Person) ctx.getBean("person");
        System.out.println(person2);
        Cat cat2 = (Cat) ctx.getBean("cat");
        System.out.println(cat2);

        System.out.println("------------");

        //xml配置组件扫描
//        BeanFactory context1 = new ClassPathXmlApplicationContext("/basic_dl/scan.xml");
//        Person person3 = context1.getBean(Person.class);
//        System.out.println(person3);
//        Cat cat3 = context1.getBean(Cat.class);
//        System.out.println(cat3);

    }
}
