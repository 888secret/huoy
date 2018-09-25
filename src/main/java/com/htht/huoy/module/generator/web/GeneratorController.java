package com.htht.huoy.module.generator.web;

import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.htht.huoy.module.generator.common.Result;
import com.htht.huoy.module.generator.common.ResultUtil;
import com.htht.huoy.module.generator.service.IGeneratorService;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/generator")
public class GeneratorController {

    @Autowired
    private IGeneratorService generatorService;

    @RequestMapping("/count")
    public Result getTableCount(){
        int count=generatorService.getTableCount();
        return ResultUtil.success(count);
    }

    @RequestMapping("/list")
    public Result getTableList(int pageNum, int pageSize, String name){
        return ResultUtil.success(generatorService.getTableList(pageNum,pageSize,name));
    }
    @RequestMapping("/genCode")
    public Result genCode(@RequestParam Map<String,String> form){
        Configuration config=getConfig();
        List<TableFill> tableFillList=new ArrayList<>();
        tableFillList.add(new TableFill("ASDD_SS",FieldFill.INSERT_UPDATE));

        try {
            //代码生成器
            AutoGenerator mpg=new AutoGenerator().setGlobalConfig(
                  //全局配置
                  new GlobalConfig()
                      .setOutputDir(form.get("outputDir"))
                      .setFileOverride(config.getBoolean("global.fileOverride"))
                      .setActiveRecord(config.getBoolean("global.activeRecord"))
                      .setEnableCache(config.getBoolean("global.enableCache"))
                      .setBaseResultMap(config.getBoolean("global.baseResultMap"))
                      .setBaseColumnList(config.getBoolean("global.baseColumnList"))
                      .setAuthor(config.getString("global.author"))
                      .setMapperName(config.getString("global.mapperName"))
                      .setXmlName(config.getString("global.xmlName"))
            ).setDataSource(
                    //数据源配置

                  new DataSourceConfig()
                    .setDbType(DbType.ORACLE)
                    .setDriverName(config.getString("db.driverName"))
                    .setUsername(config.getString("db.username"))
                    .setPassword(config.getString("db.password"))
                    .setUrl(config.getString("db.url"))
            ).setStrategy(
                    //策略配置
                  new StrategyConfig()
                     .setTablePrefix(form.get("tablePrefix").split(","))//此处可以修改为您的表前缀
                     .setNaming(NamingStrategy.underline_to_camel)//表名生成策略
                     .setInclude(form.get("tableName").split(","))//需要生成的表
                     .setTableFillList(tableFillList)
                     .setSuperControllerClass(config.getString("strategy.superControllerClass"))
                     .setSuperMapperClass(config.getString("strategy.superMapperClass"))
                     .setSuperEntityClass(config.getString("strategy.superEntityClass"))

            ).setPackageInfo(
                  //包配置
                    new PackageConfig()
                       .setParent(form.get("parent"))
                       .setController(form.get("moduleName")+".web")
                       .setEntity(form.get("moduleName")+".model")
                       .setService(form.get("moduleName")+".service")
                       .setServiceImpl(form.get("moduleName")+".service.impl")
                       .setMapper(form.get("moduleName")+".dao")
                       .setXml(form.get("moduleName")+".dao.xml")
            );
            mpg.execute();
            return ResultUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }

    }

    public static Configuration getConfig(){
        try {
            return new PropertiesConfiguration("generator.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
