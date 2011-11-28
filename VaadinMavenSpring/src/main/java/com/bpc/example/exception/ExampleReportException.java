package com.bpc.example.exception;

public class ExampleReportException extends RuntimeException {

   private static final long serialVersionUID = -1845119376613877063L;

   public ExampleReportException(Exception e) {
      super("wrapper exception", e);
   }
}
