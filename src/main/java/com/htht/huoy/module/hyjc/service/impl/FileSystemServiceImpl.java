package com.htht.huoy.module.hyjc.service.impl;

import com.htht.huoy.module.hyjc.model.FileSystem;
import com.htht.huoy.module.hyjc.dao.IFileSystemDao;
import com.htht.huoy.module.hyjc.service.IFileSystemService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文件系统表 服务实现类
 * </p>
 *
 * @author wjx
 * @since 2018-09-19
 */
@Service
@Primary
public class FileSystemServiceImpl extends ServiceImpl<IFileSystemDao, FileSystem> implements IFileSystemService {

}
