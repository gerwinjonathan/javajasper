package com.example.javajasper.javajasper.jasperimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class JasperCompiler {

    private String fileJasper;

    public JasperReport returnJasperReport() throws IOException, JRException {
        FileInputStream fileInputStream = new FileInputStream(new File(getFileJasper()));
        return (JasperReport) JRLoader.loadObject(fileInputStream);
    }
    
    public void setFileJasper(String fileJasper) {
        this.fileJasper = fileJasper;
    }

    public String getFileJasper() {
        return fileJasper;
    }
    
}
