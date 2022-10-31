package Service;

import java.util.List;

import Exception.CustomException;
import Model.Driver;
import Model.User;

public interface PersonServiceDao {
	public void addUser(User user);

	public User updateUser(User user);

	public String deleteUser(String userName);

	public User getUserbyName(String name) throws CustomException;

	public List<User> getUsers();

	public void addDriver(Driver driver);

	public Driver updateDriver(Driver driver);

	public String deleteDriver(String userName);

	public Driver getDriverbyName(String name);

	public List<Driver> getDrivers();
}
