/**
 *
 */
package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Robin
 *
 */

public class Console {



	//private Model.Member member1;
	//private static Model.Member member = new Model.Member();
	//private static Model.Boat boats = new Boat();
	//private static Scanner userInput = new Scanner(System.in);

	// Used to delete a member in the system, called in console1 class
	public void DeleteMember(Model.Member member, Scanner userInput){
		System.out.println("Enter your member ID please: ");
		//member1 = new Member();

		int userInput2 = userInput.nextInt();

		member.memberInfo.remove(userInput2 - 1);
		member.memberInfo2.remove(userInput2 - 1);
		member.memberInfo3.remove(userInput2 - 1);
	}
	//Uses compact style lising to list the members in the system
	public void compactList(Model.Member member, Scanner userInput){
		System.out.println("The members are: ");

		for (int i = 0; i < member.memberInfo.size(); i++) {

			System.out.println("name: " + member.memberInfo.get(i) + "   Personalnumber:  "
					+ member.memberInfo2.get(i) + "  ID: " + member.memberInfo3.get(i) + "   number of boats:"
					+ member.numOfBoats.get(i));
		}
	}
	// Method to add a member into the system, requires user to enter a name and personal number
	public void addNewMember(Model.Member member, Scanner userInput){
			for (int i = 0; i <= 0; i--) {
				System.out.println("Please enter your name:(Must only be character) ");
				String userInput1 = userInput.next();
				member.setName(userInput1);

				member.memberInfo.add(member.getName());

				System.out.println("Please add a personal number:(Must only be numbers) ");
				int userInputLine2 = userInput.nextInt();
				member.setPersonalNumber(userInputLine2);
				// System.out.println("Please enter your boat number: ");
				// int userInputLine3 = userInput.nextInt();
				// member.setNumBoats(userInputLine3);
				member.memberInfo2.add(member.getPersonalNumber() + "");
				// member.memberInfo.add(member.combine());
				member.setBoats(0);
				member.numOfBoats.add(member.getBoats());
				member.memberInfo3.add(member.UniqueID());

				System.out.println("Wanna add another member? 1 for yes, 0 for no");
				int userInputLine04 = userInput.nextInt();
				if (userInputLine04 == 0) {

					break;
				}
			}
	}
	public void ReadFromTheFile(Model.Member member, Model.Boat boats){


		try {
			File readMemberData = new File("C:\\Users\\Robin\\Desktop\\MemberInfo.txt");
			File readBoatData = new File("C:\\Users\\Robin\\Desktop\\BoatInfo.txt");

			Scanner searchMemberData = new Scanner(readMemberData);
			Scanner searchBoatData = new Scanner(readBoatData);

			while (searchMemberData.hasNextLine()) {
				int commaCounter = 0;
				String temp = "";
				String tempLine = searchMemberData.nextLine();
				for (int i = 0; i < tempLine.length(); i++) {
					if (tempLine.charAt(i) == ',' && commaCounter == 0) {
						String tempName = temp;
						member.memberInfo.add(tempName);
						temp = "";
						commaCounter++;
						i++;
					}
					if (tempLine.charAt(i) == ',' && commaCounter == 1) {
						String tempPID = temp;
						member.memberInfo2.add(tempPID);
						temp = "";
						commaCounter++;
						i++;
					}
					if (tempLine.charAt(i) == ',' && commaCounter == 2) {
						String tempMID = temp;
						member.memberInfo3.add(Integer.parseInt(tempMID));
						temp = "";
						commaCounter++;
						i++;
					}
					if (tempLine.charAt(i) == ';' && commaCounter == 3) {
						String tempNumofBoat = temp;
						member.numOfBoats.add(Integer.parseInt(tempNumofBoat));
						temp = "";
						commaCounter++;
						i++;
					} else {
						temp = temp + tempLine.charAt(i);
					}
				}

			}

			while (searchBoatData.hasNextLine()) {

				int commaCounter = 0;

				String temp2 = "";
				String tempLine1 = searchBoatData.nextLine();
				for (int i = 0; i < tempLine1.length(); i++) {

					if (tempLine1.charAt(i) == ',' && commaCounter == 0) {

						String tempMID1 = temp2;

						boats.memberID.add(Integer.parseInt(tempMID1));
						temp2 = "";
						commaCounter++;
						i++;
					}

					if (tempLine1.charAt(i) == ',' && commaCounter == 1) {

						String tempPID = temp2;
						boats.boatID.add(Integer.parseInt(tempPID));
						temp2 = "";
						commaCounter++;
						i++;

					}

					if (tempLine1.charAt(i) == ',' && commaCounter == 2) {

						String tempAgain = temp2;
						boats.typeOfBoats.add(tempAgain);
						temp2 = "";
						commaCounter++;
						i++;

					}

					else {

						temp2 = temp2 + tempLine1.charAt(i);
					}

				}

			}

		} catch (IOException e) {

			System.out.println("Error");

		}

	}

