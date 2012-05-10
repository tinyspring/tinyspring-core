package com.h2.org.springframework.beans;

public class PropertyBean implements IValueBean {
   
   private String _name;
   
   private String _ref;
   
   private String _value;
   
   private Bean _bean;
   
   ////
   ////

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

}
