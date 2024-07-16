package com.basic_dl.annotationContext;

import com.basic_dl.annotationContext.config.QuickStartConfiguration;
import com.basic_dl.set.bean.Cat;
import com.basic_dl.set.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
    }
}
