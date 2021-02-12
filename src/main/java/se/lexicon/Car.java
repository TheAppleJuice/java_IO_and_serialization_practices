package se.lexicon;


import java.io.Serializable;


public class Car implements Serializable {

    private String registrationNr;
    private String brand;
    private String model;
    private int modelYear;

    public Car() {
    }

    public Car(String registrationNr, String brand, String model, int modelYear) {
        this.registrationNr = registrationNr;
        this.brand = brand;
        this.model = model;
        this.modelYear = modelYear;
    }


    public String getRegistrationNr() {
        return registrationNr;
    }

    public void setRegistrationNr(String registrationNr) {
        this.registrationNr = registrationNr;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "registrationNr='" + registrationNr + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", modelYear=" + modelYear +
                '}';
    }
}
