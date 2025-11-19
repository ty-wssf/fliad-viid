package io.nop.excel.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.excel.model.ExcelPageSetup;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/excel/page-setup.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _ExcelPageSetup extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: blackAndWhite
     * 
     */
    private Boolean _blackAndWhite ;
    
    /**
     *  
     * xml name: firstPageNumber
     * 
     */
    private Integer _firstPageNumber ;
    
    /**
     *  
     * xml name: fitToHeight
     * 
     */
    private Boolean _fitToHeight ;
    
    /**
     *  
     * xml name: fitToWidth
     * 
     */
    private Boolean _fitToWidth ;
    
    /**
     *  
     * xml name: footer
     * 
     */
    private io.nop.excel.model.ExcelHeaderFooter _footer ;
    
    /**
     *  
     * xml name: gridLines
     * 
     */
    private Boolean _gridLines ;
    
    /**
     *  
     * xml name: header
     * 
     */
    private io.nop.excel.model.ExcelHeaderFooter _header ;
    
    /**
     *  
     * xml name: horizontalCentered
     * 
     */
    private Boolean _horizontalCentered ;
    
    /**
     *  
     * xml name: orientationHorizontal
     * 
     */
    private Boolean _orientationHorizontal ;
    
    /**
     *  
     * xml name: paperHeight
     * 
     */
    private Float _paperHeight ;
    
    /**
     *  
     * xml name: paperSize
     * 为ooxml中定义的标准页面大小。如果设置了paperWidth和paperHeight时，以这两个值为准
     */
    private Integer _paperSize ;
    
    /**
     *  
     * xml name: paperWidth
     * 单位为pt
     */
    private Float _paperWidth ;
    
    /**
     *  
     * xml name: scale
     * 放大百分比
     */
    private Integer _scale ;
    
    /**
     *  
     * xml name: verticalCentered
     * 
     */
    private Boolean _verticalCentered ;
    
    /**
     * 
     * xml name: blackAndWhite
     *  
     */
    
    public Boolean getBlackAndWhite(){
      return _blackAndWhite;
    }

    
    public void setBlackAndWhite(Boolean value){
        checkAllowChange();
        
        this._blackAndWhite = value;
           
    }

    
    /**
     * 
     * xml name: firstPageNumber
     *  
     */
    
    public Integer getFirstPageNumber(){
      return _firstPageNumber;
    }

    
    public void setFirstPageNumber(Integer value){
        checkAllowChange();
        
        this._firstPageNumber = value;
           
    }

    
    /**
     * 
     * xml name: fitToHeight
     *  
     */
    
    public Boolean getFitToHeight(){
      return _fitToHeight;
    }

    
    public void setFitToHeight(Boolean value){
        checkAllowChange();
        
        this._fitToHeight = value;
           
    }

    
    /**
     * 
     * xml name: fitToWidth
     *  
     */
    
    public Boolean getFitToWidth(){
      return _fitToWidth;
    }

    
    public void setFitToWidth(Boolean value){
        checkAllowChange();
        
        this._fitToWidth = value;
           
    }

    
    /**
     * 
     * xml name: footer
     *  
     */
    
    public io.nop.excel.model.ExcelHeaderFooter getFooter(){
      return _footer;
    }

    
    public void setFooter(io.nop.excel.model.ExcelHeaderFooter value){
        checkAllowChange();
        
        this._footer = value;
           
    }

    
    /**
     * 
     * xml name: gridLines
     *  
     */
    
    public Boolean getGridLines(){
      return _gridLines;
    }

    
    public void setGridLines(Boolean value){
        checkAllowChange();
        
        this._gridLines = value;
           
    }

    
    /**
     * 
     * xml name: header
     *  
     */
    
    public io.nop.excel.model.ExcelHeaderFooter getHeader(){
      return _header;
    }

    
    public void setHeader(io.nop.excel.model.ExcelHeaderFooter value){
        checkAllowChange();
        
        this._header = value;
           
    }

    
    /**
     * 
     * xml name: horizontalCentered
     *  
     */
    
    public Boolean getHorizontalCentered(){
      return _horizontalCentered;
    }

    
    public void setHorizontalCentered(Boolean value){
        checkAllowChange();
        
        this._horizontalCentered = value;
           
    }

    
    /**
     * 
     * xml name: orientationHorizontal
     *  
     */
    
    public Boolean getOrientationHorizontal(){
      return _orientationHorizontal;
    }

    
    public void setOrientationHorizontal(Boolean value){
        checkAllowChange();
        
        this._orientationHorizontal = value;
           
    }

    
    /**
     * 
     * xml name: paperHeight
     *  
     */
    
    public Float getPaperHeight(){
      return _paperHeight;
    }

    
    public void setPaperHeight(Float value){
        checkAllowChange();
        
        this._paperHeight = value;
           
    }

    
    /**
     * 
     * xml name: paperSize
     *  为ooxml中定义的标准页面大小。如果设置了paperWidth和paperHeight时，以这两个值为准
     */
    
    public Integer getPaperSize(){
      return _paperSize;
    }

    
    public void setPaperSize(Integer value){
        checkAllowChange();
        
        this._paperSize = value;
           
    }

    
    /**
     * 
     * xml name: paperWidth
     *  单位为pt
     */
    
    public Float getPaperWidth(){
      return _paperWidth;
    }

    
    public void setPaperWidth(Float value){
        checkAllowChange();
        
        this._paperWidth = value;
           
    }

    
    /**
     * 
     * xml name: scale
     *  放大百分比
     */
    
    public Integer getScale(){
      return _scale;
    }

    
    public void setScale(Integer value){
        checkAllowChange();
        
        this._scale = value;
           
    }

    
    /**
     * 
     * xml name: verticalCentered
     *  
     */
    
    public Boolean getVerticalCentered(){
      return _verticalCentered;
    }

    
    public void setVerticalCentered(Boolean value){
        checkAllowChange();
        
        this._verticalCentered = value;
           
    }

    

    @Override
    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
           this._footer = io.nop.api.core.util.FreezeHelper.deepFreeze(this._footer);
            
           this._header = io.nop.api.core.util.FreezeHelper.deepFreeze(this._header);
            
        }
    }

    @Override
    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.putNotNull("blackAndWhite",this.getBlackAndWhite());
        out.putNotNull("firstPageNumber",this.getFirstPageNumber());
        out.putNotNull("fitToHeight",this.getFitToHeight());
        out.putNotNull("fitToWidth",this.getFitToWidth());
        out.putNotNull("footer",this.getFooter());
        out.putNotNull("gridLines",this.getGridLines());
        out.putNotNull("header",this.getHeader());
        out.putNotNull("horizontalCentered",this.getHorizontalCentered());
        out.putNotNull("orientationHorizontal",this.getOrientationHorizontal());
        out.putNotNull("paperHeight",this.getPaperHeight());
        out.putNotNull("paperSize",this.getPaperSize());
        out.putNotNull("paperWidth",this.getPaperWidth());
        out.putNotNull("scale",this.getScale());
        out.putNotNull("verticalCentered",this.getVerticalCentered());
    }

    public ExcelPageSetup cloneInstance(){
        ExcelPageSetup instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(ExcelPageSetup instance){
        super.copyTo(instance);
        
        instance.setBlackAndWhite(this.getBlackAndWhite());
        instance.setFirstPageNumber(this.getFirstPageNumber());
        instance.setFitToHeight(this.getFitToHeight());
        instance.setFitToWidth(this.getFitToWidth());
        instance.setFooter(this.getFooter());
        instance.setGridLines(this.getGridLines());
        instance.setHeader(this.getHeader());
        instance.setHorizontalCentered(this.getHorizontalCentered());
        instance.setOrientationHorizontal(this.getOrientationHorizontal());
        instance.setPaperHeight(this.getPaperHeight());
        instance.setPaperSize(this.getPaperSize());
        instance.setPaperWidth(this.getPaperWidth());
        instance.setScale(this.getScale());
        instance.setVerticalCentered(this.getVerticalCentered());
    }

    protected ExcelPageSetup newInstance(){
        return (ExcelPageSetup) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
