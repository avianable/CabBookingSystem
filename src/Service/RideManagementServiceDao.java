package Service;

import java.util.List;
import java.util.Map;

import Exception.CustomException;
import Model.Location;

public interface RideManagementServiceDao {

	public List<String> findRides(PersonServiceDao personService, String userName, Location sourceLocation,
			Location destinationLocation) throws CustomException;

	public void chooseRide(PersonServiceDao personService, String userName, String driverName) throws CustomException;

	public Map<String, String> getRides();
}
