package io.nop.dao.dialect.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.dao.dialect.model.SqlTemplateModel;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/orm/dialect.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _SqlTemplateModel extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: argTypes
     * 
     */
    private java.util.List<io.nop.commons.type.StdSqlType> _argTypes ;
    
    /**
     *  
     * xml name: description
     * 
     */
    private String _description ;
    
    /**
     *  
     * xml name: name
     * 
     */
    private String _name ;
    
    /**
     *  
     * xml name: onlyForWindowExpr
     * 
     */
    private boolean _onlyForWindowExpr  = false;
    
    /**
     *  
     * xml name: returnFirstArgType
     * 返回类型是否与第一个参数的类型相同
     */
    private boolean _returnFirstArgType  = false;
    
    /**
     *  
     * xml name: returnType
     * 
     */
    private io.nop.commons.type.StdSqlType _returnType ;
    
    /**
     *  
     * xml name: source
     * 
     */
    private String _source ;
    
    /**
     *  
     * xml name: testSql
     * 如果非空，则在单元测试中调用此函数来测试数据库是否支持此函数
     */
    private String _testSql ;
    
    /**
     *  
     * xml name: 
     * 
     */
    private String _type ;
    
    /**
     * 
     * xml name: argTypes
     *  
     */
    
    public java.util.List<io.nop.commons.type.StdSqlType> getArgTypes(){
      return _argTypes;
    }

    
    public void setArgTypes(java.util.List<io.nop.commons.type.StdSqlType> value){
        checkAllowChange();
        
        this._argTypes = value;
           
    }

    
    /**
     * 
     * xml name: description
     *  
     */
    
    public String getDescription(){
      return _description;
    }

    
    public void setDescription(String value){
        checkAllowChange();
        
        this._description = value;
           
    }

    
    /**
     * 
     * xml name: name
     *  
     */
    
    public String getName(){
      return _name;
    }

    
    public void setName(String value){
        checkAllowChange();
        
        this._name = value;
           
    }

    
    /**
     * 
     * xml name: onlyForWindowExpr
     *  
     */
    
    public boolean isOnlyForWindowExpr(){
      return _onlyForWindowExpr;
    }

    
    public void setOnlyForWindowExpr(boolean value){
        checkAllowChange();
        
        this._onlyForWindowExpr = value;
           
    }

    
    /**
     * 
     * xml name: returnFirstArgType
     *  返回类型是否与第一个参数的类型相同
     */
    
    public boolean isReturnFirstArgType(){
      return _returnFirstArgType;
    }

    
    public void setReturnFirstArgType(boolean value){
        checkAllowChange();
        
        this._returnFirstArgType = value;
           
    }

    
    /**
     * 
     * xml name: returnType
     *  
     */
    
    public io.nop.commons.type.StdSqlType getReturnType(){
      return _returnType;
    }

    
    public void setReturnType(io.nop.commons.type.StdSqlType value){
        checkAllowChange();
        
        this._returnType = value;
           
    }

    
    /**
     * 
     * xml name: source
     *  
     */
    
    public String getSource(){
      return _source;
    }

    
    public void setSource(String value){
        checkAllowChange();
        
        this._source = value;
           
    }

    
    /**
     * 
     * xml name: testSql
     *  如果非空，则在单元测试中调用此函数来测试数据库是否支持此函数
     */
    
    public String getTestSql(){
      return _testSql;
    }

    
    public void setTestSql(String value){
        checkAllowChange();
        
        this._testSql = value;
           
    }

    
    /**
     * 
     * xml name: 
     *  
     */
    
    public String getType(){
      return _type;
    }

    
    public void setType(String value){
        checkAllowChange();
        
        this._type = value;
           
    }

    

    @Override
    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
        }
    }

    @Override
    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.putNotNull("argTypes",this.getArgTypes());
        out.putNotNull("description",this.getDescription());
        out.putNotNull("name",this.getName());
        out.putNotNull("onlyForWindowExpr",this.isOnlyForWindowExpr());
        out.putNotNull("returnFirstArgType",this.isReturnFirstArgType());
        out.putNotNull("returnType",this.getReturnType());
        out.putNotNull("source",this.getSource());
        out.putNotNull("testSql",this.getTestSql());
        out.putNotNull("type",this.getType());
    }

    public SqlTemplateModel cloneInstance(){
        SqlTemplateModel instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(SqlTemplateModel instance){
        super.copyTo(instance);
        
        instance.setArgTypes(this.getArgTypes());
        instance.setDescription(this.getDescription());
        instance.setName(this.getName());
        instance.setOnlyForWindowExpr(this.isOnlyForWindowExpr());
        instance.setReturnFirstArgType(this.isReturnFirstArgType());
        instance.setReturnType(this.getReturnType());
        instance.setSource(this.getSource());
        instance.setTestSql(this.getTestSql());
        instance.setType(this.getType());
    }

    protected SqlTemplateModel newInstance(){
        return (SqlTemplateModel) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
