package com.htht.huoy.module.hyjc.service;

import com.htht.huoy.module.hyjc.dao.FileSystemRepository;
import com.htht.huoy.module.hyjc.model.FileSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class HyjcService {

    @Autowired
    private FileSystemRepository respository;

    public void saveList(){
        FileSystem fs=new FileSystem();
        fs.setId(UUID.randomUUID().toString().replaceAll("-",""));
        fs.setCreateTime(new Date());
        fs.setDelete(false);
        fs.setFile(false);
        fs.setFileName("");
        fs.setFilePath("D://hyjc");
        fs.setLock(false);
        fs.setParentId("");
        respository.save(fs);

    }
}
