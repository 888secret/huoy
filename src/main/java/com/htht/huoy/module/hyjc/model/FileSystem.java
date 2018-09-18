package com.htht.huoy.module.hyjc.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class FileSystem {

    @Id
    private String id;

    private String fileName;
    private String filePath;
    private boolean isFile;
    private String parentId;
    private Date createTime;
    private boolean isDelete;
    private boolean isLock;

    public String getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public boolean isFile() {
        return isFile;
    }

    public String getParentId() {
        return parentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public boolean isLock() {
        return isLock;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setFile(boolean file) {
        isFile = file;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public void setLock(boolean lock) {
        isLock = lock;
    }
}
