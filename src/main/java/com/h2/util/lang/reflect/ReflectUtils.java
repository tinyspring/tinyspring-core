package com.h2.util.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class ReflectUtils {
   
   
   private ReflectUtils() {
   }
   
   public static final String[] PREFIXES = new String[] {
      "get", "set", "is", "add", "has"};
   
   ////
   ////

   public static String getNormalizedName(Method method) {
      if (method == null) {
         return null;
      }
      return getNormalizedName(method.getName());
   }
   
   public static String getNormalizedName(String methodName) {
      String path = methodName;
      for (String prefix : PREFIXES) {
         if(path.startsWith(prefix)) {
            path = path.substring(prefix.length(),
                  prefix.length() + 1).toLowerCase() + path.substring(
                        prefix.length() + 1);
         }
      }
      return path;
   }
   
   public static String getDenormalizedName(Method method) {
      if (method == null) {
         return null;
      }
      return getDenormalizedName(method.getName());
   }
   
   public static String getDenormalizedName(String methodName) {
      if (methodName == null) {
         return null;
      }
      //transform name back to camel case
      return methodName.substring(0, 1).toUpperCase()
         + methodName.substring(1);
   }
   
   public static boolean isSetter(Method method) {
      return method.getName().startsWith("set");
   }
   
   public static boolean isGetter(Method method) {
      String name = method.getName();
      if(name.startsWith("get")) {
         return true;
      }
      else if(name.startsWith("is")) {
         return true;
      }
      return false;
   }
   
   /**
    * Finds the setter method for the given method.
    *
    * @param clazz
    * @param name
    * @param paramType
    * @return the setter method or null if none found
    * @since 1.0
    */
   public static Method getSetterMethod(Class<?> clazz, String name,
         Class<?> paramType) {
      String methodName = getDenormalizedName(name);
      Method result = null;
      
      try {
         result = clazz.getMethod("set" + methodName, paramType);
      } catch (SecurityException exp) {
         //do nothing
      } catch (NoSuchMethodException exp) {
         //do nothing
      }
      return result;
   }
   
   /**
    * Finds the setter method for the given method.
    *
    * @param method
    * @return the setter method or null if none found
    * @since 1.0
    */
   public static Method getSetterMethod(Class<?> clazz, String name) {
      String methodName = "set" + getDenormalizedName(name);
      try {
         Class<?> searchType = clazz;
         while (searchType != null) {
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
               if(methodName.equals(method.getName())
                     && method.getParameterTypes().length == 1) {
                  return method;
               }
            }
            searchType = searchType.getSuperclass();
         }
      } catch (SecurityException exp) {
         //do nothing
      }
      return null;
   }
   
   /**
    * Finds the setter method for the given method.
    *
    * @param method
    * @return the setter method or null if none found
    * @since 1.0
    */
   public static Method getSetterMethod(Method method) {
      String methodName = getNormalizedName(method);
      Class<?> returnType = method.getReturnType();
      Class<?> clz = method.getDeclaringClass();
      
      //transform name back to camel case
      methodName = getDenormalizedName(methodName);
      Method result = null;
      
         for (String prefix : PREFIXES) {
            try {
               result = clz.getMethod(prefix + methodName, returnType);
            } catch (SecurityException exp) {
               //do nothing
            } catch (NoSuchMethodException exp) {
               //do nothing
            }
            if (result != null) {
               //TODO check return type? -BJH
               break;
            }
         }
      return result;
   }
   
   /**
    * Finds the getter method for the given method.
    *
    * @param method
    * @return the getter method or null if none found
    * @since 1.0
    */
   public static Method getGetterMethod(Method method) {
      String methodName = getNormalizedName(method);
      Class<?> clz = method.getDeclaringClass();
      
      Method result = null;
      try {
         result = clz.getMethod("get" + getDenormalizedName(methodName));
      } catch (SecurityException exp) {
         //do nothing
      } catch (NoSuchMethodException exp) {
         //do nothing
      }
      return result;
   }
   
   /**
    * Determine whether the given class has a public constructor with the given signature,
    * and return it if available (else return <code>null</code>).
    * <p>Essentially translates <code>NoSuchMethodException</code> to <code>null</code>.
    * @param clazz   the clazz to analyze
    * @param paramTypes the parameter types of the method
    * @return the constructor, or <code>null</code> if not found
    * @see java.lang.Class#getConstructor
    */
   @SuppressWarnings("unchecked")
   public static <T> Constructor<T> getConstructor(Class<T> clazz,
         Class<?>... paramTypes) {
      try {
         return clazz.getConstructor(paramTypes);
      }
      catch (NoSuchMethodException exp) {
         Constructor<?>[] constructors = clazz.getConstructors();
         
         for (Constructor<?> constructor : constructors) {
            if(constructor.getParameterTypes().length == paramTypes.length) {
               return (Constructor<T>) constructor;
            }
         }
         return null;
      }
   }
   
   public static Integer countConstructors(Class<?> clazz,
         Integer numParams) {
      Constructor<?>[] constructors = clazz.getConstructors();
      
      Integer result = 0;
      for (Constructor<?> constructor : constructors) {
         if(constructor.getParameterTypes().length == numParams) {
            result++;
         }
      }
      return result;
   }
   
//   /**
//    * Determine whether the given class has a public constructor with the given signature,
//    * and return it if available (else return <code>null</code>).
//    * <p>Essentially translates <code>NoSuchMethodException</code> to <code>null</code>.
//    * @param clazz   the clazz to analyze
//    * @param paramTypes the parameter types of the method
//    * @return the constructor, or <code>null</code> if not found
//    * @see java.lang.Class#getConstructor
//    */
//   @SuppressWarnings("unchecked")
//   public static <T> Constructor<T> getConstructor(Class<T> clazz,
//         Class<?>... paramTypes) {
//      Constructor<?>[] constructors = clazz.getConstructors();
//      
//      for (Constructor<?> constructor : constructors) {
//         if(constructor.getParameterTypes().length == paramTypes.length) {
//            
//            for (Class<?> paramType : paramTypes) {
//               
//            }
//            
//            return (Constructor<T>) constructor;
//         }
//      }
//      return null;
//   }
}
