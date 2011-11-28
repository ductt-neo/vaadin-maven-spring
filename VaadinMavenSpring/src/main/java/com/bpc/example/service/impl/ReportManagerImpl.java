package com.bpc.example.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.bpc.dao.ScoringRuleDao;
import com.bpc.example.exception.ExampleReportException;
import com.bpc.example.service.ReportManager;
import com.bpc.model.ScoringRule;

@Service("reportManager")
public class ReportManagerImpl implements ReportManager {

   private static Log LOG = LogFactory.getLog(ReportManagerImpl.class);

   private static String EXAMPLE_FILENAME = "example-";

   @Autowired
   @Qualifier("templateResource")
   private Resource templateResource;

   @Autowired
   @Qualifier("scoringRuleDao")
   private ScoringRuleDao scoringRuleDao;

   public File generateUsersReport() {
      List<ScoringRule> scoringRules = scoringRuleDao.getList();

      Map<String, List<ScoringRule>> beanParams = new HashMap<String, List<ScoringRule>>();
      beanParams.put("scoringRule", scoringRules);

      File outputFile;
      try {
         // File templateFile = templateResource.getInputStream();
         InputStream inputTemplateStream = templateResource.getInputStream();
         XLSTransformer transformer = new XLSTransformer();
         transformer.groupCollection("scoringRule.id");
         Workbook workbook = transformer.transformXLS(inputTemplateStream,
               beanParams);

         outputFile = File.createTempFile(EXAMPLE_FILENAME, ".xls");
         OutputStream outputStream = new PrintStream(outputFile);
         workbook.write(outputStream);
         outputStream.close();
      }
      catch (FileNotFoundException e) {
         if (LOG.isErrorEnabled())
            LOG.error(e);
         throw new ExampleReportException(e);
      }
      catch (InvalidFormatException e) {
         if (LOG.isErrorEnabled())
            LOG.error(e);
         throw new ExampleReportException(e);
      }
      catch (IOException e) {
         if (LOG.isErrorEnabled())
            LOG.error(e);
         throw new ExampleReportException(e);
      }
      return outputFile;
   }
}
