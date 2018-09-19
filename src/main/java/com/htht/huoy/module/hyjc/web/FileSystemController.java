package com.htht.huoy.module.hyjc.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.htht.huoy.common.web.CommonController;
import com.htht.huoy.module.generator.common.Result;
import com.htht.huoy.module.generator.common.ResultUtil;
import com.htht.huoy.module.hyjc.model.FileSystem;
import com.htht.huoy.module.hyjc.service.IFileSystemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 文件系统表 前端控制器
 * </p>
 *
 * @author wjx
 * @since 2018-09-19
 */
@RestController
@RequestMapping("/fileSystem")
public class FileSystemController extends CommonController {

    @Autowired
    private IFileSystemService fileSystemService;

    @RequestMapping("/save")
    public Result insert(@RequestBody FileSystem fileSystem){
        return ResultUtil.success(fileSystemService.insertOrUpdate(fileSystem));
    }

    @RequestMapping("delete/{id}")
    public Result deleteById(@PathVariable String id){
        return ResultUtil.success(fileSystemService.deleteById(id));
    }

    @RequestMapping("selectTree")
    public Result select(){
        //查询树
        //父节点id为0表示根节点
        Wrapper<FileSystem> wrapper=new EntityWrapper<>();
        wrapper.eq("parent_id","0");
        List<FileSystem> rootList=fileSystemService.selectList(wrapper);
        if(rootList.size()>0){
            for(FileSystem fs : rootList){
                getChildren(fs);
            }
        }
        return ResultUtil.success(rootList);

    }

    private void getChildren(FileSystem fs){
        //Wrapper
        Wrapper<FileSystem> wrapper=new EntityWrapper<>();
        wrapper.eq("parent_id",fs.getId());
        List<FileSystem> list=fileSystemService.selectList(wrapper);
        if(list.size()>0){
            fs.setChildList(list);
            for(FileSystem f:list){
                getChildren(f);
            }
        }else{
            fs.setChildList(list);
        }

    }
}

