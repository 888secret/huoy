package com.htht.huoy.module.file.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.htht.huoy.common.utils.FileFormat;
import com.htht.huoy.common.web.CommonController;
import com.htht.huoy.module.file.model.FileInfo;
import com.htht.huoy.module.file.service.IFileInfoService;
import com.htht.huoy.module.generator.common.Result;
import com.htht.huoy.module.generator.common.ResultUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 文件信息表 前端控制器
 * </p>
 *
 * @author wjx
 * @since 2018-09-20
 */
@RestController
@RequestMapping("/file")
public class FileInfoController extends CommonController {

    @Autowired
    private IFileInfoService fileInfoService;

    @RequestMapping("/upload")
    public Result upload(@RequestParam("multipartfiles")MultipartFile[] files,String folderId){
        String path=(Thread.currentThread().getContextClassLoader().getResource("").getPath()).substring(1)+"upload";
        //遍历文件
        try {
            if(files!=null&&files.length>0){
                for(MultipartFile file:files){
                    //获取文件名
                    String fileName=file.getOriginalFilename();
                    File f=new File(path,fileName);
                    //判断文件是否存在，不存在则创建
                    if(!f.exists()){
                        if(!f.getParentFile().exists()){
                            f.getParentFile().mkdirs();
                        }
                        f.createNewFile();
                    }
                    //上传文件
                    file.transferTo(f);
                    //向数据库中插入文件上传记录
                    FileInfo fileInfo=new FileInfo();
                    fileInfo.setFileName(fileName);
                    fileInfo.setFilePath(path+File.separator+fileName);
                    fileInfo.setFileSize(file.getSize()/1024.0);
                    fileInfo.setFileType(file.getContentType());
                    fileInfo.setFolderId(folderId);
                    fileInfo.setIsDelete("0");
                    fileInfo.setIsLock("0");
                    fileInfo.setUpdateTime(new Date());
                    fileInfoService.insertOrUpdate(fileInfo);

                    //如果文件格式为doc/docx/pdf/ppt/pptx/xls/xlsx/text的文件，读取文本，保存在数据库
                    String filePath=path+File.separator+fileName;
                    String fileType=fileName.substring(fileName.indexOf(".")+1).toLowerCase();
                    String content="";
                    switch(fileType){
                        case "doc":
                            content=FileFormat.getTextFromDoc(filePath);
                            break;
                        case "docx":
                            content=FileFormat.getTextFromDocx(filePath);
                            break;
                        case "pdf":
                            content=FileFormat.getTextFromPDF(filePath);
                            break;
                        case "ppt":
                            content=FileFormat.getTextFromPPT(filePath);
                            break;
                        case "pptx":
                            content=FileFormat.getTextFromPPTX(filePath);
                            break;
                        case "xls":
                            content=FileFormat.getTextFromxls(filePath);
                            break;
                        case "xlsx":
                            content=FileFormat.getTextFromxlsx(filePath);
                            break;
                        case "text":
                            content=FileFormat.getTextFromText(filePath);
                            break;
                        default:

                            break;
                    }
                    //向elasticsearch插入记录
                    fileInfo.setContent(content);
                    fileInfoService.saveFileInfo(fileInfo);

                }
            }
            return ResultUtil.success();
        } catch (IOException e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @RequestMapping("/getFileListByFolderId")
    public Result getFileListByFolderId(String folderId){
        Wrapper<FileInfo> wrapper=new EntityWrapper<>();
        wrapper.eq("folder_id",folderId);
        List<FileInfo> list=fileInfoService.selectList(wrapper);
        return ResultUtil.success(list);

    }

}

