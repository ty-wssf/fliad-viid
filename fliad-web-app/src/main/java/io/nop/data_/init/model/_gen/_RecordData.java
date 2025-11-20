package io.nop.data_.init.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.data_.init.model.RecordData;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/data-init.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _RecordData extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: 
     * 
     */
    private java.util.Map<java.lang.String,java.lang.String> _attributes ;
    
    /**
     *  
     * xml name: sid
     * 
     */
    private java.lang.String _sid ;
    
    /**
     * 
     * xml name: 
     *  
     */
    
    public java.util.Map<java.lang.String,java.lang.String> getAttributes(){
      return _attributes;
    }

    
    public void setAttributes(java.util.Map<java.lang.String,java.lang.String> value){
        checkAllowChange();
        
        this._attributes = value;
           
    }

    
    public boolean hasAttributes(){
        return this._attributes != null && !this._attributes.isEmpty();
    }
    
    /**
     * 
     * xml name: sid
     *  
     */
    
    public java.lang.String getSid(){
      return _sid;
    }

    
    public void setSid(java.lang.String value){
        checkAllowChange();
        
        this._sid = value;
           
    }

    

    @Override
    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
           this._attributes = io.nop.api.core.util.FreezeHelper.deepFreeze(this._attributes);
            
        }
    }

    @Override
    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.putNotNull("attributes",this.getAttributes());
        out.putNotNull("sid",this.getSid());
    }

    public RecordData cloneInstance(){
        RecordData instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(RecordData instance){
        super.copyTo(instance);
        
        instance.setAttributes(this.getAttributes());
        instance.setSid(this.getSid());
    }

    protected RecordData newInstance(){
        return (RecordData) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
