package com.tinyspring.beans.factory;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.util.AntPathMatcher;

public class ResourceResolver {
   
   public static final String CLASSPATH = "classpath";
   
   ////
   ////
   
   public String resolvePath(String path) {
      
      if(path.startsWith(CLASSPATH)) {
         if(path.startsWith(CLASSPATH + "*:")) {
            return resolveClassPath(
                  path.substring((CLASSPATH + "*:").length()), true);
         }
         else if(path.startsWith(CLASSPATH + ":")) {
            return resolveClassPath(
                  path.substring((CLASSPATH + ":").length()), false);
         }
      }
      return path;
   }
   
   protected String resolveClassPath(String path,
         boolean searchSubDirectories) {
      String path2 = getClass().getClassLoader().getResource("").getPath();
      File topDir = null;
      try {
         topDir = new File(URLDecoder.decode(path2, "UTF-8"));
      } catch (UnsupportedEncodingException exp) {
         // TODO Auto-generated catch block
         exp.printStackTrace();
      }
      
      if(path.startsWith("\\") || path.startsWith("/")) {
         path = path.substring(1);
      }
      return resolveClassPathHelper(path, topDir, searchSubDirectories);
   }
   
   protected String resolveClassPathHelper(String path, File topDir,
         boolean searchSubDirectories) {
      File[] subDirs = topDir.listFiles();
      AntPathMatcher pathMatcher = new AntPathMatcher();
      String result = null;
      for (File file : subDirs) {
         if(pathMatcher.matchStart(path, file.getName())) {
            result = file.getPath();
            if(file.isDirectory()) {
               return topDir.getPath() + "\\" + path;
            }
         }
         else if(file.isDirectory() && searchSubDirectories) {
            result = resolveClassPathHelper(path, file, searchSubDirectories);
         }
         
         if(result != null) {
            break;
         }
      }
      return result;
   }

}
