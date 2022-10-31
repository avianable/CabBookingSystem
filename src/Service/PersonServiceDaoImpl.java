package Service;

import java.util.List;

import Exception.CustomException;
import Model.Driver;
import Model.User;
import Repository.PersonRepository;

public class PersonServiceDaoImpl implements PersonServiceDao {

	private PersonRepository personRepository;

	public PersonServiceDaoImpl() {
		this.personRepository = new PersonRepository();
	}

	@Override
	public void addUser(User user) {
		this.personRepository.addUser(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return this.personRepository.updateUser(user);
	}

	@Override
	public String deleteUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserbyName(String name) throws CustomException {
		List<User> usersList = this.personRepository.getUsersList();
		boolean isUserPresentException = CustomException.checkIfUserExist(usersList, name);
		if (!isUserPresentException) {
			throw new CustomException(name + " does not exist!");
		}
		for (User user : usersList) {
			if (user.getName() == name) {
				return user;
			}
		}
		return null;
	}

	@Override
	public void addDriver(Driver driver) {
		this.personRepository.addDriver(driver);

	}

	@Override
	public Driver updateDriver(Driver driver) {
		return this.personRepository.updatDriver(driver);
	}

	@Override
	public String deleteDriver(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Driver getDriverbyName(String name) {
		List<Driver> driversList = this.personRepository.getDriversList();
		for (Driver driver : driversList) {
			if (driver.getName() == name) {
				return driver;
			}
		}
		return null;
	}

	@Override
	public List<User> getUsers() {
		return this.personRepository.getUsersList();
	}

	@Override
	public List<Driver> getDrivers() {
		return this.personRepository.getDriversList();
	}

}
