package Repository;

import java.util.HashMap;
import java.util.Map;

public class RideManagementRepository {

	private Map<String, String> rides = new HashMap<>();

	public void createRide(String userName, String driverName) {
		this.rides.put(userName, driverName);
	}

	public Map<String, String> getRides() {
		return this.rides;
	}

}
