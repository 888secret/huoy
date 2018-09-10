package cn.gov.mwr.wcsps.jczc.modules.generator;

import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 代码生成器演示.使用方法:
 * 
 * new AutoGenerator().setGlobalConfig(
 *	    ...
 *	).setDataSource(
 *	    ...
 *	).setStrategy(
 *	    ...
 *	).setPackageInfo(
 *    	...
 *	).setCfg(
 *	    ...
 *	).setTemplate(
 *	    ...
 *	).execute();
 *
 */
public class CodeGeneratorWithClass {

    public static void main(String[] args) {
        // 自定义需要填充的字段
        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("ASDD_SS", FieldFill.INSERT_UPDATE));
        
        String moduleName = "demo";
        
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
	        // 全局配置
	        new GlobalConfig()
                .setOutputDir("D:\\codeGen")//输出目录
                .setFileOverride(true)// 是否覆盖文件
                .setActiveRecord(true)// 开启 activeRecord 模式
                .setEnableCache(false)// XML 二级缓存
                .setBaseResultMap(true)// XML ResultMap
                .setBaseColumnList(true)// XML columList
                .setAuthor("piesat")
                .setMapperName("I%sDao")
                .setXmlName("%sDao")
        ).setDataSource(
                // 数据源配置
                new DataSourceConfig()
                        .setDbType(DbType.ORACLE)// 数据库类型
                        .setTypeConvert(new OracleTypeConvert() {
                            // 自定义数据库表字段类型转换【可选】
                            @Override
                            public DbColumnType processTypeConvert(String fieldType) {
                                //System.out.println("转换类型：" + fieldType);
                                // if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
                                //    return DbColumnType.BOOLEAN;
                                // }
                                return super.processTypeConvert(fieldType);
                            }
                        })
                        .setDriverName("oracle.jdbc.driver.OracleDriver")
                        .setUsername("test")
                        .setPassword("test")
                        .setUrl("jdbc:oracle:thin:@127.0.0.1:1521:orcl")
        ).setStrategy(
                // 策略配置
                new StrategyConfig()
                        .setTablePrefix(new String[]{"T_SYS"})// 此处可以修改为您的表前缀
                        .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                        .setInclude(new String[] { "T_SYS_USER" }) // 需要生成的表
                        .setExclude(new String[]{}) // 排除生成的表
                        .setTableFillList(tableFillList)
                        .setSuperControllerClass("cn.gov.mwr.wcsps.jczc.common.web.CommonController")
                        .setSuperMapperClass("cn.gov.mwr.wcsps.jczc.common.dao.CommonDao")
                        .setSuperEntityClass("cn.gov.mwr.wcsps.jczc.common.model.CommonEntity")
                        .setSuperEntityColumns(new String[]{"id"})
              
        ).setPackageInfo(
                // 包配置
                new PackageConfig()
                        .setParent("cn.gov.mwr.wcsps.jczc.modules")// 自定义包路径
                        .setController(moduleName+".web")
                        .setEntity(moduleName+".model")
                        .setService(moduleName+".service")
                        .setServiceImpl(moduleName+".service.impl")
                        .setMapper(moduleName+".dao")
                        .setXml(moduleName+".dao.xml")
        ).setCfg(
                // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
                new InjectionConfig() {
                    @Override
                    public void initMap() {
                        Map<String, Object> map = new HashMap<>();
                        map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                        this.setMap(map);
                    }
                }/*.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig("/templates/mapper.xml.vm") {
                    // 自定义输出文件目录
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        return "/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
                    }
                }))*/
        ).setTemplate(
                new TemplateConfig()
        );

        // 执行生成
        mpg.execute();

        // 打印注入设置，这里演示模板里面怎么获取注入内容【可无】
        //System.err.println(mpg.getCfg().getMap().get("abc"));
    }

}