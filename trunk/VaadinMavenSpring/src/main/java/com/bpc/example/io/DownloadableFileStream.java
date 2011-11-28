package com.bpc.example.io;

import java.io.File;

import com.vaadin.Application;
import com.vaadin.terminal.DownloadStream;
import com.vaadin.terminal.StreamResource;

public class DownloadableFileStream extends StreamResource {

   private static final long serialVersionUID = -2286135542506236711L;
   private String filename;

   public DownloadableFileStream(File downloadableFile, String filename,
         Application application) {
      super(new FileInputStreamSource(downloadableFile), filename, application);
      this.filename = filename;
      setMIMEType("application/octet-stream");
   }

   public DownloadStream getStream() {
      DownloadStream downloadStream = super.getStream();
      downloadStream.setParameter("Content-Disposition",
            "attachment; filename=\"" + filename + "\"");
      return downloadStream;
   }

}
