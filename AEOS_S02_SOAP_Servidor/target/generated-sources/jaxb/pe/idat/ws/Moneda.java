//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.09.30 a las 10:38:01 AM PET 
//


package pe.idat.ws;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para moneda.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <pre>
 * &lt;simpleType name="moneda"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Sol"/&gt;
 *     &lt;enumeration value="Dólar"/&gt;
 *     &lt;enumeration value="Bolívar"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "moneda")
@XmlEnum
public enum Moneda {

    @XmlEnumValue("Sol")
    SOL("Sol"),
    @XmlEnumValue("D\u00f3lar")
    DÓLAR("D\u00f3lar"),
    @XmlEnumValue("Bol\u00edvar")
    BOLÍVAR("Bol\u00edvar");
    private final String value;

    Moneda(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Moneda fromValue(String v) {
        for (Moneda c: Moneda.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
