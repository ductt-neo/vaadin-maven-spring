package com.bpc.example.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bpc.example.exception.ExampleIOException;
import com.vaadin.terminal.StreamResource.StreamSource;

public class FileInputStreamSource implements StreamSource {

   private static final long serialVersionUID = -3174899159715334903L;

   private static final Log LOG = LogFactory
         .getLog(FileInputStreamSource.class);

   private File inputFile;

   public FileInputStreamSource(File inputFile) {
      this.inputFile = inputFile;
   }

   public InputStream getStream() {
      try {
         return new FileInputStream(inputFile);
      } catch (FileNotFoundException e) {
         if (LOG.isErrorEnabled())
            LOG.error(e);
         throw new ExampleIOException(e);
      }
   }

}
