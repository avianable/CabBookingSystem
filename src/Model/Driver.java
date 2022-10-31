package Model;

import java.util.Objects;

public class Driver extends Person {

	private Vehicle vehicle;
	private Location driverLocation;

	public Driver(String name, String gender, int age, boolean isOnRide, Vehicle vehicle, Location driverLocation) {
		super(name, gender, age, isOnRide);
		this.vehicle = vehicle;
		this.driverLocation = driverLocation;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Location getDriverLocation() {
		return driverLocation;
	}

	public void setDriverLocation(Location driverLocation) {
		this.driverLocation = driverLocation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(driverLocation, vehicle);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		return Objects.equals(driverLocation, other.driverLocation) && Objects.equals(vehicle, other.vehicle);
	}

}
