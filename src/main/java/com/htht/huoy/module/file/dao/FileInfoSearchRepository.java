package com.htht.huoy.module.file.dao;


import com.htht.huoy.module.file.model.FileInfo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface FileInfoSearchRepository extends ElasticsearchRepository<FileInfo,String> {

}
