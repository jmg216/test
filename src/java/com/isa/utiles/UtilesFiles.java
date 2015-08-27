/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isa.utiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author JMiraballes
 */
public class UtilesFiles {
    /**
     * Método encargado de crear una carpeta. La misma
     * se crea bajo la ruta absoluta pasada por parámetro.
     * */
    public static void crearCarpeta( String ruta ){
            File file = new File( ruta );
            if (!file.exists()) {
                    if (!file.mkdir()) {
                    }
            }		
    }

    /**
     * Método que copia un archivo desde una carpeta a otra.
     * Se pasa por parámetro el archivo fuente que se va
     * copiar y el archivo destino al cual se le copiarán 
     * los datos.
     * */
    public static void copiarArchivo(File source, File dest) throws IOException {
            InputStream input = null;
            OutputStream output = null;
            try {
                    input = new FileInputStream(source);
                    output = new FileOutputStream(dest);
                    byte[] buf = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = input.read(buf)) > 0) {
                            output.write(buf, 0, bytesRead);
                    }
            } finally {
                    input.close();
                    output.close();
            }
    }	

    /**
     * Mueve un archivo de una carpeta a otra.
     * 
     * @param source: archivo origen
     * @param dest: archivo destino
     * @throws IOException
     */
    public static void moverArchivo(File source, File dest) throws IOException {
            copiarArchivo(source, dest);
            eliminarArchivo(source);
    }
	
    /**
     * Método utilizado para elimnar un archivo.
     *
 * @param file */
    public static void eliminarArchivo(File file) throws IOException{

            if (file.exists()) {
                    file.delete();
            }
    }  
    
    public static File crearArchivo (String ruta ){
        try{
            System.out.println("Creando archivo: " + ruta );
            File file = new File( ruta );
            if (!file.exists()) {
                    file.createNewFile();

            }
            return file;
        }
        catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }
    
    public static File crearArchivosFromBytes(byte[] documento, String fileName) {
        System.out.println("Creando archivo: " + fileName);
        File archivo = new File(fileName);
        try {
                FileOutputStream fos = new FileOutputStream(archivo);
                fos.write(documento);
                fos.close();
                fos.flush();
        } 
        catch (Exception x) {
                x.printStackTrace();
                if (archivo != null)
                        archivo.delete();
                return null;
        }
        return archivo;
    }	    
    
}
