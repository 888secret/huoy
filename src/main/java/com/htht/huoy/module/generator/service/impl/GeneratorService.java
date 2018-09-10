package com.htht.huoy.module.generator.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo<Table> getTableList(int pageNum, int pageSize,String name) {
        PageHelper.startPage(pageNum,pageSize);
        List<Table> list=generatorDao.getTableList(name);
        PageInfo<Table> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int getTableCount() {
        return generatorDao.getTableCount();
    }


}
