
package com.etantolling.fastlane.wsdot.tcs.wsdl.transaction.v2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para plateStateType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="plateStateType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="AL"/&gt;
 *     &lt;enumeration value="AK"/&gt;
 *     &lt;enumeration value="AZ"/&gt;
 *     &lt;enumeration value="AR"/&gt;
 *     &lt;enumeration value="CA"/&gt;
 *     &lt;enumeration value="CO"/&gt;
 *     &lt;enumeration value="CT"/&gt;
 *     &lt;enumeration value="DE"/&gt;
 *     &lt;enumeration value="FL"/&gt;
 *     &lt;enumeration value="GA"/&gt;
 *     &lt;enumeration value="HI"/&gt;
 *     &lt;enumeration value="ID"/&gt;
 *     &lt;enumeration value="IL"/&gt;
 *     &lt;enumeration value="IN"/&gt;
 *     &lt;enumeration value="IA"/&gt;
 *     &lt;enumeration value="KS"/&gt;
 *     &lt;enumeration value="KY"/&gt;
 *     &lt;enumeration value="LA"/&gt;
 *     &lt;enumeration value="ME"/&gt;
 *     &lt;enumeration value="MD"/&gt;
 *     &lt;enumeration value="MA"/&gt;
 *     &lt;enumeration value="MI"/&gt;
 *     &lt;enumeration value="MN"/&gt;
 *     &lt;enumeration value="MS"/&gt;
 *     &lt;enumeration value="MO"/&gt;
 *     &lt;enumeration value="MT"/&gt;
 *     &lt;enumeration value="NE"/&gt;
 *     &lt;enumeration value="NV"/&gt;
 *     &lt;enumeration value="NH"/&gt;
 *     &lt;enumeration value="NJ"/&gt;
 *     &lt;enumeration value="NM"/&gt;
 *     &lt;enumeration value="NY"/&gt;
 *     &lt;enumeration value="NC"/&gt;
 *     &lt;enumeration value="ND"/&gt;
 *     &lt;enumeration value="OH"/&gt;
 *     &lt;enumeration value="OK"/&gt;
 *     &lt;enumeration value="OR"/&gt;
 *     &lt;enumeration value="PA"/&gt;
 *     &lt;enumeration value="RI"/&gt;
 *     &lt;enumeration value="SC"/&gt;
 *     &lt;enumeration value="SD"/&gt;
 *     &lt;enumeration value="TN"/&gt;
 *     &lt;enumeration value="TX"/&gt;
 *     &lt;enumeration value="UT"/&gt;
 *     &lt;enumeration value="VT"/&gt;
 *     &lt;enumeration value="VA"/&gt;
 *     &lt;enumeration value="WA"/&gt;
 *     &lt;enumeration value="WV"/&gt;
 *     &lt;enumeration value="WI"/&gt;
 *     &lt;enumeration value="WY"/&gt;
 *     &lt;enumeration value="AB"/&gt;
 *     &lt;enumeration value="BC"/&gt;
 *     &lt;enumeration value="MB"/&gt;
 *     &lt;enumeration value="NB"/&gt;
 *     &lt;enumeration value="NL"/&gt;
 *     &lt;enumeration value="NS"/&gt;
 *     &lt;enumeration value="NT"/&gt;
 *     &lt;enumeration value="NU"/&gt;
 *     &lt;enumeration value="ON"/&gt;
 *     &lt;enumeration value="PE"/&gt;
 *     &lt;enumeration value="QC"/&gt;
 *     &lt;enumeration value="SK"/&gt;
 *     &lt;enumeration value="YT"/&gt;
 *     &lt;enumeration value="AGU"/&gt;
 *     &lt;enumeration value="BCN"/&gt;
 *     &lt;enumeration value="BCS"/&gt;
 *     &lt;enumeration value="CAM"/&gt;
 *     &lt;enumeration value="CHP"/&gt;
 *     &lt;enumeration value="CHH"/&gt;
 *     &lt;enumeration value="COA"/&gt;
 *     &lt;enumeration value="COL"/&gt;
 *     &lt;enumeration value="CMX"/&gt;
 *     &lt;enumeration value="DUR"/&gt;
 *     &lt;enumeration value="GUA"/&gt;
 *     &lt;enumeration value="GRO"/&gt;
 *     &lt;enumeration value="HID"/&gt;
 *     &lt;enumeration value="JAL"/&gt;
 *     &lt;enumeration value="MEX"/&gt;
 *     &lt;enumeration value="MIC"/&gt;
 *     &lt;enumeration value="MOR"/&gt;
 *     &lt;enumeration value="NAY"/&gt;
 *     &lt;enumeration value="NLE"/&gt;
 *     &lt;enumeration value="OAX"/&gt;
 *     &lt;enumeration value="PUE"/&gt;
 *     &lt;enumeration value="QUE"/&gt;
 *     &lt;enumeration value="ROO"/&gt;
 *     &lt;enumeration value="SLP"/&gt;
 *     &lt;enumeration value="SIN"/&gt;
 *     &lt;enumeration value="SON"/&gt;
 *     &lt;enumeration value="TAB"/&gt;
 *     &lt;enumeration value="TAM"/&gt;
 *     &lt;enumeration value="TLA"/&gt;
 *     &lt;enumeration value="VER"/&gt;
 *     &lt;enumeration value="YUC"/&gt;
 *     &lt;enumeration value="ZAC"/&gt;
 *     &lt;enumeration value="DC"/&gt;
 *     &lt;enumeration value="AS"/&gt;
 *     &lt;enumeration value="FM"/&gt;
 *     &lt;enumeration value="GU"/&gt;
 *     &lt;enumeration value="MH"/&gt;
 *     &lt;enumeration value="MP"/&gt;
 *     &lt;enumeration value="PW"/&gt;
 *     &lt;enumeration value="PR"/&gt;
 *     &lt;enumeration value="VI"/&gt;
 *     &lt;enumeration value="LB"/&gt;
 *     &lt;enumeration value="PQ"/&gt;
 *     &lt;enumeration value="US"/&gt;
 *     &lt;enumeration value="AA"/&gt;
 *     &lt;enumeration value="AE"/&gt;
 *     &lt;enumeration value="AP"/&gt;
 *     &lt;enumeration value="II"/&gt;
 *     &lt;enumeration value="DHS"/&gt;
 *     &lt;enumeration value="FD"/&gt;
 *     &lt;enumeration value="GSA"/&gt;
 *     &lt;enumeration value="DL"/&gt;
 *     &lt;enumeration value="FC"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "plateStateType")
