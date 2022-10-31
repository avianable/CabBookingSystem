package Model;

public class Location {

	int xCordinate;
	int yCordinate;

	public Location(int xCordinate, int yCordinate) {
		super();
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;
	}

	public int getxCordinate() {
		return xCordinate;
	}

	public void setxCordinate(int xCordinate) {
		this.xCordinate = xCordinate;
	}

	public int getyCordinate() {
		return yCordinate;
	}

	public void setyCordinate(int yCordinate) {
		this.yCordinate = yCordinate;
	}

	@Override
	public String toString() {
		return "Location [xCordinate=" + xCordinate + ", yCordinate=" + yCordinate + "]";
	}

}
