package com.example.javajasper.javajasper.jasperinterface;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;

public interface JasperInterface {
    
    /**
     * Add interface getDataFromJasper
     * @param response
     * @throws IOException
     * @throws JRException
     */
    public void getDataToJasper(HttpServletResponse response) throws IOException, JRException;

}
