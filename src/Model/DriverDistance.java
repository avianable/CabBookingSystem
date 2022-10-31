package Model;

// class to map driver distance from source location
public class DriverDistance {
	private String name;
	private double distance;

	public DriverDistance(String name, double distance) {
		super();
		this.name = name;
		this.distance = distance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

}
