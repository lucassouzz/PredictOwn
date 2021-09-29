package model;

public class Machine {

    private int idMachine;
    private String name;
    private float tMin;
    private float tMax;
    private float cMin;
    private float cMax;
    private float tempMin;
    private float tempMax;
    private int typeMachine_idType;
    
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
    public float gettMin() {
        return tMin;
    }
    public void settMin(float tMin) {
        this.tMin = tMin;
    }
    public float gettMax() {
        return tMax;
    }
    public void settMax(float tMax) {
        this.tMax = tMax;
    }
    public float getcMin() {
        return cMin;
    }
    public void setcMin(float cMin) {
        this.cMin = cMin;
    }
    public float getcMax() {
        return cMax;
    }
    public void setcMax(float cMax) {
        this.cMax = cMax;
    }
    public float getTempMin() {
        return tempMin;
    }
    public void setTempMin(float tempMin) {
        this.tempMin = tempMin;
    }
    public float getTempMax() {
        return tempMax;
    }
    public void setTempMax(float tempMax) {
        this.tempMax = tempMax;
    }
    public int getTypeMachine_idType() {
        return typeMachine_idType;
    }
    public void setTypeMachine_idType(int typeMachine_idType) {
        this.typeMachine_idType = typeMachine_idType;
    }

}
