package Management;

public enum RoomService {

	Coffee(15), Meal(40), Juice(20), Dessert(30);
	
	private int numVal;
	
	RoomService(int numVal) {
		this.numVal=numVal;
	}

	public int getnumVal() {
		return numVal;
	}
	
}
