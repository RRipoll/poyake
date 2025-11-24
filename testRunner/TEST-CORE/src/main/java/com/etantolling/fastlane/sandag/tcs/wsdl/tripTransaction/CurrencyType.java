
package com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CurrencyType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="CurrencyType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="USD"/&gt;
 *     &lt;enumeration value="MXN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CurrencyType")
@XmlEnum
public enum CurrencyType {

    USD,
    MXN;

    public String value() {
        return name();
    }

    public static CurrencyType fromValue(String v) {
        return valueOf(v);
    }

}
