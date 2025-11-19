package io.nop.core.model.lang._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.core.model.lang.FieldMetaModel;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/lang/class.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _FieldMetaModel extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: annotations
     * 
     */
    private io.nop.core.lang.xml.XNode _annotations ;
    
    /**
     *  
     * xml name: description
     * 
     */
    private String _description ;
    
    /**
     *  
     * xml name: dict
     * 
     */
    private String _dict ;
    
    /**
     *  
     * xml name: displayName
     * 
     */
    private String _displayName ;
    
    /**
     *  
     * xml name: name
     * 
     */
    private String _name ;
    
    /**
     *  
     * xml name: nullable
     * 
     */
    private Boolean _nullable ;
    
    /**
     *  
     * xml name: type
     * 
     */
    private io.nop.core.type.IGenericType _type ;
    
    /**
     * 
     * xml name: annotations
     *  
     */
    
    public io.nop.core.lang.xml.XNode getAnnotations(){
      return _annotations;
    }

    
    public void setAnnotations(io.nop.core.lang.xml.XNode value){
        checkAllowChange();
        
        this._annotations = value;
           
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
     * xml name: dict
     *  
     */
    
    public String getDict(){
      return _dict;
    }

    
    public void setDict(String value){
        checkAllowChange();
        
        this._dict = value;
           
    }

    
    /**
     * 
     * xml name: displayName
     *  
     */
    
    public String getDisplayName(){
      return _displayName;
    }

    
    public void setDisplayName(String value){
        checkAllowChange();
        
        this._displayName = value;
           
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
     * xml name: nullable
     *  
     */
    
    public Boolean getNullable(){
      return _nullable;
    }

    
    public void setNullable(Boolean value){
        checkAllowChange();
        
        this._nullable = value;
           
    }

    
    /**
     * 
     * xml name: type
     *  
     */
    
    public io.nop.core.type.IGenericType getType(){
      return _type;
    }

    
    public void setType(io.nop.core.type.IGenericType value){
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
        
        out.putNotNull("annotations",this.getAnnotations());
        out.putNotNull("description",this.getDescription());
        out.putNotNull("dict",this.getDict());
        out.putNotNull("displayName",this.getDisplayName());
        out.putNotNull("name",this.getName());
        out.putNotNull("nullable",this.getNullable());
        out.putNotNull("type",this.getType());
    }

    public FieldMetaModel cloneInstance(){
        FieldMetaModel instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(FieldMetaModel instance){
        super.copyTo(instance);
        
        instance.setAnnotations(this.getAnnotations());
        instance.setDescription(this.getDescription());
        instance.setDict(this.getDict());
        instance.setDisplayName(this.getDisplayName());
        instance.setName(this.getName());
        instance.setNullable(this.getNullable());
        instance.setType(this.getType());
    }

    protected FieldMetaModel newInstance(){
        return (FieldMetaModel) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
