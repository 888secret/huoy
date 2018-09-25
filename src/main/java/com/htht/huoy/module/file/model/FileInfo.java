package com.htht.huoy.module.file.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * <p>
 * 文件信息表
 * </p>
 *
 * @author wjx
 * @since 2018-09-20
 */

@TableName("TB_FILE_INFO")
@Document(indexName = "hyjc",type="fileInfo",shards = 5,replicas = 1,indexStoreType = "fs",refreshInterval = "-1")
public class FileInfo{

    private static final long serialVersionUID = 1L;

    /**
     * 文件主键ID
     */
    @TableId(value = "FILE_ID",type = IdType.UUID)
    @Id
    private String fileId;
    /**
     * 文件夹ID
     */
    @TableField("FOLDER_ID")
    private String folderId;
    /**
     * 文件路径
     */
    @TableField("FILE_PATH")
    private String filePath;
    /**
     * 文件名称
     */
    @TableField("FILE_NAME")
    private String fileName;
    /**
     * 是否删除
     */
    @TableField("IS_DELETE")
    private String isDelete;
    /**
     * 是否锁定
     */
    @TableField("IS_LOCK")
    private String isLock;
    /**
     * 文件类型
     */
    @TableField("FILE_TYPE")
    private String fileType;
    /**
     * 文件大小（kb）
     */
    @TableField("FILE_SIZE")
    private Double fileSize;
    /**
     * 更新时间
     */
    @TableField("UPDATE_TIME")
    @Field(format = DateFormat.date_time,index = FieldIndex.no,store = true,type = FieldType.Object)
    private Date updateTime;
    /**
     * 文档内容
     */
    @TableField(exist=false)
    private String content;


    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getIsLock() {
        return isLock;
    }

    public void setIsLock(String isLock) {
        this.isLock = isLock;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Double getFileSize() {
        return fileSize;
    }

    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
        "fileId=" + fileId +
        ", folderId=" + folderId +
        ", filePath=" + filePath +
        ", fileName=" + fileName +
        ", isDelete=" + isDelete +
        ", isLock=" + isLock +
        ", fileType=" + fileType +
        ", fileSize=" + fileSize +
        ", updateTime=" + updateTime +
        "}";
    }
}
