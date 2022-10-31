package Repository;

import java.util.ArrayList;
import java.util.List;

import Model.Driver;
import Model.User;

public class PersonRepository {

	private List<User> usersList;
	private List<Driver> driversList;

	public PersonRepository() {
		this.usersList = new ArrayList<>();
		this.driversList = new ArrayList<>();
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}

	public void addUser(User user) {
		this.usersList.add(user);
	}

	public User updateUser(User user) {
		if (usersList.contains(user)) {
			User oldUser = usersList.get(usersList.indexOf(user));
			oldUser.setAge(user.getAge());
			oldUser.setOnRide(user.isOnRide());
			oldUser.setGender(user.getGender());
			oldUser.setName(user.getName());
			return oldUser;
		}
		return null;
	}

	public List<Driver> getDriversList() {
		return driversList;
	}

	public void setDriversList(List<Driver> driversList) {
		this.driversList = driversList;
	}

	public void addDriver(Driver driver) {
		this.driversList.add(driver);
	}

	public Driver updatDriver(Driver driver) {
		if (driversList.contains(driver)) {
			Driver oldDriver = driversList.get(driversList.indexOf(driver));
			oldDriver.setAge(driver.getAge());
			oldDriver.setOnRide(driver.isOnRide());
			oldDriver.setGender(driver.getGender());
			oldDriver.setName(driver.getName());
			return oldDriver;
		}
		return null;
	}

}
