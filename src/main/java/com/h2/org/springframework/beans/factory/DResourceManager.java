package com.h2.org.springframework.beans.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class DResourceManager implements IResourceManager {

   @Override
   public InputStream getResource(File file) throws FileNotFoundException {
      return new FileInputStream(file);
   }
   
   @Override
   public InputStream getResource(String path) throws FileNotFoundException {
      File file = new File(path);
      return getResource(file);
   }

   @Override
   public Reader getReader(File file) throws IOException {
      return new InputStreamReader(getResource(file)); 
   }

}
