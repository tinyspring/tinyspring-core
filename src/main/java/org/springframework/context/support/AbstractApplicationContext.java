package org.springframework.context.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;

public class AbstractApplicationContext {
   
   private BeanFactory _beanFactory;

   public <T> T getBean(Class<T> requiredType) throws BeansException {
      return getBeanFactory().getBean(requiredType);
   }
   
   public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
      return getBeanFactory().getBean(name, requiredType);
   }

   /**
    * @return the beanFactory
    */
   public BeanFactory getBeanFactory() {
      return _beanFactory;
   }

   /**
    * @param beanFactory the beanFactory to set
    */
   public void setBeanFactory(BeanFactory beanFactory) {
      _beanFactory = beanFactory;
   }
}
