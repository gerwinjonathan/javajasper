package com.example.javajasper.javajasper.jasperinterface;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

public interface ConvertReportImplementationInterface {
    
    public void convertReportToFilePdfInline(JasperPrint jasperPrint, HttpServletResponse response,
            String fileOutputResult) throws JRException, IOException;
    
    public void convertReportToFilePdfAttachment(JasperPrint jasperPrint, HttpServletResponse response,
            String fileOutputResult) throws JRException, IOException;

}
