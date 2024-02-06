package task2;

import java.util.Objects;

public class Car extends Vehicle {
    private double engineVolume;
    private int horsePower;
    
    public Car(String make, String model, int year, double engineVolume, int horsePower) {
        super(make, model, year);
        this.engineVolume = engineVolume;
        this.horsePower = horsePower;
    }
    
    public double getEngineVolume() {
        return engineVolume;
    }

    public int getHorsePower() {
        return horsePower;
    }
    
    public String toString() {
    	return super.toString() + " Engine Volume: " + engineVolume + ", Horse Power: " + horsePower;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Car car = (Car) obj;
        return engineVolume == car.engineVolume && horsePower == car.horsePower;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), engineVolume, horsePower);
    }
}
