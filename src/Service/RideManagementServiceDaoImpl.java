package Service;

import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Exception.CustomException;
import Model.Constants;
import Model.Driver;
import Model.DriverDistance;
import Model.Location;
import Model.User;
import Repository.RideManagementRepository;

public class RideManagementServiceDaoImpl implements RideManagementServiceDao {

	private RideManagementRepository rideManagementRepository;

	public RideManagementServiceDaoImpl() {
		this.rideManagementRepository = new RideManagementRepository();
	}

	// find rides
	@Override
	public List<String> findRides(PersonServiceDao personService, String userName, Location source,
			Location destination) throws CustomException {
		User user = personService.getUserbyName(userName);
		List<DriverDistance> availableDrivers = new ArrayList<>();

		// if user is not already riding
		if (null != user && !user.isOnRide()) {
			List<Driver> driversList = personService.getDrivers();
			for (Driver driver : driversList) {
				// Case - if two users looked for same driver but first user booked it before
				// second user
				if (!driver.isOnRide()) {
					Location driverLocation = driver.getDriverLocation();
					double distance = driverDistance(driverLocation, source);
					if (distance <= Constants.DISTANCE_UNIT) {
						availableDrivers.add(new DriverDistance(driver.getName(), distance));
					}
				}
			}
		}
		availableDrivers.sort((o1, o2) -> Double.compare(o1.getDistance(), o2.getDistance()));
		List<String> drivers = availableDrivers.stream().map((DriverDistance d) -> d.getName())
				.collect(Collectors.toList());
		return drivers;
	}

	@Override
	public void chooseRide(PersonServiceDao personService, String userName, String driverName) throws CustomException {
		User user = personService.getUserbyName(userName);
		Driver driver = personService.getDriverbyName(driverName);

		// check if driver is already on a ride
		if (null != user && null != driver && !driver.isOnRide()) {
			this.rideManagementRepository.createRide(userName, driverName);
			user.setOnRide(true);
			driver.setOnRide(true);
			personService.updateUser(user);
			personService.updateDriver(driver);
		}

	}

	@Override
	public Map<String, String> getRides() {
		return this.rideManagementRepository.getRides();
	}

	// distance units of source location
	public double driverDistance(Location driverLocation, Location source) {
		int x1 = driverLocation.getxCordinate();
		int y1 = driverLocation.getyCordinate();
		int x2 = source.getxCordinate();
		int y2 = source.getyCordinate();

		double distance = Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2) * 1.0);
		return distance;
	}

}
