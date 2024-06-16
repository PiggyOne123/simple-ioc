package service.impl;

import dao.DemoDao;
import dao.impl.DemoDaoImpl;
import service.DemoService;

import java.util.Collections;
import java.util.List;

/**
 * @author ZhuYi
 * @create 2024/6/16 18:19
 */
public class DemoServiceImpl implements DemoService {
    private DemoDao demoDao = new DemoDaoImpl();

    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
}
