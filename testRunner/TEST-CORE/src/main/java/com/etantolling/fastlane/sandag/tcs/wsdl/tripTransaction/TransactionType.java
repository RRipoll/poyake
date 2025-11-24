
package com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TransactionType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TransactionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CASH"/&gt;
 *     &lt;enumeration value="CC"/&gt;
 *     &lt;enumeration value="AVI"/&gt;
 *     &lt;enumeration value="IMG"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TransactionType")
@XmlEnum
public enum TransactionType {

    CASH,
    CC,
    AVI,
    IMG;

    public String value() {
        return name();
    }

    public static TransactionType fromValue(String v) {
        return valueOf(v);
    }

}
