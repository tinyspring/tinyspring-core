package org.springframework.context;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;

public interface ApplicationContext {

	public <T> T getBean(Class<T> requiredType) throws BeansException;

	public <T> T getBean(String name, Class<T> requiredType) throws BeansException;

	public <T> Map<String,T> getBeansOfType(Class<T> requiredType) throws BeansException;

	/**
	 * @return the beanFactory
	 */
	public BeanFactory getBeanFactory();

	/**
	 * @param beanFactory
	 *            the beanFactory to set
	 */
	public void setBeanFactory(BeanFactory beanFactory);
}
