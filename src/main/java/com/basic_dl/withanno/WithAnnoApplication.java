package com.basic_dl.withanno;

import com.basic_dl.withanno.anno.Color;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author ZhuYi
 * @create 2024/7/15 19:33
 */
public class WithAnnoApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/basic_dl/withanno.xml");

        Map<String, Object> beans = context.getBeansWithAnnotation(Color.class);
        beans.forEach((beanName,bean)->{
            System.out.println(beanName + ":" + bean.toString());
        });

        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }

    }
}
