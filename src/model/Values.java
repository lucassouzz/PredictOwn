package model;

import java.util.GregorianCalendar;

public class Values {

    private int idValues;
    private GregorianCalendar dateHour;
    private Float t1;
    private Float t2;
    private Float t3;
    private Float c1;
    private Float c2;
    private Float c3;
    private Float localTemp;
    private Float localHumidity;
    private Float machineTemp;
    private int machine_idMachine;
    
    
    public int getIdValues() {
        return idValues;
    }
    public void setIdValues(int idValues) {
        this.idValues = idValues;
    }
    public GregorianCalendar getDateHour() {
        return dateHour;
    }
    public void setDateHour(GregorianCalendar dateHour) {
        this.dateHour = dateHour;
    }
    public Float getT1() {
        return t1;
    }
    public void setT1(Float t1) {
        this.t1 = t1;
    }
    public Float getT2() {
        return t2;
    }
    public void setT2(Float t2) {
        this.t2 = t2;
    }
    public Float getT3() {
        return t3;
    }
    public void setT3(Float t3) {
        this.t3 = t3;
    }
    public Float getC1() {
        return c1;
    }
    public void setC1(Float c1) {
        this.c1 = c1;
    }
    public Float getC2() {
        return c2;
    }
    public void setC2(Float c2) {
        this.c2 = c2;
    }
    public Float getC3() {
        return c3;
    }
    public void setC3(Float c3) {
        this.c3 = c3;
    }
    public Float getLocalTemp() {
        return localTemp;
    }
    public void setLocalTemp(Float localTemp) {
        this.localTemp = localTemp;
    }
    public Float getLocalHumidity() {
        return localHumidity;
    }
    public void setLocalHumidity(Float localHumidity) {
        this.localHumidity = localHumidity;
    }
    public Float getMachineTemp() {
        return machineTemp;
    }
    public void setMachineTemp(Float machineTemp) {
        this.machineTemp = machineTemp;
    }
    
}
