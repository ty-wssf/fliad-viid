package io.nop.dao.dialect.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.dao.dialect.model.DialectSqls;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/orm/dialect.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _DialectSqls extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: createSequence
     * 
     */
    private String _createSequence ;
    
    /**
     *  
     * xml name: dateLiteral
     * 
     */
    private String _dateLiteral ;
    
    /**
     *  
     * xml name: dateTimeLiteral
     * 
     */
    private String _dateTimeLiteral ;
    
    /**
     *  
     * xml name: dropSequence
     * 
     */
    private String _dropSequence ;
    
    /**
     *  
     * xml name: dropTable
     * 
     */
    private String _dropTable ;
    
    /**
     *  
     * xml name: escapeSlash
     * 对sql字符串字面量进行转义时，是否需要将\转义为\\
     */
    private Boolean _escapeSlash ;
    
    /**
     *  
     * xml name: exceptKeyword
     * 
     */
    private String _exceptKeyword ;
    
    /**
     *  
     * xml name: falseString
     * 
     */
    private String _falseString  = "0";
    
    /**
     *  
     * xml name: forUpdate
     * 
     */
    private String _forUpdate ;
    
    /**
     *  
     * xml name: insertKeyword
     * 
     */
    private String _insertKeyword ;
    
    /**
     *  
     * xml name: lockHint
     * 
     */
    private String _lockHint ;
    
    /**
     *  
     * xml name: selectFromDual
     * 
     */
    private String _selectFromDual ;
    
    /**
     *  
     * xml name: sequenceNextVal
     * 通过 {sequenceName}来表示参数
     */
    private String _sequenceNextVal ;
    
    /**
     *  
     * xml name: timeLiteral
     * 
     */
    private String _timeLiteral ;
    
    /**
     *  
     * xml name: timestampLiteral
     * 
     */
    private String _timestampLiteral ;
    
    /**
     *  
     * xml name: trueString
     * 
     */
    private String _trueString  = "1";
    
    /**
     *  
     * xml name: updateKeyword
     * 
     */
    private String _updateKeyword ;
    
    /**
     *  
     * xml name: validationQuery
     * 
     */
    private String _validationQuery ;
    
    /**
     * 
     * xml name: createSequence
     *  
     */
    
    public String getCreateSequence(){
      return _createSequence;
    }

    
    public void setCreateSequence(String value){
        checkAllowChange();
        
        this._createSequence = value;
           
    }

    
    /**
     * 
     * xml name: dateLiteral
     *  
     */
    
    public String getDateLiteral(){
      return _dateLiteral;
    }

    
    public void setDateLiteral(String value){
        checkAllowChange();
        
        this._dateLiteral = value;
           
    }

    
    /**
     * 
     * xml name: dateTimeLiteral
     *  
     */
    
    public String getDateTimeLiteral(){
      return _dateTimeLiteral;
    }

    
    public void setDateTimeLiteral(String value){
        checkAllowChange();
        
        this._dateTimeLiteral = value;
           
    }

    
    /**
     * 
     * xml name: dropSequence
     *  
     */
    
    public String getDropSequence(){
      return _dropSequence;
    }

    
    public void setDropSequence(String value){
        checkAllowChange();
        
        this._dropSequence = value;
           
    }

    
    /**
     * 
     * xml name: dropTable
     *  
     */
    
    public String getDropTable(){
      return _dropTable;
    }

    
    public void setDropTable(String value){
        checkAllowChange();
        
        this._dropTable = value;
           
    }

    
    /**
     * 
     * xml name: escapeSlash
     *  对sql字符串字面量进行转义时，是否需要将\转义为\\
     */
    
    public Boolean getEscapeSlash(){
      return _escapeSlash;
    }

    
    public void setEscapeSlash(Boolean value){
        checkAllowChange();
        
        this._escapeSlash = value;
           
    }

    
    /**
     * 
     * xml name: exceptKeyword
     *  
     */
    
    public String getExceptKeyword(){
      return _exceptKeyword;
    }

    
    public void setExceptKeyword(String value){
        checkAllowChange();
        
        this._exceptKeyword = value;
           
    }

    
    /**
     * 
     * xml name: falseString
     *  
     */
    
    public String getFalseString(){
      return _falseString;
    }

    
    public void setFalseString(String value){
        checkAllowChange();
        
        this._falseString = value;
           
    }

    
    /**
     * 
     * xml name: forUpdate
     *  
     */
    
    public String getForUpdate(){
      return _forUpdate;
    }

    
    public void setForUpdate(String value){
        checkAllowChange();
        
        this._forUpdate = value;
           
    }

    
    /**
     * 
     * xml name: insertKeyword
     *  
     */
    
    public String getInsertKeyword(){
      return _insertKeyword;
    }

    
    public void setInsertKeyword(String value){
        checkAllowChange();
        
        this._insertKeyword = value;
           
    }

    
    /**
     * 
     * xml name: lockHint
     *  
     */
    
    public String getLockHint(){
      return _lockHint;
    }

    
    public void setLockHint(String value){
        checkAllowChange();
        
        this._lockHint = value;
           
    }

    
    /**
     * 
     * xml name: selectFromDual
     *  
     */
    
    public String getSelectFromDual(){
      return _selectFromDual;
    }

    
    public void setSelectFromDual(String value){
        checkAllowChange();
        
        this._selectFromDual = value;
           
    }

    
    /**
     * 
     * xml name: sequenceNextVal
     *  通过 {sequenceName}来表示参数
     */
    
    public String getSequenceNextVal(){
      return _sequenceNextVal;
    }

    
    public void setSequenceNextVal(String value){
        checkAllowChange();
        
        this._sequenceNextVal = value;
           
    }

    
    /**
     * 
     * xml name: timeLiteral
     *  
     */
    
    public String getTimeLiteral(){
      return _timeLiteral;
    }

    
    public void setTimeLiteral(String value){
        checkAllowChange();
        
        this._timeLiteral = value;
           
    }

    
    /**
     * 
     * xml name: timestampLiteral
     *  
     */
    
    public String getTimestampLiteral(){
      return _timestampLiteral;
    }

    
    public void setTimestampLiteral(String value){
        checkAllowChange();
        
        this._timestampLiteral = value;
           
    }

    
    /**
     * 
     * xml name: trueString
     *  
     */
    
    public String getTrueString(){
      return _trueString;
    }

    
    public void setTrueString(String value){
        checkAllowChange();
        
        this._trueString = value;
           
    }

    
    /**
     * 
     * xml name: updateKeyword
     *  
     */
    
    public String getUpdateKeyword(){
      return _updateKeyword;
    }

    
    public void setUpdateKeyword(String value){
        checkAllowChange();
        
        this._updateKeyword = value;
           
    }

    
    /**
     * 
     * xml name: validationQuery
     *  
     */
    
    public String getValidationQuery(){
      return _validationQuery;
    }

    
    public void setValidationQuery(String value){
        checkAllowChange();
        
        this._validationQuery = value;
           
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
        
        out.putNotNull("createSequence",this.getCreateSequence());
        out.putNotNull("dateLiteral",this.getDateLiteral());
        out.putNotNull("dateTimeLiteral",this.getDateTimeLiteral());
        out.putNotNull("dropSequence",this.getDropSequence());
        out.putNotNull("dropTable",this.getDropTable());
        out.putNotNull("escapeSlash",this.getEscapeSlash());
        out.putNotNull("exceptKeyword",this.getExceptKeyword());
        out.putNotNull("falseString",this.getFalseString());
        out.putNotNull("forUpdate",this.getForUpdate());
        out.putNotNull("insertKeyword",this.getInsertKeyword());
        out.putNotNull("lockHint",this.getLockHint());
        out.putNotNull("selectFromDual",this.getSelectFromDual());
        out.putNotNull("sequenceNextVal",this.getSequenceNextVal());
        out.putNotNull("timeLiteral",this.getTimeLiteral());
        out.putNotNull("timestampLiteral",this.getTimestampLiteral());
        out.putNotNull("trueString",this.getTrueString());
        out.putNotNull("updateKeyword",this.getUpdateKeyword());
        out.putNotNull("validationQuery",this.getValidationQuery());
    }

    public DialectSqls cloneInstance(){
        DialectSqls instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(DialectSqls instance){
        super.copyTo(instance);
        
        instance.setCreateSequence(this.getCreateSequence());
        instance.setDateLiteral(this.getDateLiteral());
        instance.setDateTimeLiteral(this.getDateTimeLiteral());
        instance.setDropSequence(this.getDropSequence());
        instance.setDropTable(this.getDropTable());
        instance.setEscapeSlash(this.getEscapeSlash());
        instance.setExceptKeyword(this.getExceptKeyword());
        instance.setFalseString(this.getFalseString());
        instance.setForUpdate(this.getForUpdate());
        instance.setInsertKeyword(this.getInsertKeyword());
        instance.setLockHint(this.getLockHint());
        instance.setSelectFromDual(this.getSelectFromDual());
        instance.setSequenceNextVal(this.getSequenceNextVal());
        instance.setTimeLiteral(this.getTimeLiteral());
        instance.setTimestampLiteral(this.getTimestampLiteral());
        instance.setTrueString(this.getTrueString());
        instance.setUpdateKeyword(this.getUpdateKeyword());
        instance.setValidationQuery(this.getValidationQuery());
    }

    protected DialectSqls newInstance(){
        return (DialectSqls) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
