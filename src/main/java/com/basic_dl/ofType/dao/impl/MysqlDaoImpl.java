package com.basic_dl.ofType.dao.impl;

import com.basic_dl.ofType.dao.DemoDao;

import java.util.Arrays;
import java.util.List;

/**
 * @author ZhuYi
 * @create 2024/6/16 18:16
 */
public class MysqlDaoImpl implements DemoDao {

    @Override
    public List<String> findAll() {
        return Arrays.asList("1", "2", "3", "4", "5");
    }
}
