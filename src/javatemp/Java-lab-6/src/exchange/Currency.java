package exchange;

import java.io.Serializable;

public class Currency implements Serializable {

    private static final long serialVersionUID = 8172654327867005345L;
    private String id;      //R01010
    private String numCode; //036
    private String charCode;//AUD
    private String nominal; //1
    private String name;    //Австралийский доллар
    private double value;   //48.2777

    public Currency(String id, String numCode, String charCode, String nominal, String name, double value) {
        this.id = id;
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String toString() {
        return name;
    }

}
