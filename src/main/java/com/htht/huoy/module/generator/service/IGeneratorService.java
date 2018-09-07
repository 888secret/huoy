package com.htht.huoy.module.generator.service;

import com.htht.huoy.module.generator.model.Table;

import java.util.List;

public interface IGeneratorService {
    int getTableCount();

    List<Table> getTableList(String name,int pageNum,int pageSize);
}
