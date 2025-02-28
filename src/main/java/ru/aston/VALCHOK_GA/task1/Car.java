package ru.aston.VALCHOK_GA.task1;

public class Car {
    private String manufacturer;
    private String model;
    private String engine;
    private float engineCapacity;
    private int enginePower;

    public Car(String manufacturer, String model, String engine, float engineCapacity, int enginePower) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.engine = engine;
        this.engineCapacity = engineCapacity;
        this.enginePower = enginePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public float getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(float engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    @Override
    public String toString(){
        return manufacturer+" "+model+" "+engine+" "+engineCapacity+" "+enginePower;
    }

}
