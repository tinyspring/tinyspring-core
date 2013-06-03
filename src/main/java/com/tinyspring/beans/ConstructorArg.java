package com.tinyspring.beans;

public class ConstructorArg implements IValueBean {
   
   private Integer _index;
   
   private String _name;
   
   private String _type;
   
   private String _value;
   
   private String _ref;
   
   private Bean _bean;
   
   private Object _instantiatedObject;
   
   ////
   ////
   
   @Override
   public String toString() {
      return String.format("Arg: %s %s %s", getName(), getType(), getValue());
   }

   /**
    * @return the index
    */
   public Integer getIndex() {
      return _index;
   }

   /**
    * @param index the index to set
    */
   public void setIndex(Integer index) {
      _index = index;
   }

   /**
    * @return the name
    */
   public String getName() {
      return _name;
   }

   /**
    * @param name the name to set
    */
   public void setName(String name) {
      _name = name;
   }

   /**
    * @return the type
    */
   public String getType() {
      return _type;
   }

   /**
    * @param type the type to set
    */
   public void setType(String type) {
      _type = type;
   }

   /**
    * @return the value
    */
   public String getValue() {
      return _value;
   }

   /**
    * @param value the value to set
    */
   public void setValue(String value) {
      _value = value;
   }

   /**
    * @return the ref
    */
   public String getRef() {
      return _ref;
   }

   /**
    * @param ref the ref to set
    */
   public void setRef(String ref) {
      _ref = ref;
   }

   /**
    * @return the instantiatedObject
    */
   public Object getInstantiatedObject() {
      return _instantiatedObject;
   }

   /**
    * @param instantiatedObject the instantiatedObject to set
    */
   public void setInstantiatedObject(Object instantiatedObject) {
      _instantiatedObject = instantiatedObject;
   }

   /**
    * @return the bean
    */
   public Bean getBean() {
      return _bean;
   }

   /**
    * @param bean the bean to set
    */
   public void setBean(Bean bean) {
      _bean = bean;
   }

}
