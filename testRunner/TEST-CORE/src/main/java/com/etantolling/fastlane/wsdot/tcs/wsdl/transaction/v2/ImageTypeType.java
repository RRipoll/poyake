
package com.etantolling.fastlane.wsdot.tcs.wsdl.transaction.v2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para imageTypeType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="imageTypeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ROI"/&gt;
 *     &lt;enumeration value="FSI"/&gt;
 *     &lt;enumeration value="BSI"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "imageTypeType")
@XmlEnum
public enum ImageTypeType {

    ROI,
    FSI,
    BSI;

    public String value() {
        return name();
    }

    public static ImageTypeType fromValue(String v) {
        return valueOf(v);
    }

}
