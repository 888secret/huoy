package com.htht.huoy.module.hyjc.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htht.huoy.common.model.CommonEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 文件系统表
 * </p>
 *
 * @author wjx
 * @since 2018-09-19
 */
@TableName("TB_FILE_SYSTEM")
public class FileSystem extends CommonEntity<FileSystem> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "ID",type = IdType.UUID)
    private String id;
    /**
     * 父节点ID
     */
    @TableField("PARENT_ID")
    private String parentId;
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
     * 是否是文件
     */
    @TableField("IS_FILE")
    private String isFile;
    /**
     * 用户ID
     */
    @TableField("USER_ID")
    private String userId;
    /**
     * 项目ID
     */
    @TableField("PROJECT_ID")
    private String projectId;
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
     * 文件大小
     */
    @TableField("FILE_SIZE")
    private Double fileSize;
    /**
     * 节点名称
     */
    @TableField("NODE_NAME")
    private String nodeName;
    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;
    /**
     * 文件夹名称
     */
    @TableField("FOLDER_NAME")
    private String folderName;

    /**
     * 是否可编辑
     */
    @TableField("IS_EDIT")
    private String isEdit;


    @TableField(exist=false)
    private List<FileSystem> childList;

    public void setChildList(List<FileSystem> childList) {
        this.childList = childList;
    }

    public List<FileSystem> getChildList() {

        return childList;
    }

    public void setIsEdit(String isEdit) {
        this.isEdit = isEdit;
    }

    public String getIsEdit() {

        return isEdit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public String getIsFile() {
        return isFile;
    }

    public void setIsFile(String isFile) {
        this.isFile = isFile;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
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

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "FileSystem{" +
        "id=" + id +
        ", parentId=" + parentId +
        ", filePath=" + filePath +
        ", fileName=" + fileName +
        ", isFile=" + isFile +
        ", userId=" + userId +
        ", projectId=" + projectId +
        ", isDelete=" + isDelete +
        ", isLock=" + isLock +
        ", fileType=" + fileType +
        ", fileSize=" + fileSize +
        ", nodeName=" + nodeName +
        ", createTime=" + createTime +
        ", folderName=" + folderName +
        "}";
    }
}
