package View;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Model.Boat;
import Model.Console;
import Model.Member;

public class console1 {

	private Console a;
	private static Scanner userInput;
	private Member member;
	private Boat boats;
	public void readFromText(Model.Member member){
		//member = new Member();
		a = new Console();
		//a.ReadFromTheFile(member);
	}
	public void start() throws IOException{
		member = new Member();
		boats = new Boat();
		userInput = new Scanner(System.in);
		a = new Console();
		a.ReadFromTheFile(member, boats);

		for (int j = 0; j >= 0; j++) {
			System.out.println("Welcome, choose from the options: ");
			System.out.println("1.Wanna create a member? Press 1" + "\n"
					+ "2.Wanna list all the members with compact style? Press 2" + "\n"
					+ "3.Wanna delete a member? Press 3" + "\n"
					+ "4.Wanna change member information on someone? Press 4." + "\n"
					+ "5.Wanna look at specific member information? Press 5. " + "\n"
					+ "6.Wanna register a boat? Press 6" + "\n" + "7.Wanna delete a boat? Press 7" + "\n"
					+ "8.Wanna change boat information? Press 8" + "\n" + "9.Wanna save and exit? Press 9" + "\n"
					+ "10. Wanna list all members with verbose style? Press 10");
			int userInput0 = userInput.nextInt();

			if (userInput0 == 1) {
				a.addNewMember(member, userInput);
			}
			if (userInput0 == 2) {
				a.compactList(member, userInput);
			}
			if (userInput0 == 3) {
                a.DeleteMember(member, userInput);
			}
			if (userInput0 == 4) {
				a.EditMember(member, userInput);
			}
			if (userInput0 == 5) {
				a.ViewSpecificMember(member, userInput);
				}
			if (userInput0 == 6) {
				a.registerBoat(member,boats,userInput );
			}
			if (userInput0 == 7) {
				a.deleteBoat(member, boats, userInput);
			}
			if (userInput0 == 8) {
				a.editBoat(boats, userInput);
			}
			if (userInput0 == 9) {
				a.saveToText(member, boats);
				a.writeToBoatRegister(member, boats);
			}
			if (userInput0 == 10) {
				a.verboseList(member, boats);
			}




		}

	}


}