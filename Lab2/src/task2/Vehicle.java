package task2;

import java.util.Objects;

public class Vehicle {
    private String country;
    private String model;
    private int year;
    
    public Vehicle(String country, String model, int year) {
        this.country = country;
        this.model = model;
        this.year = year;
    }
    
    public String getMake() {
        return country;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getYear() {
        return year;
    }
    
    public String toString() {
    	return "Country: " + country + ", Model: " + model + ", Year: " + year;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Vehicle vehicle = (Vehicle) obj;
        return year == vehicle.year && country.equals(vehicle.country) && model.equals(vehicle.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, model, year);
    }
}
