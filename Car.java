package Package;

public class Car extends Vehicle {
	
	private String vehicleType;
	private int entertainmentSystem;
	

	public Car(String brand, String name, String licenseNumber, int topSpeed, int gasCap, int wheel, String vehicleType,
			int entertainmentSystem) {
		super(brand, name, licenseNumber, topSpeed, gasCap, wheel);
		this.vehicleType = vehicleType;
		this.entertainmentSystem = entertainmentSystem;
	}

	@Override
	void specialInfo() {
		
		System.out.println("Turning on entertainment system...");
        if (vehicleType.equals("Supercar")) {
            System.out.println("Boosting!");
        }
		
	}
	
	@Override
	public String getName() {
	    return this.name; // Assuming 'name' is a field in the Car class
	}

}
