package io.nop.dao.dialect.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.dao.dialect.model.SqlFunctionModel;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/orm/dialect.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _SqlFunctionModel extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: className
     * 
     */
    private String _className ;
    
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
     * xml name: testSql
     * 
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
     * xml name: className
     *  
     */
    
    public String getClassName(){
      return _className;
    }

    
    public void setClassName(String value){
        checkAllowChange();
        
        this._className = value;
           
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
     * xml name: testSql
     *  
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
        
        out.putNotNull("className",this.getClassName());
        out.putNotNull("description",this.getDescription());
        out.putNotNull("name",this.getName());
        out.putNotNull("testSql",this.getTestSql());
        out.putNotNull("type",this.getType());
    }

    public SqlFunctionModel cloneInstance(){
        SqlFunctionModel instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(SqlFunctionModel instance){
        super.copyTo(instance);
        
        instance.setClassName(this.getClassName());
        instance.setDescription(this.getDescription());
        instance.setName(this.getName());
        instance.setTestSql(this.getTestSql());
        instance.setType(this.getType());
    }

    protected SqlFunctionModel newInstance(){
        return (SqlFunctionModel) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
