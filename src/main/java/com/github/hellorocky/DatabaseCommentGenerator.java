package com.github.hellorocky;

import lombok.Getter;
import lombok.Setter;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * @author RockyWu
 * @date 2019-06-01
 */
public class DatabaseCommentGenerator extends DefaultCommentGenerator {
    @Getter
    @Setter
    private boolean enable = true;

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if(!this.enable){
            return;
        }
        field.addJavaDocLine("/**");
        String remarks = introspectedColumn.getRemarks();
        field.addJavaDocLine(" * "+remarks);
        field.addJavaDocLine(" */");
    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
    }
}

