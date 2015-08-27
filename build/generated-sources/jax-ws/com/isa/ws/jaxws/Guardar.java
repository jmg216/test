
package com.isa.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "guardar", namespace = "http://ws.isa.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "guardar", namespace = "http://ws.isa.com/", propOrder = {
    "id",
    "cedula",
    "documento"
})
public class Guardar {

    @XmlElement(name = "id", namespace = "")
    private String id;
    @XmlElement(name = "cedula", namespace = "")
    private String cedula;
    @XmlElement(name = "documento", namespace = "")
    private String documento;

    /**
     * 
     * @return
     *     returns String
     */
    public String getId() {
        return this.id;
    }

    /**
     * 
     * @param id
     *     the value for the id property
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getCedula() {
        return this.cedula;
    }

    /**
     * 
     * @param cedula
     *     the value for the cedula property
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getDocumento() {
        return this.documento;
    }

    /**
     * 
     * @param documento
     *     the value for the documento property
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

}
