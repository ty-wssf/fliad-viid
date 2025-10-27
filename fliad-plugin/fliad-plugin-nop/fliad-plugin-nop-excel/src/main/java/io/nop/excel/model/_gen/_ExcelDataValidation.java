package io.nop.excel.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.excel.model.ExcelDataValidation;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/excel/workbook.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _ExcelDataValidation extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: allowBlank
     * 是否允许为空
     */
    private Boolean _allowBlank ;
    
    /**
     *  
     * xml name: formula1
     * 
     */
    private String _formula1 ;
    
    /**
     *  
     * xml name: formula2
     * 
     */
    private String _formula2 ;
    
    /**
     *  
     * xml name: id
     * 
     */
    private String _id ;
    
    /**
     *  
     * xml name: showErrorMessage
     * 是否显示错误提示
     */
    private Boolean _showErrorMessage ;
    
    /**
     *  
     * xml name: showInputMessage
     * 是否显示输入提示
     */
    private Boolean _showInputMessage ;
    
    /**
     *  
     * xml name: sqref
     * 指定数据验证的单元格范围
     */
    private String _sqref ;
    
    /**
     *  
     * xml name: type
     * 
     */
    private String _type ;
    
    /**
     * 
     * xml name: allowBlank
     *  是否允许为空
     */
    
    public Boolean getAllowBlank(){
      return _allowBlank;
    }

    
    public void setAllowBlank(Boolean value){
        checkAllowChange();
        
        this._allowBlank = value;
           
    }

    
    /**
     * 
     * xml name: formula1
     *  
     */
    
    public String getFormula1(){
      return _formula1;
    }

    
    public void setFormula1(String value){
        checkAllowChange();
        
        this._formula1 = value;
           
    }

    
    /**
     * 
     * xml name: formula2
     *  
     */
    
    public String getFormula2(){
      return _formula2;
    }

    
    public void setFormula2(String value){
        checkAllowChange();
        
        this._formula2 = value;
           
    }

    
    /**
     * 
     * xml name: id
     *  
     */
    
    public String getId(){
      return _id;
    }

    
    public void setId(String value){
        checkAllowChange();
        
        this._id = value;
           
    }

    
    /**
     * 
     * xml name: showErrorMessage
     *  是否显示错误提示
     */
    
    public Boolean getShowErrorMessage(){
      return _showErrorMessage;
    }

    
    public void setShowErrorMessage(Boolean value){
        checkAllowChange();
        
        this._showErrorMessage = value;
           
    }

    
    /**
     * 
     * xml name: showInputMessage
     *  是否显示输入提示
     */
    
    public Boolean getShowInputMessage(){
      return _showInputMessage;
    }

    
    public void setShowInputMessage(Boolean value){
        checkAllowChange();
        
        this._showInputMessage = value;
           
    }

    
    /**
     * 
     * xml name: sqref
     *  指定数据验证的单元格范围
     */
    
    public String getSqref(){
      return _sqref;
    }

    
    public void setSqref(String value){
        checkAllowChange();
        
        this._sqref = value;
           
    }

    
    /**
     * 
     * xml name: type
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
        
        out.putNotNull("allowBlank",this.getAllowBlank());
        out.putNotNull("formula1",this.getFormula1());
        out.putNotNull("formula2",this.getFormula2());
        out.putNotNull("id",this.getId());
        out.putNotNull("showErrorMessage",this.getShowErrorMessage());
        out.putNotNull("showInputMessage",this.getShowInputMessage());
        out.putNotNull("sqref",this.getSqref());
        out.putNotNull("type",this.getType());
    }

    public ExcelDataValidation cloneInstance(){
        ExcelDataValidation instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(ExcelDataValidation instance){
        super.copyTo(instance);
        
        instance.setAllowBlank(this.getAllowBlank());
        instance.setFormula1(this.getFormula1());
        instance.setFormula2(this.getFormula2());
        instance.setId(this.getId());
        instance.setShowErrorMessage(this.getShowErrorMessage());
        instance.setShowInputMessage(this.getShowInputMessage());
        instance.setSqref(this.getSqref());
        instance.setType(this.getType());
    }

    protected ExcelDataValidation newInstance(){
        return (ExcelDataValidation) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
