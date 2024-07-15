package com.basic_dl.ofType.dao.impl;

import com.basic_dl.ofType.dao.DemoDao;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ZhuYi
 * @create 2024/7/15 18:57
 */
public class OracleDaoImpl implements DemoDao {
    @Override
    public List<String> findAll() {
        return Arrays.asList("a", "b", "c", "d", "e");
    }
}
