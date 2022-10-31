package Exception;

import java.util.List;

import Model.User;

public class CustomException extends Exception {

	private static final long serialVersionUID = -362688962640929130L;

	public CustomException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomException(String message) {
		super(message);
	}

	public static boolean checkIfUserExist(List<User> users, String name) {
		boolean userExists = users.stream().filter(user -> user.getName().equals(name)).findFirst().isPresent();
		return userExists;
	}

}
