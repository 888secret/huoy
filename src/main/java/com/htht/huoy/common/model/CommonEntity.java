package com.htht.huoy.common.model;

import com.baomidou.mybatisplus.activerecord.Model;

public abstract class CommonEntity<T extends Model<?>> extends Model<T> {
    private static final long serialVersionUID=1L;

    /**
     * 用户ID
     */
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
