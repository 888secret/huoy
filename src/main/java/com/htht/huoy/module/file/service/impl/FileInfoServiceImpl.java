package com.htht.huoy.module.file.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.htht.huoy.module.file.dao.FileInfoSearchRepository;
import com.htht.huoy.module.file.dao.IFileInfoDao;
import com.htht.huoy.module.file.model.FileInfo;
import com.htht.huoy.module.file.service.IFileInfoService;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    private final int page=0;
    private final int size=10;
    //权重求和模式
    private final String SCORE_MODE_SUM="sum";
    //由于无相关性的分值默认为1，设置权重最小值为10
    private final Float MIN_SCORE=10.0F;

    Pageable pageable=new PageRequest(page,size);

    @Autowired
    private FileInfoSearchRepository repository;

    @Override
    public String saveFileInfo(FileInfo fileInfo) {

        FileInfo result= repository.save(fileInfo);
        return result.getFileId();
    }

    @Override
    public void deleteFileInfo(String id) {
        repository.delete(id);
    }

    @Override
    public FileInfo findFileInfo(String id) {

        return repository.findOne(id);
    }

    @Override
    public List<FileInfo> findFileInfoPageable() {
        return repository.findAll(pageable).getContent();
    }

    @Override
    public List<FileInfo> findFileInfoAll() {
        Iterable<FileInfo> ite=repository.findAll();
        List<FileInfo> list=new ArrayList<>();
        for(FileInfo fileInfo:ite){
            list.add(fileInfo);
        }

        return list;
    }

    @Override
    public List<FileInfo> findFileInfoSort() {
        List<Sort.Order> orders=new ArrayList<>();
        Sort.Order order=new Sort.Order(Sort.Direction.ASC,"clickCount");
        orders.add(order);
        Sort sort=new Sort(orders);
        Iterable<FileInfo> it=repository.findAll(sort);
        List<FileInfo> list=new ArrayList<>();
        for(FileInfo fileInfo:it){
            list.add(fileInfo);
        }
        return list;
    }

    @Override
    public List<FileInfo> like(String content) {
        SearchQuery query=getSearchQuery(content,page,size);
        Iterable<FileInfo> it=repository.search(query);
        List<FileInfo> list=new ArrayList<>();
        for(FileInfo fileInfo:it){
            list.add(fileInfo);
        }
        return list;
    }

    /**
     * 短语匹配到的搜索词，求和模式累加权重分
     * @param searchContent
     * @param page
     * @param size
     * @return
     */
    private SearchQuery getSearchQuery(String searchContent,int page,int size){
        FunctionScoreQueryBuilder builder=QueryBuilders.functionScoreQuery()
                .add(QueryBuilders.matchPhraseQuery("abstracts",searchContent),ScoreFunctionBuilders.weightFactorFunction(1000))
                .add(QueryBuilders.matchPhraseQuery("content",searchContent),ScoreFunctionBuilders.weightFactorFunction(500))
                .scoreMode(SCORE_MODE_SUM).setMinScore(MIN_SCORE);
        return new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(builder).build();
    }

    @Override
    public String update(String id) {

        return null;
    }
}
