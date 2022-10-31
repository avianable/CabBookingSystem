package Driver;

import java.util.List;
import java.util.Map;

import Exception.CustomException;
import Model.Driver;
import Model.Location;
import Model.User;
import Model.Vehicle;
import Model.VehicleType;
import Service.PersonServiceDao;
import Service.PersonServiceDaoImpl;
import Service.RideManagementServiceDao;
import Service.RideManagementServiceDaoImpl;

public class DriverDemo {

	public static void main(String[] args) throws CustomException, IndexOutOfBoundsException {

		try {
			PersonServiceDao personService = new PersonServiceDaoImpl();

			// User
			addUsers(personService);
			List<User> usersList = personService.getUsers();
			printAllUsers(usersList);

			// Driver
			addDrivers(personService);
			List<Driver> driversList = personService.getDrivers();
			printAllDrivers(driversList);

			// Locations
			Location source = new Location(0, 0);
			Location destination = new Location(20, 1);

			Location source2 = new Location(10, 0);
			Location destination2 = new Location(15, 3);

			Location source3 = new Location(15, 1);
			Location destination3 = new Location(20, 5);

			// Rides
			RideManagementServiceDao rideService = new RideManagementServiceDaoImpl();
			Map<String, String> allRides = rideService.getRides();

			List<String> availableDrivers = rideService.findRides(personService, "Abhishek", source, destination);
			printAvailableDriversForUser(availableDrivers, "Abhishek");
			if (availableDrivers.size() > 0) {
				rideService.chooseRide(personService, "Abhishek", availableDrivers.get(0));
			}

			List<String> availableDrivers2 = rideService.findRides(personService, "Rahul", source2, destination2);
			printAvailableDriversForUser(availableDrivers2, "Rahul");
			if (availableDrivers2.size() > 0) {
				rideService.chooseRide(personService, "Rahul", availableDrivers2.get(0));
			}

			List<String> availableDrivers3 = rideService.findRides(personService, "Nandini", source3, destination3);
			printAvailableDriversForUser(availableDrivers3, "Nandini");
			if (availableDrivers3.size() > 0) {
				rideService.chooseRide(personService, "Nandini", availableDrivers3.get(0));
			}

			printAllRides(allRides);

		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Please check inputs");
		}

	}

	// Helper functions

	public static void addUsers(PersonServiceDao personService) {
		User user1 = new User("Abhishek", "M", 23, false);
		User user2 = new User("Rahul", "M", 29, false);
		User user3 = new User("Nandini", "F", 22, false);
		personService.addUser(user1);
		personService.addUser(user2);
		personService.addUser(user3);
	}

	public static void addDrivers(PersonServiceDao personService) {
		Vehicle v1 = new Vehicle(VehicleType.CAR, "KA-01-12345", "Swift");
		Location l1 = new Location(10, 1);
		Location l2 = new Location(11, 10);
		Location l3 = new Location(5, 3);

		Driver driver1 = new Driver("Driver1", "M", 22, false, v1, l1);
		Driver driver2 = new Driver("Driver2", "M", 29, false, v1, l2);
		Driver driver3 = new Driver("Driver3", "M", 24, false, v1, l3);
		personService.addDriver(driver1);
		personService.addDriver(driver2);
		personService.addDriver(driver3);
	}

	public static void printAllUsers(List<User> usersList) {
		for (User user : usersList) {
			System.out.println(user);
		}
		System.out.println();
	}

	public static void printAllDrivers(List<Driver> driversList) {
		for (Driver driver : driversList) {
			System.out.println(driver);
		}
		System.out.println();
	}

	public static void printAvailableDriversForUser(List<String> availableDrivers, String userName) {
		if (availableDrivers.size() == 0) {
			System.out.println("No ride found for " + userName);
		} else {
			System.out.println("Ride for " + userName);
			for (String driver : availableDrivers) {
				System.out.print(driver + " ");
			}
		}
		System.out.println();
		System.out.println();
	}

	public static void printAllRides(Map<String, String> rides) {
		if (rides.size() == 0) {
			System.out.println("No rides");
		}
		rides.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + " --> " + entry.getValue());
		});

		System.out.println();
		System.out.println();
	}

}
