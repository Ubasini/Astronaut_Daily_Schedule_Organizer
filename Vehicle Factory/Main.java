
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of vehicle (CAR/BIKE/TRUCK): ");
        String vehicleType = scanner.nextLine().toUpperCase();

        Vehicle vehicle = vehicleFactory.getVehicle(vehicleType);

        if (vehicle != null) {
            vehicle.create();
        } else {
            System.out.println("Invalid vehicle type entered.");
        }

        scanner.close();
    }
}
