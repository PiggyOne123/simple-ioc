package com.basic_dl.bytype;

import com.basic_dl.bytype.bean.Person;
import com.basic_dl.bytype.dao.DemoDao;
import com.basic_dl.bytype.dao.impl.DemoDaoImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhuYi
 * @create 2024/7/15 18:16
 */
public class BytypeApplication {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("/basic_dl/bytype.xml");
        Person bean = factory.getBean(Person.class);
        System.out.println("Person：");
        System.out.println(bean);

        System.out.println("DemoDaoImpl：");
        DemoDao demoDao = factory.getBean(DemoDaoImpl.class);
        System.out.println(demoDao.findAll());
    }
}
