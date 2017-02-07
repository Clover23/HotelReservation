
public class Room {

//class variables
private int roomNumber; // the number of a room
private int daysRented; // number of days remaining in this room rental
private String roomType; // room description, can be "single king", "double queen" or "suite"
private String occupantName; // name of a person renting room

public Room(int roomNumber, String roomType){
	this.roomNumber = roomNumber;
	if(roomType.equalsIgnoreCase("single king")){this.roomType=roomType;}
	else if(roomType.equalsIgnoreCase("suite")){this.roomType = roomType;}
	else{this.roomType = "double queen";}
	daysRented = 0;
	occupantName = null;
}

/*four following methods are getters for the Room class **/

public int getRoomNumber(){
	return roomNumber;
}

public String getRoomType(){
	return roomType;
}

public int getDaysRented(){
	return daysRented;
}

public String getOccupantName(){
	return occupantName;
}

/*param:
 * guestName - name of the guest
 * daysToStay - number of days he will be staying in hotel
  return:
 * true if the room is available and renting operation is successful 
 * and false in other cases**/

public boolean setOccupant(String guestName, int daysToStay){
	if (getDaysRented()==0){
		occupantName = guestName;
		daysRented = daysToStay;
		return true;
	}
	return false;
}

/*reduces daysRented by one, and if it is the last day sets daysRented to zero
 * and occupantName to null **/

public void advanceDay(){
	if (getDaysRented()>0){
		daysRented = daysRented -1;
	}
	else{
		daysRented = 0;
		occupantName = null;
	}
}

/*String representation of a room **/
public String toString(){
	String condition;
	if (getDaysRented()==0 && getOccupantName()==null){
		condition = "free";
	}
	else {condition = "rented";}
	return ("Room "+ getRoomNumber()+ ": "+ getRoomType()+ " - "+ condition);
}
}
