public class Hotel {
// declare variables
public String hotelName;
public Room[] rooms;
public int totalRooms;

/*Constructor to a Hotel class
 * The	room	number	is	value	between	100	and	999. 
 * The	first	digit	will	correspond	to	what floor	the	room	is	on,	
 * and	the	second	two	digits	should	count	progressively	higher.
 * Each	floor	will	have	the	same	number	of	rooms
 * Every	floor	will	have	n	“double	queen”	rooms,	4	“single	king”	rooms,	and	1	“suite”. There	are	
guaranteed	to	be at	least	5	rooms	on	each	floor	of	the	hotel.
The	“suite”	will	have	the	highest	number	on	the	floor.	The	“single	king”	rooms	will	have	the	next	
two	highest	numbers	on	the	floor.
 **/
public Hotel(String hotelName, int totalRooms, int numberOfFloors){
	this.totalRooms = totalRooms;
	this.hotelName = hotelName;
	this.rooms = new Room[totalRooms];
	int roomsOnFloor = totalRooms/numberOfFloors;
	int floor = 1; int num = 1; int count=0;
	String roomType;
	while (count < rooms.length){
		while (num<= roomsOnFloor){
			int roomNum = floor*100 + num;
			if (roomNum > 999){break;}
				if (roomsOnFloor-num==0){roomType = "suite";}
				else if ((roomsOnFloor-num)<5 && (roomsOnFloor-num)>=1){roomType = "single king";}
				else {roomType = "double queen";}
			rooms[count]=new Room(roomNum, roomType);
			num++;
			count++;	
		}
		floor++;
		num = 1;
	}
}

/*	count how many rooms are currently occupied 
 * returns the number of occupied rooms**/

public int getNumberOccupied(){
	int i = 0;
	int count= 0;
	while (i< rooms.length){
		if (rooms[i].getDaysRented()>0){count++;}
		i++;
	}
	return count;
}

/*	return	a	double	value	between	0	and	1 representing	
 * the	percentage	of	rooms	that	are	currently	rented**/

public double getOccupancyRate(){
	double numerator = getNumberOccupied()*1.0;
	double denomitator = totalRooms*1.0;
	return Math.round((numerator/denomitator)*100.0)/100.0;
}

public int getTotalRooms(){
	return totalRooms;
}

/* param:
 * type of the room
 * name of the renter
 * number of days renter will stay at hotel
 return:
 * true if there is unoccupied room that match renter's specified room type
 * false otherwise
 * Set the	occupant information for the first room found **/

public boolean rentRoom(String roomType, String renterName, int numDays){
	boolean r = false;
	int i = 0;
	while (i < rooms.length)
		if (rooms[i].getRoomType().equalsIgnoreCase(roomType) & rooms[i].getDaysRented()==0){
			rooms[i].setOccupant(renterName, numDays);
			r = true;
			break;	
			
		}
		else{i++;}
	return r;
}

/*	check	every	rented	room	and	reduce	the	number	of	days
 * 	left in	the	rental**/

public void advanceDay(){
	int i = 0;
	if (getNumberOccupied() > 0){
		while (i<rooms.length){
			if (rooms[i].getDaysRented()>0){rooms[i].advanceDay(); i++;}
			else{i++;}
		}
}
}
/*String representation of a hotel**/

public String toString(){
	return (hotelName + ": "+  Math.round(getOccupancyRate()*100) + "%" + " occupied");
}
}
