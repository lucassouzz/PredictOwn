package packageMain;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table (name="valuesMachine")

public class Values {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int idValues;
	
	private Date dateHour;
	
	private BigDecimal t1;
	
	private BigDecimal t2;
	
	private BigDecimal t3;
	
	private BigDecimal c1;
	
	private BigDecimal c2;
	
	private BigDecimal c3;

	private BigDecimal localTemp;
	
	private BigDecimal localHum;
	
	private BigDecimal machineTemp;
	
	@ManyToOne
	@JoinColumn(name = "idMachine")
	private Machine machine_idMachine;


	public Machine getMachine_idMachine() {
	    return machine_idMachine;
	}

	public void setMachine_idMachine(Machine machine_idMachine) {
	    this.machine_idMachine = machine_idMachine;
	}

	
	
	public int getIdValues() {
		return idValues;
	}

	public void setIdValues(int idValues) {
		this.idValues = idValues;
	}

	public Date getDateHour() {
		return dateHour;
	}

	public void setDateHour(Date dateHour) {
		this.dateHour = dateHour;
	}

	public BigDecimal getT1() {
		return t1;
	}

	public void setT1(BigDecimal t1) {
		this.t1 = t1;
	}

	public BigDecimal getT2() {
		return t2;
	}

	public void setT2(BigDecimal t2) {
		this.t2 = t2;
	}

	public BigDecimal getT3() {
		return t3;
	}

	public void setT3(BigDecimal t3) {
		this.t3 = t3;
	}

	public BigDecimal getC1() {
		return c1;
	}

	public void setC1(BigDecimal c1) {
		this.c1 = c1;
	}

	public BigDecimal getC2() {
		return c2;
	}

	public void setC2(BigDecimal c2) {
		this.c2 = c2;
	}

	public BigDecimal getC3() {
		return c3;
	}

	public void setC3(BigDecimal c3) {
		this.c3 = c3;
	}

	public BigDecimal getLocalTemp() {
		return localTemp;
	}

	public void setLocalTemp(BigDecimal localTemp) {
		this.localTemp = localTemp;
	}

	public BigDecimal getLocalHum() {
		return localHum;
	}

	public void setLocalHum(BigDecimal localHum) {
		this.localHum = localHum;
	}

	public BigDecimal getMachineTemp() {
		return machineTemp;
	}

	public void setMachineTemp(BigDecimal machineTemp) {
		this.machineTemp = machineTemp;
	}



}
