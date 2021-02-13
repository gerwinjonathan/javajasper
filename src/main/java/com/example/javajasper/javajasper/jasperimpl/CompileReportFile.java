package com.example.javajasper.javajasper.jasperimpl;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.example.javajasper.javajasper.jasperconstant.Constant;
import com.example.javajasper.javajasper.jasperinterface.ConvertReportImplementationInterface;
import com.google.common.base.Strings;


import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * @author GJ
 * @version 1.0 Compiling file report jasper
 */
public class CompileReportFile {

    public void compileReportToFile(JasperReport jasperReport, Map<String, Object> parameter, List<Object> dataSource,
            String convertTo, HttpServletResponse response, String fileOutputName, int option)
            throws IOException, JRException {

        JasperPrint jasperPrint = (dataSource == null)
                ? JasperFillManager.fillReport(jasperReport, parameter, new JREmptyDataSource())
                : JasperFillManager.fillReport(jasperReport, parameter, new JRBeanCollectionDataSource(dataSource, true));

        String fileOutputResult = Strings.isNullOrEmpty(fileOutputName) ? Constant.GroupNameDefault.DEFAULT : fileOutputName;

        convertReportToFile(jasperPrint, convertTo, response, fileOutputResult, option);
    }

    public void convertReportToFile(JasperPrint jasperPrint, String convertTo, HttpServletResponse response,
            String fileOutputResult, int option) throws IOException, JRException {
        ConvertReportImplementation convertReportImpl = new ConvertReportImplementation();
        switch (convertTo) {
            case "pdf":
                if (option == Constant.GroupOptions.OPTION_PDF_INLINE)
                    convertReportImpl.convertReportToFilePdfInline(jasperPrint, response, fileOutputResult);
                else if (option == Constant.GroupOptions.OPTION_PDF_ATTACHMENT)
                    convertReportImpl.convertReportToFilePdfAttachment(jasperPrint, response, fileOutputResult);
                break;
            default:
                break;
        }
    }

}

/**
 * @author GJ
 * @version 1.0 Converting report to file extension such as PDF, XLS, XLSX,
 *          HTML, etc.
 */
class ConvertReportImplementation implements ConvertReportImplementationInterface {

    @Override
    public void convertReportToFilePdfInline(JasperPrint jasperPrint, HttpServletResponse response,
            String fileOutputResult) throws JRException, IOException {
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        response.setContentType("application/x-pdf");
        response.setHeader("Content-Disposition", "inline;filename=" + fileOutputResult + Constant.GroupExtension.EXTENSION_PDF);
    }

    @Override
    public void convertReportToFilePdfAttachment(JasperPrint jasperPrint, HttpServletResponse response,
            String fileOutputResult) throws JRException, IOException {
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        response.setContentType("application/x-pdf");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileOutputResult + Constant.GroupExtension.EXTENSION_PDF);
    }

}
