/**
 *
 */
package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Robin
 *
 */
public class Member {

	 private String name;
	 private int personalNumber;
	 private int member_id;
	 private int numOfBoat;


	 int counter = 0;
	 int counter2 = 0;
	 Random rand = new Random();
	 HashSet<Integer> memberID = new HashSet<Integer>();
	 UUID randomID = UUID.randomUUID();

	 Boat boat = new Boat();
	 public ArrayList<String>memberInfo = new ArrayList<String>(); // Member name
	 public ArrayList<String>memberInfo2 = new ArrayList<String>(); // Personal Number
	 public ArrayList<Integer>memberInfo3 = new ArrayList<Integer>(); // Member ID
	 public ArrayList<Integer>numOfBoats = new ArrayList<Integer>(); // number of boats






	// setters and getters for member info
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPersonalNumber() {
		return personalNumber;
	}
	public void setPersonalNumber(int personalNumber) {
		this.personalNumber = personalNumber;
	}
	public int getMember_id() {

		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}


	public ArrayList<String> getMemberInfo() {
		return memberInfo;
	}
	public void setMemberInfo(ArrayList<String> memberInfo) {
		this.memberInfo = memberInfo;
	}
	public String combine(){

		return ++counter+"."+ "Name:"+ name +" personalnumber: "+personalNumber+" unique ID:"+counter;


	}



	public void setID(UUID id){

		randomID = id;


	}

	public UUID getID(){

		return randomID;

	}

	public void setIDD(String d){

		d = counter+"";

	}

	public void randomID(){

		int q;
		int w;
		int amountOfNumbersGenerated = 10;

		for(int i = 0; i < amountOfNumbersGenerated; i++){

			q = rand.nextInt(20);
			memberID.add(q);
			if (memberID.size() <= 10) {
                if (memberID.size() == 10) {
                    q = 10;
                }
                q++;
                memberID.add(q);
            }


		}

	}






	// sets the UniqueID
	public int UniqueID(){

		return memberInfo3.size()+1;

	}
	// sets the amount of bots for each user
	public void setBoats(int numberOfBoats ){

		numOfBoat = numberOfBoats;

	}
	// gets the boats
	public int getBoats(){

		return numOfBoat;
	}
	// Add a new boat to a user, by taking the setters and getters from set/getboats methods
	public void addNewBoat(int ID){

		numOfBoats.set(ID-1, numOfBoats.get(ID-1)+1);

	}





}
