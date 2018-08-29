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

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GeneratorController {

    public void genCode(String moduleName,String tablePrefix,String tableName){
        Configuration config=getConfig();
        List<TableFill> tableFillList=new ArrayList<>();
        tableFillList.add(new TableFill("ASDD_SS",FieldFill.INSERT_UPDATE));

        //代码生成器
        AutoGenerator mpg=new AutoGenerator().setGlobalConfig(
              //全局配置
              new GlobalConfig()
                  .setOutputDir(config.getString("global.outputDir"))
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
                 .setTablePrefix(tablePrefix.split(","))//此处可以修改为您的表前缀
                 .setNaming(NamingStrategy.underline_to_camel)//表名生成策略
                 .setInclude(tableName.split(","))//需要生成的表
                 .setTableFillList(tableFillList)
                 .setSuperControllerClass(config.getString("strategy.superControllerClass"))
                 .setSuperMapperClass(config.getString("strategy.superMapperClass"))
                 .setSuperEntityClass(config.getString("strategy.superEntityClass"))

        ).setPackageInfo(
              //包配置
                new PackageConfig()
                   .setParent(config.getString("package.parent"))
                   .setController(moduleName+".web")
                   .setEntity(moduleName+"model")
                   .setService(moduleName+".service")
                   .setServiceImpl(moduleName+".service.impl")
                   .setMapper(moduleName+".dao")
                   .setXml(moduleName+".dao.xml")
        );
        mpg.execute();

    }

    public static Configuration getConfig(){
        try {
            return new PropertiesConfiguration("generator.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }
}
