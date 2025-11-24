
package com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TransponderStatusCodesType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TransponderStatusCodesType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="N"/&gt;
 *     &lt;enumeration value="L"/&gt;
 *     &lt;enumeration value="S"/&gt;
 *     &lt;enumeration value="B"/&gt;
 *     &lt;enumeration value="H"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TransponderStatusCodesType")
@XmlEnum
public enum TransponderStatusCodesType {

    N,
    L,
    S,
    B,
    H;

    public String value() {
        return name();
    }

    public static TransponderStatusCodesType fromValue(String v) {
        return valueOf(v);
    }

}
