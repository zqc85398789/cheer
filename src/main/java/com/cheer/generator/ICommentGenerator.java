package com.cheer.generator;

import java.util.Properties;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;


public class ICommentGenerator extends DefaultCommentGenerator {
    
    /**
     * 父类中没有提供子类可访问该属性的方法，所以这里要重新定义
     */
    private boolean suppressAllComments;
    
    /**
     * 父类中没有提供子类可访问该属性的方法，所以这里要重新定义
     */
    private boolean addRemarkComments;
    
    @Override
    public void addConfigurationProperties(Properties properties) {
        super.addConfigurationProperties(properties);
        //获取suppressAllComments参数值
        suppressAllComments = StringUtility.isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
        //获取addRemarkComments参数值
        addRemarkComments = StringUtility.isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_ADD_REMARK_COMMENTS));
    }
    
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        if(suppressAllComments) {
            return;
        }
        field.addJavaDocLine("/**");
        //获取DB字段的备注信息
        String remarks = introspectedColumn.getRemarks();
        //根据参数和备注信息判断是否添加备注信息
        if(addRemarkComments && StringUtility.stringHasValue(remarks)) {
            String[] remarkLines = remarks.split(System.getProperty("line.separator"));
            for(String str : remarkLines) {
                field.addJavaDocLine(" * " + str);
            }
        }
        //由于Java对象名和数据库字段名可能不一样，注释中添加数据库字段名
        field.addJavaDocLine(" * " + introspectedColumn.getActualColumnName());
        field.addJavaDocLine("*/");
    }
}