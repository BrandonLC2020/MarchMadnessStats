//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.2 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2025.07.09 at 10:53:51 AM EDT 
//


package com.blc.model.v8;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for teamColorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="teamColorType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="rgbColor" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attGroup ref="{http://feed.elasticstats.com/schema/basketball/team-v8.0.xsd}teamColorAttributes"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "teamColorType", propOrder = {
    "rgbColor"
})
public class TeamColorType {

    @XmlElement(required = true)
    protected String rgbColor;
    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "hex_color")
    protected String hexColor;
    @XmlAttribute(name = "alpha")
    protected Float alpha;

    /**
     * Gets the value of the rgbColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRgbColor() {
        return rgbColor;
    }

    /**
     * Sets the value of the rgbColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRgbColor(String value) {
        this.rgbColor = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the hexColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHexColor() {
        return hexColor;
    }

    /**
     * Sets the value of the hexColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHexColor(String value) {
        this.hexColor = value;
    }

    /**
     * Gets the value of the alpha property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getAlpha() {
        return alpha;
    }

    /**
     * Sets the value of the alpha property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setAlpha(Float value) {
        this.alpha = value;
    }

}
