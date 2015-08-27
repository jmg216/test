/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isa.ws;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author JMiraballes
 */
@WebService(serviceName = "ObtenerPDFWebService")
public class ObtenerPDFWebService {
    
    /**
     * Web service operation
     * @param id
     */
    @WebMethod(operationName = "obtener")
    public String obtener(@WebParam(name = "id") String id, @WebParam(name = "cedula") String cedula) {
        try {
            File readfile = new File("C:\\Users\\JMiraballes\\Documents\\UtilesISA\\Archivado.pdf");
            System.out.println(readfile.exists() + "!!");

            FileInputStream fis = new FileInputStream(readfile);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            byte[] buf = new byte[1024];
        
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                 bos.write(buf, 0, readNum); 
            }
            byte[] bytes = bos.toByteArray();
            String pdfBase64 = Base64.encodeBase64String( bytes );        
            System.out.println("String pdf en base64: " + pdfBase64);
            return pdfBase64;
        }
        catch (Exception ex) {
                return "ERROR";
        }        
    }
}