@XmlEnum
public enum PlateStateType {

    AL,
    AK,
    AZ,
    AR,
    CA,
    CO,
    CT,
    DE,
    FL,
    GA,
    HI,
    ID,
    IL,
    IN,
    IA,
    KS,
    KY,
    LA,
    ME,
    MD,
    MA,
    MI,
    MN,
    MS,
    MO,
    MT,
    NE,
    NV,
    NH,
    NJ,
    NM,
    NY,
    NC,
    ND,
    OH,
    OK,
    OR,
    PA,
    RI,
    SC,
    SD,
    TN,
    TX,
    UT,
    VT,
    VA,
    WA,
    WV,
    WI,
    WY,
    AB,
    BC,
    MB,
    NB,
    NL,
    NS,
    NT,
    NU,
    ON,
    PE,
    QC,
    SK,
    YT,
    AGU,
    BCN,
    BCS,
    CAM,
    CHP,
    CHH,
    COA,
    COL,
    CMX,
    DUR,
    GUA,
    GRO,
    HID,
    JAL,
    MEX,
    MIC,
    MOR,
    NAY,
    NLE,
    OAX,
    PUE,
    QUE,
    ROO,
    SLP,
    SIN,
    SON,
    TAB,
    TAM,
    TLA,
    VER,
    YUC,
    ZAC,
    DC,
    AS,
    FM,
    GU,
    MH,
    MP,
    PW,
    PR,
    VI,
    LB,
    PQ,
    US,
    AA,
    AE,
    AP,
    II,
    DHS,
    FD,
    GSA,
    DL,
    FC;

    public String value() {
        return name();
    }

    public static PlateStateType fromValue(String v) {
        return valueOf(v);
    }

}
