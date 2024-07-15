package com.basic_dl.ofType.dao.impl;

import com.basic_dl.ofType.dao.DemoDao;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ZhuYi
 * @create 2024/7/15 18:57
 */
public class PostgreDaoImpl implements DemoDao {
    @Override
    public List<String> findAll() {
        return Arrays.asList("6", "7", "8", "9", "10");
    }
}
