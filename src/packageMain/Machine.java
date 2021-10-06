package packageMain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "machine")

public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idMachine;

    private String name;

    private BigDecimal tMin;

    private BigDecimal tMax;

    private BigDecimal cMin;

    private BigDecimal cMax;

    private BigDecimal tempMin;

    private BigDecimal tempMax;

    @OneToOne
    @JoinColumn(name = "idType")
    private TypeMachine typeMachine_idType;

    public TypeMachine getTypeMachine_idType() {
        return typeMachine_idType;
    }

    public void setTypeMachine_idType(TypeMachine typeMachine_idType) {
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

    public BigDecimal gettMin() {
	return tMin;
    }

    public void settMin(BigDecimal tMin) {
	this.tMin = tMin;
    }

    public BigDecimal gettMax() {
	return tMax;
    }

    public void settMax(BigDecimal tMax) {
	this.tMax = tMax;
    }

    public BigDecimal getcMin() {
	return cMin;
    }

    public void setcMin(BigDecimal cMin) {
	this.cMin = cMin;
    }

    public BigDecimal getcMax() {
	return cMax;
    }

    public void setcMax(BigDecimal cMax) {
	this.cMax = cMax;
    }

    public BigDecimal getTempMin() {
	return tempMin;
    }

    public void setTempMin(BigDecimal tempMin) {
	this.tempMin = tempMin;
    }

    public BigDecimal getTempMax() {
	return tempMax;
    }

    public void setTempMax(BigDecimal tempMax) {
	this.tempMax = tempMax;
    }

}
