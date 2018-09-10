package com.htht.huoy.module.generator.model;

public class Table {
    /**
     * 表名
     */
    private String tableName;
    /**
     * 表备注
     */
    private String tableComments;

    public String getTableName() {
        return tableName;
    }

    public String getTableComments() {
        return tableComments;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setTableComments(String tableComments) {
        this.tableComments = tableComments;
    }
}
