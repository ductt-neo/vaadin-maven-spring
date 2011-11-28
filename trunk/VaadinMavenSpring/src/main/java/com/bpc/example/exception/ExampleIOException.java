package com.bpc.example.exception;

public class ExampleIOException extends RuntimeException {

   /**
    * 
    */
   private static final long serialVersionUID = 456551282604884690L;

   public ExampleIOException(Exception e) {
      super("wrapper for general exception", e);
   }
}
