package Model;

import java.util.Objects;

public class Person {
	private String name;
	private String gender;
	private int age;
	private boolean isOnRide = false;

	public Person(String name, String gender, int age, boolean isOnRide) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.isOnRide = isOnRide;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isOnRide() {
		return isOnRide;
	}

	public void setOnRide(boolean isOnRide) {
		this.isOnRide = isOnRide;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, gender, isOnRide, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(gender, other.gender) && isOnRide == other.isOnRide
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", age=" + age + ", isOnRide=" + isOnRide + "]";
	}

}
