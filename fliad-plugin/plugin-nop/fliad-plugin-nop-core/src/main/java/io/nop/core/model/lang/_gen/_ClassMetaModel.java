package io.nop.core.model.lang._gen;

import io.nop.commons.collections.KeyedList; //NOPMD NOSONAR - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;
import io.nop.core.model.lang.ClassMetaModel;
import io.nop.commons.util.ClassHelper;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from /nop/schema/lang/class.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S101","java:S1128","java:S1161"})
public abstract class _ClassMetaModel extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: annotations
     * 
     */
    private io.nop.core.lang.xml.XNode _annotations ;
    
    /**
     *  
     * xml name: classes
     * 
     */
    private KeyedList<ClassMetaModel> _classes = KeyedList.emptyList();
    
    /**
     *  
     * xml name: description
     * 
     */
    private String _description ;
    
    /**
     *  
     * xml name: displayName
     * 
     */
    private String _displayName ;
    
    /**
     *  
     * xml name: extends
     * 
     */
    private io.nop.core.type.IGenericType _extends ;
    
    /**
     *  
     * xml name: fields
     * 
     */
    private KeyedList<io.nop.core.model.lang.FieldMetaModel> _fields = KeyedList.emptyList();
    
    /**
     *  
     * xml name: implements
     * 
     */
    private java.util.List<io.nop.core.type.IGenericType> _implements ;
    
    /**
     *  
     * xml name: methods
     * 
     */
    private KeyedList<io.nop.core.model.lang.MethodMetaModel> _methods = KeyedList.emptyList();
    
    /**
     *  
     * xml name: name
     * 
     */
    private String _name ;
    
    /**
     *  
     * xml name: package
     * 
     */
    private String _package ;
    
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
     * xml name: classes
     *  
     */
    
    public java.util.List<ClassMetaModel> getClasses(){
      return _classes;
    }

    
    public void setClasses(java.util.List<ClassMetaModel> value){
        checkAllowChange();
        
        this._classes = KeyedList.fromList(value, ClassMetaModel::getName);
           
    }

    
    public ClassMetaModel getClassName(String name){
        return this._classes.getByKey(name);
    }

    public boolean hasClassName(String name){
        return this._classes.containsKey(name);
    }

    public void addClassName(ClassMetaModel item) {
        checkAllowChange();
        java.util.List<ClassMetaModel> list = this.getClasses();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(ClassMetaModel::getName);
            setClasses(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_classes(){
        return this._classes.keySet();
    }

    public boolean hasClasses(){
        return !this._classes.isEmpty();
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
     * xml name: extends
     *  
     */
    
    public io.nop.core.type.IGenericType getExtends(){
      return _extends;
    }

    
    public void setExtends(io.nop.core.type.IGenericType value){
        checkAllowChange();
        
        this._extends = value;
           
    }

    
    /**
     * 
     * xml name: fields
     *  
     */
    
    public java.util.List<io.nop.core.model.lang.FieldMetaModel> getFields(){
      return _fields;
    }

    
    public void setFields(java.util.List<io.nop.core.model.lang.FieldMetaModel> value){
        checkAllowChange();
        
        this._fields = KeyedList.fromList(value, io.nop.core.model.lang.FieldMetaModel::getName);
           
    }

    
    public io.nop.core.model.lang.FieldMetaModel getField(String name){
        return this._fields.getByKey(name);
    }

    public boolean hasField(String name){
        return this._fields.containsKey(name);
    }

    public void addField(io.nop.core.model.lang.FieldMetaModel item) {
        checkAllowChange();
        java.util.List<io.nop.core.model.lang.FieldMetaModel> list = this.getFields();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(io.nop.core.model.lang.FieldMetaModel::getName);
            setFields(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_fields(){
        return this._fields.keySet();
    }

    public boolean hasFields(){
        return !this._fields.isEmpty();
    }
    
    /**
     * 
     * xml name: implements
     *  
     */
    
    public java.util.List<io.nop.core.type.IGenericType> getImplements(){
      return _implements;
    }

    
    public void setImplements(java.util.List<io.nop.core.type.IGenericType> value){
        checkAllowChange();
        
        this._implements = value;
           
    }

    
    /**
     * 
     * xml name: methods
     *  
     */
    
    public java.util.List<io.nop.core.model.lang.MethodMetaModel> getMethods(){
      return _methods;
    }

    
    public void setMethods(java.util.List<io.nop.core.model.lang.MethodMetaModel> value){
        checkAllowChange();
        
        this._methods = KeyedList.fromList(value, io.nop.core.model.lang.MethodMetaModel::getId);
           
    }

    
    public io.nop.core.model.lang.MethodMetaModel getMethod(String name){
        return this._methods.getByKey(name);
    }

    public boolean hasMethod(String name){
        return this._methods.containsKey(name);
    }

    public void addMethod(io.nop.core.model.lang.MethodMetaModel item) {
        checkAllowChange();
        java.util.List<io.nop.core.model.lang.MethodMetaModel> list = this.getMethods();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(io.nop.core.model.lang.MethodMetaModel::getId);
            setMethods(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_methods(){
        return this._methods.keySet();
    }

    public boolean hasMethods(){
        return !this._methods.isEmpty();
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
     * xml name: package
     *  
     */
    
    public String getPackage(){
      return _package;
    }

    
    public void setPackage(String value){
        checkAllowChange();
        
        this._package = value;
           
    }

    

    @Override
    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
           this._classes = io.nop.api.core.util.FreezeHelper.deepFreeze(this._classes);
            
           this._fields = io.nop.api.core.util.FreezeHelper.deepFreeze(this._fields);
            
           this._methods = io.nop.api.core.util.FreezeHelper.deepFreeze(this._methods);
            
        }
    }

    @Override
    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.putNotNull("annotations",this.getAnnotations());
        out.putNotNull("classes",this.getClasses());
        out.putNotNull("description",this.getDescription());
        out.putNotNull("displayName",this.getDisplayName());
        out.putNotNull("extends",this.getExtends());
        out.putNotNull("fields",this.getFields());
        out.putNotNull("implements",this.getImplements());
        out.putNotNull("methods",this.getMethods());
        out.putNotNull("name",this.getName());
        out.putNotNull("package",this.getPackage());
    }

    public ClassMetaModel cloneInstance(){
        ClassMetaModel instance = newInstance();
        this.copyTo(instance);
        return instance;
    }

    protected void copyTo(ClassMetaModel instance){
        super.copyTo(instance);
        
        instance.setAnnotations(this.getAnnotations());
        instance.setClasses(this.getClasses());
        instance.setDescription(this.getDescription());
        instance.setDisplayName(this.getDisplayName());
        instance.setExtends(this.getExtends());
        instance.setFields(this.getFields());
        instance.setImplements(this.getImplements());
        instance.setMethods(this.getMethods());
        instance.setName(this.getName());
        instance.setPackage(this.getPackage());
    }

    protected ClassMetaModel newInstance(){
        return (ClassMetaModel) ClassHelper.newInstance(getClass());
    }
}
 // resume CPD analysis - CPD-ON
