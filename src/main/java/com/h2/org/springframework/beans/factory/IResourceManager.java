package com.h2.org.springframework.beans.factory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public interface IResourceManager {
   
   public InputStream getResource(File file) throws IOException;
   
   public InputStream getResource(String file) throws IOException;
   
   public Reader getReader(File file) throws IOException;

}
