package com.htht.huoy.module.hyjc.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 文件夹树表
 * </p>
 *
 * @author wjx
 * @since 2018-09-19
 */
@TableName("TB_FILE_SYSTEM")
public class FileSystem {

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
    public String toString() {
        return "FileSystem{" +
        "id=" + id +
        ", parentId=" + parentId +
        ", userId=" + userId +
        ", projectId=" + projectId +
        ", nodeName=" + nodeName +
        ", createTime=" + createTime +
        ", folderName=" + folderName +
        "}";
    }
}
