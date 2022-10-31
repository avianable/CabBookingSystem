package Model;

public class Ride {
	VehicleType vehicleType;
	User user;
	Driver driver;
	Location location;

	public Ride(VehicleType vehicleType, User user, Driver driver, Location location) {
		super();
		this.vehicleType = vehicleType;
		this.user = user;
		this.driver = driver;
		this.location = location;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