	public void EditMember(Model.Member member, Scanner userInput){
		System.out.println("Whose information do you wanna change?Enter the memberID");
		int tempMemberID = userInput.nextInt();
		System.out.println("What do you wanna change, 1.name or 2.personal ID?");
		int userInput06 = userInput.nextInt();

		if (userInput06 == 1) {
			member.memberInfo.remove(tempMemberID - 1);
			System.out.println("What do you want instead?");
			String setNames = userInput.next();
			member.setName(setNames);
			for (int i = 0; i < member.memberInfo3.size(); i++) {

				if (i == tempMemberID - 1) {
					member.memberInfo.add(tempMemberID - 1, setNames);
				}
			}

		}

		if (userInput06 == 2) {
			member.memberInfo3.remove(tempMemberID - 1);
			System.out.println("What do you want instead?");
			int newPersonalNumber = userInput.nextInt();

			member.setPersonalNumber(newPersonalNumber);

			for (int i = 0; i < member.memberInfo3.size(); i++) {

				if (i == tempMemberID - 1) {
					member.memberInfo3.add(tempMemberID - 1, newPersonalNumber);
				}

			}

		}

		System.out.println("Now the information are: Name:   " + member.memberInfo.get(tempMemberID - 1)
				+ "   personalID:   " + member.memberInfo2.get(tempMemberID - 1) + " PersonalNumber: "
				+ member.memberInfo3.get(tempMemberID - 1));
	}
	public void ViewSpecificMember(Model.Member member, Scanner userInput){
		System.out.println("Enter your ID: ");
		int specificInfo = userInput.nextInt();
		System.out.println("What do you wanna look at? Name?Press 1, PersonaNumber?Press2, ID?Press3");
		int special = userInput.nextInt();
		if(special == 1){

			for(int i = 0; i < member.memberInfo.size(); i++){

				if(member.memberInfo3.get(i) == specificInfo){

					System.out.println("The name is: " +member.memberInfo.get(i));

				}

			}

		}
		if(special == 2){

			for(int i = 0; i < member.memberInfo2.size(); i++){

				if(member.memberInfo2.get(i) == Integer.toString(specificInfo)){

					System.out.println("The Personalnumber is: " +member.memberInfo2.get(i));

				}

			}

		}
		if(special == 3){

			for(int i = 0; i < member.memberInfo3.size(); i++){

				if(member.memberInfo3.get(i) == specificInfo){

					System.out.println("The memberID is: " +member.memberInfo3.get(i));

				}

			}
		}

	}
					// Register a boat for a user. Is called upon in console1 class
	public void registerBoat(Model.Member member, Model.Boat boats, Scanner userInput){
		System.out.println("Whats your memberID?");
		int tempMemberID = userInput.nextInt();
		boats.memberID.add(tempMemberID);
		boats.boatIDcounter++;
		boats.boatID.add(boats.boatIDcounter);
		System.out.println(
				"What kinda boat are we talking about here? 1. Sailboat 2. MotorSailer 3. Kayak/Canoe 4. Other. Enter the corresponding number:");
		int boatTypeTemp = userInput.nextInt();
		if (boatTypeTemp == 1) {

			boats.setBoatType("Sailboat");
			boats.typeOfBoats.add(boats.getBoatType());
		}
		if (boatTypeTemp == 2) {
			boats.setBoatType("Motorsailer");
			boats.typeOfBoats.add(boats.getBoatType());

		}
		if (boatTypeTemp == 3) {
			boats.setBoatType("Kayak/Canoe");
			boats.typeOfBoats.add(boats.getBoatType());

		}
		if (boatTypeTemp == 4) {

			boats.setBoatType("Other");
			boats.typeOfBoats.add(boats.getBoatType());
		}

		System.out.println("Whats the length of your boat? Enter in Meters");
		int boatLength = userInput.nextInt();
		boats.setboatLength(boatLength);
		boats.boatLength.add(boatLength);

		member.setBoats(tempMemberID);
		member.addNewBoat(tempMemberID);

	}
	public void deleteBoat(Model.Member member, Model.Boat boats, Scanner userInput){
		System.out.println("Whats your memberID?");
		int memberIDForDelete = userInput.nextInt();
		System.out.println("Here are your boats:");
		System.out.println("BoatID        Type       Length");
		for (int i = 0; i < boats.typeOfBoats.size(); i++) {
			if (memberIDForDelete == boats.memberID.get(i)) {
				System.out.println(boats.boatID.get(i) + "       " + boats.typeOfBoats.get(i) + "       "
						);
			}
		}
		System.out.println("Which boat you want to delete?Enter the BoatID!");
		int boatIDForDelete = userInput.nextInt();
		for (int i = 0; i < boats.typeOfBoats.size(); i++) {
			if (boatIDForDelete == boats.boatID.get(i)) {
				boats.memberID.set(i, 0);
				//boats.boatLength.set(i, 0);
				boats.typeOfBoats.set(i, "");
				member.numOfBoats.set(i, 0);
			}
		}
		/*for (int i = 0; i < member.memberInfo3.size(); i++) {
			if (memberIDForDelete == member.memberInfo3.get(i)) {
				member.memberInfo3.set(i, member.memberInfo3.get(i) - 1);
			}
		}*/
	}
	public void editBoat(Model.Boat boats, Scanner userInput){
		System.out.println("Enter your memberID");
		int memberIDforChange = userInput.nextInt();
		System.out.println("Here are your boats:");
		System.out.println("BoatID        Type       Length");
		for (int i = 0; i < boats.typeOfBoats.size(); i++) {
			if (memberIDforChange == boats.memberID.get(i)) {
				System.out.println(boats.boatID.get(i) + "       " + boats.typeOfBoats.get(i) + "       "
						+ boats.boatLength.get(i));
			}
		}

		System.out.println("Which boat do you wanna edit?Enter the boat ID");
		int BoatIDForChange = userInput.nextInt();
		System.out.println(
				"Which column you want to change for the boat/press 1 for changing type/press 2 for changing length ");
		int columnForChange = userInput.nextInt();
		if (columnForChange == 1) {
			System.out.println(
					"Which type do you wanna replace? 1. Sailboat 2. MotorSailer 3. Kayak/Canoe 4. Other");
			int boatTypeEdit = userInput.nextInt();
			if (boatTypeEdit == 1) {
				boats.typeOfBoats.set(BoatIDForChange - 1, "Sailboat");
			}
			if (boatTypeEdit == 2) {
				boats.typeOfBoats.set(BoatIDForChange - 1, "MotorSailer");
			}
			if (boatTypeEdit == 3) {
				boats.typeOfBoats.set(BoatIDForChange - 1, "Kayak/Canoe");
			}
			if (boatTypeEdit == 4) {
				boats.typeOfBoats.set(BoatIDForChange - 1, "Other");
			}
		}
		if (columnForChange == 2) {
			System.out.println("What s the length you want to replace?");
			int boatlengthEdit = userInput.nextInt();
			boats.boatLength.set(BoatIDForChange - 1, boatlengthEdit);
		}
	}
	public void saveToText(Model.Member member, Model.Boat boats) throws IOException{ //Saves boat data in one file and member data in another
		PrintWriter writeMemberData1 = new PrintWriter(
				"C:\\Users\\Robin\\Desktop\\MemberInfo.txt");

		try {

			for (int i = 0; i < member.memberInfo.size(); i++) {

				String temp = member.memberInfo.get(i) + ',' + member.memberInfo2.get(i) + ','
						+ member.memberInfo3.get(i) + ',' + member.numOfBoats.get(i) + ';';
				writeMemberData1.println(temp);
			}

		} catch (NoSuchElementException e) {

			System.out.println("Sorry, that file is not an option");

		} finally {

			writeMemberData1.close();
		}


	}


