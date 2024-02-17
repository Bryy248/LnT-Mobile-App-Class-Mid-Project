package Package;

public class Motorcycle extends Vehicle {

	private String type;
    private int helmet;


	public Motorcycle(String brand, String name, String licenseNumber, int topSpeed, int gasCap, int wheel, String type,
			int helmet) {
		super(brand, name, licenseNumber, topSpeed, gasCap, wheel);
		this.type = type;
		this.helmet = helmet;
	}

	@Override
	void specialInfo() {
		
		System.out.println(name + " is standing!");
		
	}

	@Override
	protected Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

    
}
