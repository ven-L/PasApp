import java.util.ArrayList;

public class Vehicle {
    
    //instance variables
    private String make;
    private String model;
    private String year;
    private String type;
    private String fueltype;
    private double price;
    private String color;
    private double premium;

    //constructor
    public Vehicle(String make, String model, String year, String type, String fueltype, double price, String color) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.type = type;
        this.fueltype = fueltype;
        this.price = price;
        this.color = color;
    }

    public  Vehicle getVehicle() {
        return this;
    }
    
    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFueltype() {
        return this.fueltype;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPremium() {
        return this.premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public void display(ArrayList<Vehicle> vehicleList) {
   
    }
}
