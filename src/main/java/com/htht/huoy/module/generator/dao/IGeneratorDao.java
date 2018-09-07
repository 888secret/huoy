package com.htht.huoy.module.generator.dao;

import com.htht.huoy.module.generator.model.Table;

import java.util.List;

public interface IGeneratorDao {

    int getTableCount();
    List<Table> getTableList(String name);
}
