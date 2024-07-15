package com.basic_dl.ofType;

import com.basic_dl.ofType.dao.DemoDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author ZhuYi
 * @create 2024/7/15 18:55
 */
public class OfTypeApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/basic_dl/oftype.xml");
        Map<String, DemoDao> beansOfType = context.getBeansOfType(DemoDao.class);
        beansOfType.forEach((beanName, bean) -> {
            System.out.println(beanName + ":" + bean.toString());
        });
    }
}
