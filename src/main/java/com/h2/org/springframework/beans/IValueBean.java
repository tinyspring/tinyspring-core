package com.h2.org.springframework.beans;

public interface IValueBean {
   
   public String getName();
   
   public void setName(String name);

   public String getValue();
   
   public void setValue(String value);
   
   public String getRef();
   
   public void setRef(String ref);
   
   public Bean getBean();
   
   public void setBean(Bean bean);
   
}
