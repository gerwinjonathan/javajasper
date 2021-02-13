package com.example.javajasper.javajasper.jasperimpl;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.example.javajasper.javajasper.jasperconstant.Constant;
import com.example.javajasper.javajasper.jasperinterface.JasperInterface;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;

/**
 * @author GJ
 * @version 1.0 Implement Jasper from Spring Java
 */
@Service
public class JasperImplementation implements JasperInterface {

    @Override
    public void getDataToJasper(HttpServletResponse response) throws IOException, JRException {

        // Step 1 : Compile JRXML File to Jasper Format File
        JasperCompiler jasperCompiler = new JasperCompiler();
        jasperCompiler.setFileJasper("H:\\Developer Story\\repo\\dev-java\\document\\JasperReport.jasper");

        // Step 2 : Compile Report from Jasper
        /*
         * JasperReport jasperCompiler: Compile report
         * Hashmap Parameter: HashMap input data from parameter
         * List Data Source: List of object data source
         * String extension: Extension for export report
         * String convertTo: String pdf response: HttpServletResponse fileOutputName:
         * String fileOutputName: giving output file name
         * int option: Number of formatting export (See Constant)
         */
        CompileReportFile compileReportFile = new CompileReportFile();
        compileReportFile.compileReportToFile(jasperCompiler.returnJasperReport(), null, null, "pdf", response,
                "TEST", Constant.GroupOptions.OPTION_PDF_INLINE);
    }
}
