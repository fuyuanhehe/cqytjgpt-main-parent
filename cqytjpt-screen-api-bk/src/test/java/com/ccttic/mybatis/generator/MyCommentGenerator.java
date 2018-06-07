/**
 * 
 */
package com.ccttic.mybatis.generator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.util.StringUtility;

/**
 * @author yaohuixing
 *
 */
public class MyCommentGenerator implements CommentGenerator {
	
	private Properties properties;
	private Properties systemPro;
	private boolean suppressDate;
	private boolean suppressAllComments;
	private String currentDateStr;

	
	public MyCommentGenerator(){
		super();
	    properties = new Properties();
	    systemPro = System.getProperties();
	    suppressDate = false;
	    suppressAllComments = false;
	    currentDateStr = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());

	}

	/* (non-Javadoc)
	 * @see org.mybatis.generator.api.CommentGenerator#addConfigurationProperties(java.util.Properties)
	 */
	@Override
	public void addConfigurationProperties(Properties properties) {
		this.properties.putAll(properties);

	    suppressDate = StringUtility.isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));

	    suppressAllComments = StringUtility.isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));

	}

	/* (non-Javadoc)
	 * @see org.mybatis.generator.api.CommentGenerator#addFieldComment(org.mybatis.generator.api.dom.java.Field, org.mybatis.generator.api.IntrospectedTable, org.mybatis.generator.api.IntrospectedColumn)
	 */
	@Override
	public void addFieldComment(Field field,
			IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
	        return;
	    }

	    StringBuilder sb = new StringBuilder();

	    field.addJavaDocLine("/**");
	    sb.append(" * ");
	    sb.append(introspectedColumn.getRemarks());
	    field.addJavaDocLine(sb.toString());

	    //      addJavadocTag(field, false);

	    field.addJavaDocLine(" */");


	}

	/* (non-Javadoc)
	 * @see org.mybatis.generator.api.CommentGenerator#addFieldComment(org.mybatis.generator.api.dom.java.Field, org.mybatis.generator.api.IntrospectedTable)
	 */
	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
	        return;
	    }

	    StringBuilder sb = new StringBuilder();

	    field.addJavaDocLine("/**");
	    sb.append(" * ");
	    sb.append(introspectedTable.getFullyQualifiedTable());
	    field.addJavaDocLine(sb.toString());
	    field.addJavaDocLine(" */");

	}

	/* (non-Javadoc)
	 * @see org.mybatis.generator.api.CommentGenerator#addModelClassComment(org.mybatis.generator.api.dom.java.TopLevelClass, org.mybatis.generator.api.IntrospectedTable)
	 */
	@Override
	public void addModelClassComment(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		// TODO Auto-generated method stub

	}
	
	protected String getDateString() {
	    String result = null;
	    if (!suppressDate) {
	        result = currentDateStr;
	    }
	    return result;
	}


	/* (non-Javadoc)
	 * @see org.mybatis.generator.api.CommentGenerator#addClassComment(org.mybatis.generator.api.dom.java.InnerClass, org.mybatis.generator.api.IntrospectedTable)
	 */
	@Override
	public void addClassComment(InnerClass innerClass,
			IntrospectedTable introspectedTable) {
		StringBuilder sb = new StringBuilder();
	    innerClass.addJavaDocLine("/**");
	    sb.append(" * ");
	    sb.append(introspectedTable.getFullyQualifiedTable());
	    sb.append(" ");
	    sb.append(getDateString());
	    innerClass.addJavaDocLine(sb.toString());
	    innerClass.addJavaDocLine(" */");


	}

	/* (non-Javadoc)
	 * @see org.mybatis.generator.api.CommentGenerator#addClassComment(org.mybatis.generator.api.dom.java.InnerClass, org.mybatis.generator.api.IntrospectedTable, boolean)
	 */
	@Override
	public void addClassComment(InnerClass innerClass,
			IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
		if (suppressAllComments) {
	        return;
	    }

	    StringBuilder sb = new StringBuilder();

	    innerClass.addJavaDocLine("/**");
	    sb.append(" * ");
	    sb.append(introspectedTable.getFullyQualifiedTable());
	    innerClass.addJavaDocLine(sb.toString());

	    sb.setLength(0);
	    sb.append(" * @author ");
	    sb.append(systemPro.getProperty("user.name"));
	    sb.append(" ");
	    sb.append(currentDateStr);

	    //      addJavadocTag(innerClass, markAsDoNotDelete);

	    innerClass.addJavaDocLine(" */");

	}

	/* (non-Javadoc)
	 * @see org.mybatis.generator.api.CommentGenerator#addEnumComment(org.mybatis.generator.api.dom.java.InnerEnum, org.mybatis.generator.api.IntrospectedTable)
	 */
	@Override
	public void addEnumComment(InnerEnum innerEnum,
			IntrospectedTable introspectedTable) {
		StringBuilder sb = new StringBuilder();

	    innerEnum.addJavaDocLine("/**");
	    //      addJavadocTag(innerEnum, false);
	    sb.append(" * ");
	    sb.append(introspectedTable.getFullyQualifiedTable());
	    innerEnum.addJavaDocLine(sb.toString());
	    innerEnum.addJavaDocLine(" */");


	}

	/* (non-Javadoc)
	 * @see org.mybatis.generator.api.CommentGenerator#addGetterComment(org.mybatis.generator.api.dom.java.Method, org.mybatis.generator.api.IntrospectedTable, org.mybatis.generator.api.IntrospectedColumn)
	 */
	@Override
	public void addGetterComment(Method method,
			IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
	        return;
	    }

	    method.addJavaDocLine("/**");

	    StringBuilder sb = new StringBuilder();
	    sb.append(" * ");
	    sb.append(introspectedColumn.getRemarks());
	    method.addJavaDocLine(sb.toString());

	    sb.setLength(0);
	    sb.append(" * @return ");
	    sb.append(introspectedColumn.getActualColumnName());
	    sb.append(" ");
	    sb.append(introspectedColumn.getRemarks());
	    method.addJavaDocLine(sb.toString());

	    //      addJavadocTag(method, false);

	    method.addJavaDocLine(" */");


	}

	/* (non-Javadoc)
	 * @see org.mybatis.generator.api.CommentGenerator#addSetterComment(org.mybatis.generator.api.dom.java.Method, org.mybatis.generator.api.IntrospectedTable, org.mybatis.generator.api.IntrospectedColumn)
	 */
	@Override
	public void addSetterComment(Method method,
			IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
	        return;
	    }


	    method.addJavaDocLine("/**");
	    StringBuilder sb = new StringBuilder();
	    sb.append(" * ");
	    sb.append(introspectedColumn.getRemarks());
	    method.addJavaDocLine(sb.toString());

	    Parameter parm = method.getParameters().get(0);
	    sb.setLength(0);
	    sb.append(" * @param ");
	    sb.append(parm.getName());
	    sb.append(" ");
	    sb.append(introspectedColumn.getRemarks());
	    method.addJavaDocLine(sb.toString());

	    //      addJavadocTag(method, false);

	    method.addJavaDocLine(" */");


	}

	/* (non-Javadoc)
	 * @see org.mybatis.generator.api.CommentGenerator#addGeneralMethodComment(org.mybatis.generator.api.dom.java.Method, org.mybatis.generator.api.IntrospectedTable)
	 */
	@Override
	public void addGeneralMethodComment(Method method,
			IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
	        return;
	    }
	    //      method.addJavaDocLine("/**");
	    //      addJavadocTag(method, false);
	    //      method.addJavaDocLine(" */");


	}

	/* (non-Javadoc)
	 * @see org.mybatis.generator.api.CommentGenerator#addJavaFileComment(org.mybatis.generator.api.dom.java.CompilationUnit)
	 */
	@Override
	public void addJavaFileComment(CompilationUnit compilationUnit) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.mybatis.generator.api.CommentGenerator#addComment(org.mybatis.generator.api.dom.xml.XmlElement)
	 */
	@Override
	public void addComment(XmlElement xmlElement) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.mybatis.generator.api.CommentGenerator#addRootComment(org.mybatis.generator.api.dom.xml.XmlElement)
	 */
	@Override
	public void addRootComment(XmlElement rootElement) {
		// TODO Auto-generated method stub

	}

	  
	    /* (非 Javadoc)  
	    *   
	    *   
	    * @param method
	    * @param introspectedTable
	    * @param imports  
	    * @see org.mybatis.generator.api.CommentGenerator#addGeneralMethodAnnotation(org.mybatis.generator.api.dom.java.Method, org.mybatis.generator.api.IntrospectedTable, java.util.Set)  
	    */  
	    
	@Override
	public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable,
			Set<FullyQualifiedJavaType> imports) {
		// TODO Auto-generated method stub
		
	}

	  
	    /* (非 Javadoc)  
	    *   
	    *   
	    * @param method
	    * @param introspectedTable
	    * @param introspectedColumn
	    * @param imports  
	    * @see org.mybatis.generator.api.CommentGenerator#addGeneralMethodAnnotation(org.mybatis.generator.api.dom.java.Method, org.mybatis.generator.api.IntrospectedTable, org.mybatis.generator.api.IntrospectedColumn, java.util.Set)  
	    */  
	    
	@Override
	public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {
		// TODO Auto-generated method stub
		
	}

	  
	    /* (非 Javadoc)  
	    *   
	    *   
	    * @param field
	    * @param introspectedTable
	    * @param imports  
	    * @see org.mybatis.generator.api.CommentGenerator#addFieldAnnotation(org.mybatis.generator.api.dom.java.Field, org.mybatis.generator.api.IntrospectedTable, java.util.Set)  
	    */  
	    
	@Override
	public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable,
			Set<FullyQualifiedJavaType> imports) {
		// TODO Auto-generated method stub
		
	}

	  
	    /* (非 Javadoc)  
	    *   
	    *   
	    * @param field
	    * @param introspectedTable
	    * @param introspectedColumn
	    * @param imports  
	    * @see org.mybatis.generator.api.CommentGenerator#addFieldAnnotation(org.mybatis.generator.api.dom.java.Field, org.mybatis.generator.api.IntrospectedTable, org.mybatis.generator.api.IntrospectedColumn, java.util.Set)  
	    */  
	    
	@Override
	public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {
		// TODO Auto-generated method stub
		
	}

	  
	    /* (非 Javadoc)  
	    *   
	    *   
	    * @param innerClass
	    * @param introspectedTable
	    * @param imports  
	    * @see org.mybatis.generator.api.CommentGenerator#addClassAnnotation(org.mybatis.generator.api.dom.java.InnerClass, org.mybatis.generator.api.IntrospectedTable, java.util.Set)  
	    */  
	    
	@Override
	public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable,
			Set<FullyQualifiedJavaType> imports) {
		// TODO Auto-generated method stub
		
	}

}
