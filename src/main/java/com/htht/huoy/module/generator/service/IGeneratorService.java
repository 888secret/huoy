package com.htht.huoy.module.generator.service;

import com.github.pagehelper.PageInfo;
import com.htht.huoy.module.generator.model.Table;

public interface IGeneratorService {
    int getTableCount();

    PageInfo<Table> getTableList(int pageNum, int pageSize, String name);
}
