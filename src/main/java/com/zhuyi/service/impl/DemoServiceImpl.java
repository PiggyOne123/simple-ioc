package com.zhuyi.service.impl;

import com.zhuyi.dao.DemoDao;
import com.zhuyi.factoty.BeanFactory;
import com.zhuyi.service.DemoService;

import java.util.List;

/**
 * @author ZhuYi
 * @create 2024/6/16 18:19
 */
public class DemoServiceImpl implements DemoService {
    // 通过BeanFactory获取名为"demoDao"的Bean实例
    DemoDao demoDao = (DemoDao) BeanFactory.getBean("demoDao");

    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
}
