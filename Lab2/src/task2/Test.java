package task2;

import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        HashSet<Vehicle> vehicles = new HashSet<>();
        
        Vehicle vehicle1 = new Vehicle("Japan", "Toyota Corolla", 2010);
        Car car1 = new Car("Japan", "Honda Civic", 2015, 1.6, 180);
        Car car2 = new Car("USA", "Ford Mustang", 2023, 5.0, 310);
        Car duplicate = new Car("USA", "Ford Mustang", 2023, 5.0, 310);


        // Add objects to HashSet
        vehicles.add(vehicle1);
        vehicles.add(car1);
        vehicles.add(car2);
        vehicles.add(duplicate);

        System.out.println("Size of HashSet: " + vehicles.size()); // 3
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}
