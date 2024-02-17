package Package;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static VehicleManager vehicleManager = new VehicleManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Input");
            System.out.println("2. View");
            System.out.print("Choose menu: ");
            int menu = scanner.nextInt();
            scanner.nextLine(); 

            switch (menu) {
                case 1:
                    input();
                    break;
                case 2:
                    view();
                    break;
            }
        }
    }

    private static void input() {
    	System.out.print("Input type [Car/Motorcycle]: ");
    	String type = scanner.nextLine();
    	System.out.print("Input brand [>=5]: ");
        String brand = scanner.nextLine();
        System.out.print("Input name[>=5]: ");
        String name = scanner.nextLine();
        System.out.print("Input license: ");
        String license = scanner.nextLine();
        System.out.print("Input top speed [100 <= topSpeed <= 250]: ");
        int topSpeed = Integer.parseInt(scanner.nextLine());
        System.out.print("Input gas capacity [30 <= gasCap <= 60]: ");
        int gasCapacity = Integer.parseInt(scanner.nextLine());

        if (type.equalsIgnoreCase("Car")) {
        	System.out.print("Input wheel [4 <= wheel <= 6]: ");
            int wheel = Integer.parseInt(scanner.nextLine());
            System.out.print("Input type [SUV | Supercar | Minivan]: ");
            String vehicleType = scanner.nextLine();
            System.out.print("Input entertainment system amount [>= 1]: ");
            int entertainmentSystemAmount = Integer.parseInt(scanner.nextLine());
            vehicleManager.addVehicle(new Car(brand, name, license, topSpeed, gasCapacity, wheel, vehicleType, entertainmentSystemAmount));
        } else if (type.equalsIgnoreCase("Motorcycle")) {
        	System.out.print("Input wheel [2 <= wheel <= 3]: ");
            int wheel = Integer.parseInt(scanner.nextLine());
            System.out.print("Input type [Manual | Automatic]: ");
            String vehicleType = scanner.nextLine();
            System.out.print("Input total helm: ");
            int helm = Integer.parseInt(scanner.nextLine());
            vehicleManager.addVehicle(new Motorcycle(brand, name, license, topSpeed, gasCapacity, wheel, vehicleType, helm));
        }
    }

    private static void view() {
        ArrayList<Vehicle> vehicles = vehicleManager.getVehicles();
        if (vehicles.isEmpty()) {
        	System.out.println("|================================|");
            System.out.println("| No   | Type        | Name      |");
            System.out.println("|================================|");
            return;
        }

        System.out.println("|================================|");
        System.out.println("| No   | Type        | Name      |");
        System.out.println("|================================|");
        for(int i = 0; i < vehicles.size(); i++) {
            Vehicle vehicle = vehicles.get(i);
            System.out.printf("| %-4d | %-11s | %-10s |%n", 
                              (i + 1), 
                              (vehicle instanceof Car ? "Car" : "Motorcycle"), 
                              vehicle.getName());
        }
		
		if(vehicles.size() != 0) {
			System.out.println("|================================|");
		}

        System.out.print("Pick a vehicle number to test drive [Enter '0' to exit]: ");
        int choice = scanner.nextInt();
        if (choice == 0 || choice > vehicles.size()) {
            return;
        }

        Vehicle selectedVehicle = vehicles.get(choice - 1);
        selectedVehicle.specialInfo();

        if (selectedVehicle instanceof Motorcycle) {
            System.out.print("Enter helmet price: ");
            int price = scanner.nextInt();
            System.out.println("Price: " + price);
        }
    }
}