	public void writeToBoatRegister(Model.Member member, Model.Boat boats) throws FileNotFoundException{

		PrintWriter writeBoatData = new PrintWriter(
				"C:\\Users\\Robin\\Desktop\\BoatInfo.txt");

		try {

			for (int i = 0; i < member.memberInfo.size(); i++) {

				String temp1 = "";
				int tempNumberOfBoats = member.numOfBoats.get(i);

				int tempMemberID = member.memberInfo3.get(i);

				if (tempNumberOfBoats < 1) {

					writeBoatData.println(temp1);

				}

				if (tempNumberOfBoats >= 1) {

					for (int x = 0; x < boats.memberID.size(); x++) {

						if (tempMemberID == boats.memberID.get(x) && boats.boatLength.get(x) > 0) {

							temp1 = temp1 + boats.memberID.get(x) + ',' + boats.boatID.get(x) + ','
									+ boats.typeOfBoats.get(x) + ',' + boats.boatLength.get(x) + ';';
							writeBoatData.println(temp1);

						}

					}


				}

			}

		} catch (NoSuchElementException e) {

			System.out.println("Sorry, that file is not an option");

		} finally {

			writeBoatData.close();
		}






	}

	public void verboseList(Model.Member member, Model.Boat boats){
		System.out.println("The Verbose List: ");
		for (int i = 0; i < member.memberInfo3.size(); i++) {

			System.out.println("\n" + "name: " + member.memberInfo.get(i) + "   Personalnumber:  "
					+ member.memberInfo2.get(i) + "  UniqueMemberID: " + member.memberInfo3.get(i));
			if (member.numOfBoats.get(i) < 1) {
				System.out.print("  Number of boats: 0" + "\n");
			}
			int tempNumberOfBoats = member.numOfBoats.get(i);
			int tempMemberID = member.memberInfo3.get(i);
			int BoatCounter = 0;
			if (tempNumberOfBoats >= 1) {
				for (int x = 0; x < boats.memberID.size(); x++) {
					// if(tempMemberID == boats.memberID.get(x) &&
					// boats.boatLength.get(x) > 0){
					BoatCounter++;
					System.out.println("Boat" + BoatCounter + ": " + "BoatID: " + boats.boatID.get(x) + "     "
							+ "Type: " + boats.typeOfBoats.get(x) + "     " + "");
					// } Length: "+boats.boatLength.get(x)+"\n
				}
			}
		}
	}


	}

