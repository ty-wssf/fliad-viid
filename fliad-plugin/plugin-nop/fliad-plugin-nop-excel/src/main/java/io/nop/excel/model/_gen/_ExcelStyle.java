package io.nop.excel.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.excel.model.ExcelStyle;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/excel/style.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _ExcelStyle extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: bottomBorder
     * 
     */
    private io.nop.excel.model.ExcelBorderStyle _bottomBorder ;
    
    /**
     *  
     * xml name: diagonalLeftBorder
     * 
     */
    private io.nop.excel.model.ExcelBorderStyle _diagonalLeftBorder ;
    
    /**
     *  
     * xml name: diagonalRightBorder
     * 
     */
    private io.nop.excel.model.ExcelBorderStyle _diagonalRightBorder ;
    
    /**
     *  
     * xml name: fillBgColor
     * 
     */
    private String _fillBgColor ;
    
    /**
     *  
     * xml name: fillFgColor
     * 
     */
    private String _fillFgColor ;
    
    /**
     *  
     * xml name: fillPattern
     * 
     */
    private String _fillPattern ;
    
    /**
     *  
     * xml name: font
     * 
     */
    private io.nop.excel.model.ExcelFont _font ;
    
    /**
     *  
     * xml name: hidden
     * 
     */
    private Boolean _hidden ;
    
    /**
     *  
     * xml name: horizontalAlign
     * 
     */
    private io.nop.excel.model.constants.ExcelHorizontalAlignment _horizontalAlign ;
    
    /**
     *  
     * xml name: id
     * 
     */
    private String _id ;
    
    /**
     *  
     * xml name: indent
     * 
     */
    private Integer _indent ;
    
    /**
     *  
     * xml name: leftBorder
     * 
     */
    private io.nop.excel.model.ExcelBorderStyle _leftBorder ;
    
    /**
     *  
     * xml name: locked
     * 
     */
    private Boolean _locked ;
    
    /**
     *  
     * xml name: name
     * 
     */
    private String _name ;
    
    /**
     *  
     * xml name: numberFormat
     * 
     */
    private String _numberFormat ;
    
    /**
     *  
     * xml name: rightBorder
     * 
     */
    private io.nop.excel.model.ExcelBorderStyle _rightBorder ;
    
    /**
     *  
     * xml name: rotate
     * 旋转角度（0-180）或者特殊值（255）。 90表示顺时针旋转90度（即文本从上到下），180表示颠倒，而255表示垂直文本（每个字母正常方向，但文本行垂直排列）。
     */
    private Integer _rotate ;
    
    /**
     *  
     * xml name: shrinkToFit
     * 
     */
    private boolean _shrinkToFit  = false;
    
    /**
     *  
     * xml name: topBorder
     * 
     */
    private io.nop.excel.model.ExcelBorderStyle _topBorder ;
    
    /**
     *  
     * xml name: verticalAlign
     * 
     */
    private io.nop.excel.model.constants.ExcelVerticalAlignment _verticalAlign ;
    
    /**
     *  
     * xml name: wrapText
     * 
     */
    private boolean _wrapText  = false;
    
    /**
     * 
     * xml name: bottomBorder
     *  
     */
    
    public io.nop.excel.model.ExcelBorderStyle getBottomBorder(){
      return _bottomBorder;
    }

    
    public void setBottomBorder(io.nop.excel.model.ExcelBorderStyle value){
        checkAllowChange();
        
        this._bottomBorder = value;
           
    }

    
    /**
     * 
     * xml name: diagonalLeftBorder
     *  
     */
    
    public io.nop.excel.model.ExcelBorderStyle getDiagonalLeftBorder(){
      return _diagonalLeftBorder;
    }

    
    public void setDiagonalLeftBorder(io.nop.excel.model.ExcelBorderStyle value){
        checkAllowChange();
        
        this._diagonalLeftBorder = value;
           
    }

    
    /**
     * 
     * xml name: diagonalRightBorder
     *  
     */
    
    public io.nop.excel.model.ExcelBorderStyle getDiagonalRightBorder(){
      return _diagonalRightBorder;
    }

    
    public void setDiagonalRightBorder(io.nop.excel.model.ExcelBorderStyle value){
        checkAllowChange();
        
        this._diagonalRightBorder = value;
           
    }

    
    /**
     * 
     * xml name: fillBgColor
     *  
     */
    
    public String getFillBgColor(){
      return _fillBgColor;
    }

    
    public void setFillBgColor(String value){
        checkAllowChange();
        
        this._fillBgColor = value;
           
    }

    
    /**
     * 
     * xml name: fillFgColor
     *  
     */
    
    public String getFillFgColor(){
      return _fillFgColor;
    }

    
    public void setFillFgColor(String value){
        checkAllowChange();
        
        this._fillFgColor = value;
           
    }

    
    /**
     * 
     * xml name: fillPattern
     *  
     */
    
    public String getFillPattern(){
      return _fillPattern;
    }

    
    public void setFillPattern(String value){
        checkAllowChange();
        
        this._fillPattern = value;
           
    }

    
    /**
     * 
     * xml name: font
     *  
     */
    
    public io.nop.excel.model.ExcelFont getFont(){
      return _font;
    }

    
    public void setFont(io.nop.excel.model.ExcelFont value){
        checkAllowChange();
        
        this._font = value;
           
    }

    
    /**
     * 
     * xml name: hidden
     *  
     */
    
    public Boolean getHidden(){
      return _hidden;
    }

    
    public void setHidden(Boolean value){
        checkAllowChange();
        
        this._hidden = value;
           
    }

    
    /**
     * 
     * xml name: horizontalAlign
     *  
     */
    
    public io.nop.excel.model.constants.ExcelHorizontalAlignment getHorizontalAlign(){
      return _horizontalAlign;
    }

    
    public void setHorizontalAlign(io.nop.excel.model.constants.ExcelHorizontalAlignment value){
        checkAllowChange();
        
        this._horizontalAlign = value;
           
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
     * xml name: indent
     *  
     */
    
    public Integer getIndent(){
      return _indent;
    }

    
    public void setIndent(Integer value){
        checkAllowChange();
        
        this._indent = value;
           
    }

    
    /**
     * 
     * xml name: leftBorder
     *  
     */
    
    public io.nop.excel.model.ExcelBorderStyle getLeftBorder(){
      return _leftBorder;
    }

    
    public void setLeftBorder(io.nop.excel.model.ExcelBorderStyle value){
        checkAllowChange();
        
        this._leftBorder = value;
           
    }

    
    /**
     * 
     * xml name: locked
     *  
     */
    
    public Boolean getLocked(){
      return _locked;
    }

    
    public void setLocked(Boolean value){
        checkAllowChange();
        
        this._locked = value;
           
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
     * xml name: numberFormat
     *  
     */
    
    public String getNumberFormat(){
      return _numberFormat;
    }

    
    public void setNumberFormat(String value){
        checkAllowChange();
        
        this._numberFormat = value;
           
    }

    
    /**
     * 
     * xml name: rightBorder
     *  
     */
    
    public io.nop.excel.model.ExcelBorderStyle getRightBorder(){
      return _rightBorder;
    }

    
    public void setRightBorder(io.nop.excel.model.ExcelBorderStyle value){
        checkAllowChange();
        
        this._rightBorder = value;
           
    }

    
    /**
     * 
     * xml name: rotate
     *  旋转角度（0-180）或者特殊值（255）。 90表示顺时针旋转90度（即文本从上到下），180表示颠倒，而255表示垂直文本（每个字母正常方向，但文本行垂直排列）。
     */
    
    public Integer getRotate(){
      return _rotate;
    }

    
    public void setRotate(Integer value){
        checkAllowChange();
        
        this._rotate = value;
           
    }

    
    /**
     * 
     * xml name: shrinkToFit
     *  
     */
    
    public boolean isShrinkToFit(){
      return _shrinkToFit;
    }

    
    public void setShrinkToFit(boolean value){
        checkAllowChange();
        
        this._shrinkToFit = value;
           
    }

    
    /**
     * 
     * xml name: topBorder
     *  
     */
    
    public io.nop.excel.model.ExcelBorderStyle getTopBorder(){
      return _topBorder;
    }

    
    public void setTopBorder(io.nop.excel.model.ExcelBorderStyle value){
        checkAllowChange();
        
        this._topBorder = value;
           
    }

    
    /**
     * 
     * xml name: verticalAlign
     *  
     */
    
    public io.nop.excel.model.constants.ExcelVerticalAlignment getVerticalAlign(){
      return _verticalAlign;
    }

    
    public void setVerticalAlign(io.nop.excel.model.constants.ExcelVerticalAlignment value){
        checkAllowChange();
        
        this._verticalAlign = value;
           
    }

    
    /**
     * 
     * xml name: wrapText
     *  
     */
    
    public boolean isWrapText(){
      return _wrapText;
    }

    
    public void setWrapText(boolean value){
        checkAllowChange();
        
        this._wrapText = value;
           
    }

    

    @Override
    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
           this._bottomBorder = io.nop.api.core.util.FreezeHelper.deepFreeze(this._bottomBorder);
            
           this._diagonalLeftBorder = io.nop.api.core.util.FreezeHelper.deepFreeze(this._diagonalLeftBorder);
            
           this._diagonalRightBorder = io.nop.api.core.util.FreezeHelper.deepFreeze(this._diagonalRightBorder);
            
           this._font = io.nop.api.core.util.FreezeHelper.deepFreeze(this._font);
            
           this._leftBorder = io.nop.api.core.util.FreezeHelper.deepFreeze(this._leftBorder);
            
           this._rightBorder = io.nop.api.core.util.FreezeHelper.deepFreeze(this._rightBorder);
            
           this._topBorder = io.nop.api.core.util.FreezeHelper.deepFreeze(this._topBorder);
            
        }
    }

    @Override
    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.putNotNull("bottomBorder",this.getBottomBorder());
        out.putNotNull("diagonalLeftBorder",this.getDiagonalLeftBorder());
        out.putNotNull("diagonalRightBorder",this.getDiagonalRightBorder());
        out.putNotNull("fillBgColor",this.getFillBgColor());
        out.putNotNull("fillFgColor",this.getFillFgColor());
        out.putNotNull("fillPattern",this.getFillPattern());
        out.putNotNull("font",this.getFont());
        out.putNotNull("hidden",this.getHidden());
        out.putNotNull("horizontalAlign",this.getHorizontalAlign());
        out.putNotNull("id",this.getId());
        out.putNotNull("indent",this.getIndent());
        out.putNotNull("leftBorder",this.getLeftBorder());
        out.putNotNull("locked",this.getLocked());
        out.putNotNull("name",this.getName());
        out.putNotNull("numberFormat",this.getNumberFormat());
        out.putNotNull("rightBorder",this.getRightBorder());
        out.putNotNull("rotate",this.getRotate());
        out.putNotNull("shrinkToFit",this.isShrinkToFit());
        out.putNotNull("topBorder",this.getTopBorder());
        out.putNotNull("verticalAlign",this.getVerticalAlign());
        out.putNotNull("wrapText",this.isWrapText());
    }

    public ExcelStyle cloneInstance(){
        ExcelStyle instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(ExcelStyle instance){
        super.copyTo(instance);
        
        instance.setBottomBorder(this.getBottomBorder());
        instance.setDiagonalLeftBorder(this.getDiagonalLeftBorder());
        instance.setDiagonalRightBorder(this.getDiagonalRightBorder());
        instance.setFillBgColor(this.getFillBgColor());
        instance.setFillFgColor(this.getFillFgColor());
        instance.setFillPattern(this.getFillPattern());
        instance.setFont(this.getFont());
        instance.setHidden(this.getHidden());
        instance.setHorizontalAlign(this.getHorizontalAlign());
        instance.setId(this.getId());
        instance.setIndent(this.getIndent());
        instance.setLeftBorder(this.getLeftBorder());
        instance.setLocked(this.getLocked());
        instance.setName(this.getName());
        instance.setNumberFormat(this.getNumberFormat());
        instance.setRightBorder(this.getRightBorder());
        instance.setRotate(this.getRotate());
        instance.setShrinkToFit(this.isShrinkToFit());
        instance.setTopBorder(this.getTopBorder());
        instance.setVerticalAlign(this.getVerticalAlign());
        instance.setWrapText(this.isWrapText());
    }

    protected ExcelStyle newInstance(){
        return (ExcelStyle) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
