package com.h2.org.springframework.beans.factory.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer.PlaceholderResolver;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DefaultPlaceholderResolver implements PlaceholderResolver {
   
   private static final Logger LOG = LoggerFactory.getLogger(
         ClassPathXmlApplicationContext.class);
   
   ////
   
   /** Default placeholder prefix: "${" */
   public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";

   /** Default placeholder suffix: "}" */
   public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";
   
   ////
   ////
   
   public String resolvePlaceholder(String strVal) {

      StringBuilder buf = new StringBuilder(strVal);

      int startIndex = strVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
      if (startIndex != -1) {
         int endIndex = strVal.lastIndexOf(DEFAULT_PLACEHOLDER_SUFFIX);
         if (endIndex != -1) {
            String placeholder = buf.substring(startIndex
                  + DEFAULT_PLACEHOLDER_PREFIX.length(), endIndex);
            
            //find property
            String val = getPlaceholder(placeholder);
            if(val != null) {
               buf.replace(
                     startIndex,
                     endIndex + DEFAULT_PLACEHOLDER_SUFFIX.length(),
                     val);
            }
            else {
               LOG.error("Placeholder not found: " + placeholder);
            }
         }
      }

      return buf.toString();
   }
   
   public String getPlaceholder(String strVal) {
      return null;
   }

}
