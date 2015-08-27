/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isa.ws;

import com.isa.utiles.UtilesFiles;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.xml.wss.impl.misc.Base64;
import java.io.File;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author JMiraballes
 */
@WebService(serviceName = "GuardarPDFWebService")
public class GuardarPDFWebService {
    /**
     * Web service operation
     */
    @WebMethod(operationName = "guardar")
    public String guardar(@WebParam(name = "id") String id, @WebParam(name = "cedula") String cedula, @WebParam(name = "documento") String documento) {
        
        try 
        {
            byte[] docpdf = Base64.decode(documento.getBytes());
            File file = UtilesFiles.crearArchivosFromBytes(docpdf, "C:\\Users\\JMiraballes\\Documents\\Proyectos\\Hacienda\\wstest\\docs\\Archivo" + new Date()+ ".pdf");
            if (file == null){
                return "OK";
            }
            else{
                return "ERROR";
            }
        } 
        catch (Base64DecodingException ex) {
            Logger.getLogger(GuardarPDFWebService.class.getName()).log(Level.SEVERE, null, ex);
            return "ERROR";
        }
    }
}
