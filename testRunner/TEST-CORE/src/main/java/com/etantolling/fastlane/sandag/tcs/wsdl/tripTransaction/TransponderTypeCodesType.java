
package com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TransponderTypeCodesType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TransponderTypeCodesType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="N"/&gt;
 *     &lt;enumeration value="V"/&gt;
 *     &lt;enumeration value="I"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TransponderTypeCodesType")
@XmlEnum
public enum TransponderTypeCodesType {

    N,
    V,
    I;

    public String value() {
        return name();
    }

    public static TransponderTypeCodesType fromValue(String v) {
        return valueOf(v);
    }

}
