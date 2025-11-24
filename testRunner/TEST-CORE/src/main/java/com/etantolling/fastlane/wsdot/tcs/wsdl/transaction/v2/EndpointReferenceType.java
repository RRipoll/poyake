
package com.etantolling.fastlane.wsdot.tcs.wsdl.transaction.v2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para endpointReferenceType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="endpointReferenceType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="zz"/&gt;
 *     &lt;enumeration value="KU"/&gt;
 *     &lt;enumeration value="TU"/&gt;
 *     &lt;enumeration value="TP"/&gt;
 *     &lt;enumeration value="KP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "endpointReferenceType")
@XmlEnum
public enum EndpointReferenceType {

    @XmlEnumValue("zz")
    ZZ("zz"),
    KU("KU"),
    TU("TU"),
    TP("TP"),
    KP("KP");
    private final String value;

    EndpointReferenceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EndpointReferenceType fromValue(String v) {
        for (EndpointReferenceType c: EndpointReferenceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
