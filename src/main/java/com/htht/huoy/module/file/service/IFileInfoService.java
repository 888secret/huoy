package com.htht.huoy.module.file.service;

import com.htht.huoy.module.file.model.FileInfo;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 文件信息表 服务类
 * </p>
 *
 * @author wjx
 * @since 2018-09-20
 */
public interface IFileInfoService extends IService<FileInfo> {

    /**
     * 写入
     * @param fileInfo
     * @return
     */
    String saveFileInfo(FileInfo fileInfo);

    /**
     * 删除，并未真正删除，只是查询不到
     * @param id
     */
    void deleteFileInfo(String id);

    /**
     * 根据主键id查询
     * @param id
     * @return
     */
    FileInfo findFileInfo(String id);

    /**
     * 分页查询
     * @return
     */
    List<FileInfo> findFileInfoPageable();

    List<FileInfo> findFileInfoAll();

    List<FileInfo> findFileInfoSort();

    List<FileInfo> like(String content);

    String update(String id);
}
