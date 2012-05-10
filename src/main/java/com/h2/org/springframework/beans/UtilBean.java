package com.h2.org.springframework.beans;

public class UtilBean extends Bean {
   
   private String _valueType;
   
   ////
   ////

   /**
    * @return the valueType
    */
   public String getValueType() {
      return _valueType;
   }

   /**
    * @param valueType the valueType to set
    */
   public void setValueType(String valueType) {
      _valueType = valueType;
   }

}
