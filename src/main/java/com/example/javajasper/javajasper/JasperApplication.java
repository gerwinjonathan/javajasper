package com.example.javajasper.javajasper;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.example.javajasper.javajasper.jasperimpl.JasperImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;

@RestController
public class JasperApplication {

    @Autowired
    JasperImplementation jasperImplementation;

    @RequestMapping(value = "/hello")
    public String index() {
        return "Test Spring Boot";
    }

    @RequestMapping(value = "/getDataToJasper")
	public void getDataToJasper(HttpServletResponse response) throws IOException, JRException {
		try {
            jasperImplementation.getDataToJasper(response);
        } catch (Exception e) {
            System.out.println(e);
        }
	}
}
