package io.nop.data_.init.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.data_.init.model.DataInitModel;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/data-init.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _DataInitModel extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: tables
     * 
     */
    private KeyedList<io.nop.data_.init.model.TableInitModel> _tables = KeyedList.emptyList();
    
    /**
     * 
     * xml name: tables
     *  
     */
    
    public java.util.List<io.nop.data_.init.model.TableInitModel> getTables(){
      return _tables;
    }

    
    public void setTables(java.util.List<io.nop.data_.init.model.TableInitModel> value){
        checkAllowChange();
        
        this._tables = KeyedList.fromList(value, io.nop.data_.init.model.TableInitModel::getTableName);
           
    }

    
    public io.nop.data_.init.model.TableInitModel getTable(String name){
        return this._tables.getByKey(name);
    }

    public boolean hasTable(String name){
        return this._tables.containsKey(name);
    }

    public void addTable(io.nop.data_.init.model.TableInitModel item) {
        checkAllowChange();
        java.util.List<io.nop.data_.init.model.TableInitModel> list = this.getTables();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(io.nop.data_.init.model.TableInitModel::getTableName);
            setTables(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_tables(){
        return this._tables.keySet();
    }

    public boolean hasTables(){
        return !this._tables.isEmpty();
    }
    

    @Override
    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
           this._tables = io.nop.api.core.util.FreezeHelper.deepFreeze(this._tables);
            
        }
    }

    @Override
    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.putNotNull("tables",this.getTables());
    }

    public DataInitModel cloneInstance(){
        DataInitModel instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(DataInitModel instance){
        super.copyTo(instance);
        
        instance.setTables(this.getTables());
    }

    protected DataInitModel newInstance(){
        return (DataInitModel) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
