package packageMain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Machine implements Serializable{

    private static final long serialVersionUID = 1L;

    private int idMachine;

    private String name;
    
    private String descriptionMachine;

    private Double tMin;

    private Double tMax;

    private Double cMin;

    private Double cMax;

    private Double tempMin;

    private Double tempMax;

    private int typeMachine_idType;


    public String getDescriptionMachine() {
        return descriptionMachine;
    }

    public void setDescriptionMachine(String descriptionMachine) {
        this.descriptionMachine = descriptionMachine;
    }
    
    public int getTypeMachine_idType() {
        return typeMachine_idType;
    }

    public void setTypeMachine_idType(int typeMachine_idType) {
        this.typeMachine_idType = typeMachine_idType;
    }
    
    
    

    public int getIdMachine() {
	return idMachine;
    }

    public void setIdMachine(int idMachine) {
	this.idMachine = idMachine;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Double gettMin() {
	return tMin;
    }

    public void settMin(Double tMin) {
	this.tMin = tMin;
    }

    public Double gettMax() {
	return tMax;
    }

    public void settMax(Double tMax) {
	this.tMax = tMax;
    }

    public Double getcMin() {
	return cMin;
    }

    public void setcMin(Double cMin) {
	this.cMin = cMin;
    }

    public Double getcMax() {
	return cMax;
    }

    public void setcMax(Double cMax) {
	this.cMax = cMax;
    }

    public Double getTempMin() {
	return tempMin;
    }

    public void setTempMin(Double tempMin) {
	this.tempMin = tempMin;
    }

    public Double getTempMax() {
	return tempMax;
    }

    public void setTempMax(Double tempMax) {
	this.tempMax = tempMax;
    }

}
