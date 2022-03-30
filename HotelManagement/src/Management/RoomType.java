package Management;

public enum RoomType {
	tourism(75), business(180), worldclass(500);
	
	int numVal;
	
	RoomType(int numVal) {
		this.numVal=numVal;
	}

	public int getnumVal() {
		return numVal;
	}
}
