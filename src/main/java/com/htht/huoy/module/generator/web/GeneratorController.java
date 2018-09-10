package com.htht.huoy.module.generator.web;

import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GeneratorController {

    public void genCode(String moduleName,String tablePrefix,String tableName){
        List<TableFill> tableFillList=new ArrayList<>();
        tableFillList.add(new TableFill("ASDD_SS",FieldFill.INSERT_UPDATE));

        //代码生成器
        AutoGenerator mpg=new AutoGenerator().setGlobalConfig(
              //全局配置
              new GlobalConfig()
              .setOutputDir(PropertiesGetter)
        ).setDataSource(

        ).setStrategy(

        ).setPackageInfo(

        );

    }
}
