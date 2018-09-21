package com.htht.huoy.module.file.service.impl;

import com.htht.huoy.module.file.model.FileInfo;
import com.htht.huoy.module.file.dao.IFileInfoDao;
import com.htht.huoy.module.file.service.IFileInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文件信息表 服务实现类
 * </p>
 *
 * @author wjx
 * @since 2018-09-20
 */
@Service
@Primary
public class FileInfoServiceImpl extends ServiceImpl<IFileInfoDao, FileInfo> implements IFileInfoService {

}
