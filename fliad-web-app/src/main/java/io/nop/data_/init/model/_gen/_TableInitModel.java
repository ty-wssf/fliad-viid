package io.nop.data_.init.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.data_.init.model.TableInitModel;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/data-init.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _TableInitModel extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: data
     * 
     */
    private KeyedList<io.nop.data_.init.model.RecordData> _data = KeyedList.emptyList();
    
    /**
     *  
     * xml name: tableName
     * 
     */
    private java.lang.String _tableName ;
    
    /**
     * 
     * xml name: data
     *  
     */
    
    public java.util.List<io.nop.data_.init.model.RecordData> getData(){
      return _data;
    }

    
    public void setData(java.util.List<io.nop.data_.init.model.RecordData> value){
        checkAllowChange();
        
        this._data = KeyedList.fromList(value, io.nop.data_.init.model.RecordData::getSid);
           
    }

    
    public io.nop.data_.init.model.RecordData getRecord(String name){
        return this._data.getByKey(name);
    }

    public boolean hasRecord(String name){
        return this._data.containsKey(name);
    }

    public void addRecord(io.nop.data_.init.model.RecordData item) {
        checkAllowChange();
        java.util.List<io.nop.data_.init.model.RecordData> list = this.getData();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(io.nop.data_.init.model.RecordData::getSid);
            setData(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_data(){
        return this._data.keySet();
    }

    public boolean hasData(){
        return !this._data.isEmpty();
    }
    
    /**
     * 
     * xml name: tableName
     *  
     */
    
    public java.lang.String getTableName(){
      return _tableName;
    }

    
    public void setTableName(java.lang.String value){
        checkAllowChange();
        
        this._tableName = value;
           
    }

    

    @Override
    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
           this._data = io.nop.api.core.util.FreezeHelper.deepFreeze(this._data);
            
        }
    }

    @Override
    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.putNotNull("data",this.getData());
        out.putNotNull("tableName",this.getTableName());
    }

    public TableInitModel cloneInstance(){
        TableInitModel instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(TableInitModel instance){
        super.copyTo(instance);
        
        instance.setData(this.getData());
        instance.setTableName(this.getTableName());
    }

    protected TableInitModel newInstance(){
        return (TableInitModel) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
