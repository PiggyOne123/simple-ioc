package com.basic_dl.byname;

import com.basic_dl.byname.bean.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhuYi
 * @create 2024/7/15 17:55
 */
public class BynameApplication {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("basic_dl/byname.xml");
        Person person= (Person) factory.getBean("person");
        System.out.println("bean的全限定名和内存地址：");
        System.out.println(person);
    }
}
