/**
 *
 */
package Model;

import java.util.ArrayList;

/**
 * @author Robin
 *
 */
public class Boat {


	int length;
	String boatType;
	int berthNumber;
	public int boatIDcounter=0;
	// Arraylists used to store the boat length, type, a special memberID and a special boatID
	public ArrayList<Integer>boatLength = new ArrayList<Integer>();
	public ArrayList<String>typeOfBoats = new ArrayList<String>();
	public ArrayList<Integer>memberID = new ArrayList<Integer>();
	public ArrayList<Integer>boatID = new ArrayList<Integer>();



	// setters and getters to set and get boat info
	public int getBoatIDcounter() {
		return boatIDcounter;
	}
	public void setBoatIDcounter(int boatIDcounter) {
		this.boatIDcounter = boatIDcounter;
	}
	public ArrayList<Integer> getBoatLength() {
		return boatLength;
	}
	public void setBoatLength(ArrayList<Integer> boatLength) {
		this.boatLength = boatLength;
	}
	public ArrayList<String> getTypeOfBoats() {
		return typeOfBoats;
	}
	public void setTypeOfBoats(ArrayList<String> typeOfBoats) {
		this.typeOfBoats = typeOfBoats;
	}
	public ArrayList<Integer> getMemberID() {
		return memberID;
	}
	public void setMemberID(ArrayList<Integer> memberID) {
		this.memberID = memberID;
	}
	public ArrayList<Integer> getBoatID() {
		return boatID;
	}
	public void setBoatID(ArrayList<Integer> boatID) {
		this.boatID = boatID;
	}
	public String getBoatType(){

		return boatType;

	}
	public void setBoatType(String boatType){

		this.boatType = boatType;

	}

	public int getboatLength(){

		return length;

	}
	public void setboatLength(int boatLength){

		length = boatLength;

	}

	public int getBerthNumber(){

		return berthNumber;

	}
	public void setBerthNumber(int berthnum){

		berthNumber = berthnum;

	}





}

