package Model;

public class Vehicle {
	private VehicleType vehicleType;
	private String vehicleNumber;
	private String model;

	public Vehicle(VehicleType vehicleType, String vehicleNumber, String model) {
		super();
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
		this.model = model;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleType=" + vehicleType + ", vehicleNumber=" + vehicleNumber + ", model=" + model + "]";
	}

}
