package org.springframework.beans.factory.config;

public class MethodInvokingFactoryBean {

   private Object targetObject;

   private String targetMethod;

   private String staticMethod;
   
   private Object[] arguments = new Object[0];
   
   ////
   ////

   /**
    * @return the staticMethod
    */
   public String getStaticMethod() {
      return staticMethod;
   }

   /**
    * @param staticMethod the staticMethod to set
    */
   public void setStaticMethod(String staticMethod) {
      this.staticMethod = staticMethod;
   }

   /**
    * @return the targetObject
    */
   public Object getTargetObject() {
      return targetObject;
   }

   /**
    * @param targetObject the targetObject to set
    */
   public void setTargetObject(Object targetObject) {
      this.targetObject = targetObject;
   }

   /**
    * @return the targetMethod
    */
   public String getTargetMethod() {
      return targetMethod;
   }

   /**
    * @param targetMethod the targetMethod to set
    */
   public void setTargetMethod(String targetMethod) {
      this.targetMethod = targetMethod;
   }

   /**
    * @return the arguments
    */
   public Object[] getArguments() {
      return arguments;
   }

   /**
    * @param arguments the arguments to set
    */
   public void setArguments(Object[] arguments) {
      this.arguments = arguments;
   }
   
}
