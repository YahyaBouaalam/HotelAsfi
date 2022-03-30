package Management;

import java.util.ArrayList;
import java.util.Iterator;

public class ResidentCollection {
	
	public static ArrayList<Resident> residents = new ArrayList<>();
	
	public static void checkin(String fname, String lname, String number, RoomType type, String username, String password) throws FieldTakenException, FieldIsNullException{
		
		if(findResident(username)!=null)
			throw new FieldTakenException();
		else {
			if(number.trim().isEmpty()||password.trim().isEmpty()||username.trim().isEmpty()||fname==null||lname==null||number==" "||password==" "||username==" "||fname==" "||lname==" ")
				throw new FieldIsNullException();
			else {
				Room room = new Room(number, type);
				Person cred= new Person(password, username);
				Resident toAdd= new Resident(cred, room, fname, lname, 0);
				residents.add(toAdd);
			}
		}
	
		}
	
	public static String checkout(String username) {
		
		Iterator<Resident> i = residents.listIterator();
		Resident temp;
		
		while (i.hasNext()) {
			
			temp = i.next();
			if (username.equals(temp.getCredentials().getUsername())) {
				int total=temp.getBill()+temp.getRoom().getType().getnumVal();
				System.out.println("Check-out successful, "+temp.getFname()+"'s total is: $.");
				i.remove();
				
				return "Check-out successful, "+temp.getFname()+"'s total is: $"+total+".";
			}
		}
		return null;
	}
	
	public static Resident findResident(String ID) {
		Resident toReturn;
		Iterator<Resident> i=  residents.listIterator();
		
		while(i.hasNext()) {
			
			toReturn = i.next();
			
			if(ID.equals(toReturn.getCredentials().getUsername())) {
				return toReturn;
			}

		}
		return null;
	}
	
	public static Resident residentLogin(String username, String password) throws CredentialsException{
		Iterator<Resident> i = residents.listIterator();
		Resident x;
		
		while(i.hasNext()) {
			x= i.next();
			if(username.equals(x.getCredentials().getUsername())) {
				
				if(password.equals(x.getCredentials().getPassword())) {
					return x;
				}
			}
		}
			
		throw new CredentialsException();
	}
	
	public Resident logout(Resident x) {
		System.out.println("See you later, " + x.getFname()+" "+x.getLname() + ".");
		return null;
	}
}
