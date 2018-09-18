package com.htht.huoy.module.hyjc.dao;

import com.htht.huoy.module.hyjc.model.FileSystem;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileSystemRepository extends MongoRepository<FileSystem,String> {

    FileSystem save(FileSystem fileSystem);
}
