package com.htht.huoy.module.generator.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.htht.huoy.module.generator.dao.IGeneratorDao;
import com.htht.huoy.module.generator.model.Table;
import com.htht.huoy.module.generator.service.IGeneratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneratorService implements IGeneratorService {

    @Autowired
    private IGeneratorDao generatorDao;

    @Override
    public Page<Table> getTableList(String name, int pageNum, int pageSize) {
        Page<Table> page=PageHelper.startPage(pageNum,pageSize);
        generatorDao.getTableList(name);
        return page;
    }

    @Override
    public int getTableCount() {
        return generatorDao.getTableCount();
    }


}
