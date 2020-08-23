package com;

import java.io.*;
import java.util.*;

public class AddressBookManagerImplementation implements AddressBookManagerInterface {
	Scanner sc = new Scanner(System.in);
	String path = "E:\\Pradip\\AddressBookOops\\demo\\Files\\";
	public static File file;
	public String fileName;

	@Override
	public String newaddressbook() throws IOException {
		System.out.print("Enter the desired name of your Book: ");
		fileName = sc.next();
		fileName = fileName + ".txt";
		return fileName;
	}

	@Override
	public void openaddressbook() throws ReflectiveOperationException, RuntimeException, IOException {
		AddressBookImplementation AddressBookImplementation = new AddressBookImplementation();
		AddressBookImplementation.acess();
		System.out.println("Please Enter Your Choice \n");
		System.out.println("1) Add Person \n" + "2) Edit Person \n" + "3) Delete Person \n" + "4) Search Person \n"
				+ "5) Sort ByZip \n" + "6) Sort ByName \n" + "7) Display");
		int ch2 = sc.nextInt();
		switch (ch2) {
		case 1:
			AddressBookImplementation.addperson();
			break;
		case 2:
			AddressBookImplementation.editperson();
			break;
		case 3:
			AddressBookImplementation.deleteperson();
			break;
		case 4:
			AddressBookImplementation.searchperson();
			break;
		case 5:
			AddressBookImplementation.sortbyzipperson();
			break;
		case 6:
			AddressBookImplementation.sortbynameperson();
			break;
		case 7:
			AddressBookImplementation.Display();
			break;
		default:
			System.out.println("enter correct choice");
		}
	}

	@Override
	public void saveaddressbook(String filen) throws IOException {
		System.out.println(filen);
		System.out.println("Do U want To save created Address Book Y/N");
		String op = sc.next();
		if (op.equalsIgnoreCase("Y")) {
			file = new File(path + filen);
			file.createNewFile();
			System.out.println("Saved ");
		} else {
			System.out.println("Not saved");
		}

	}

	@Override
	public void saveasaddressbook() {

	showAddressBook();
	System.out.println("Please enter name which book want to rename");
	String filename=sc.next();
	System.out.println("please enter new name of book");
	String newname=sc.next();
	File oldFile = new File((path + filename + ".txt"));
	File newFile = new File(path + newname + ".txt");
	if (oldFile.renameTo(newFile))
	{
		System.out.println("file renamed and saved");
	}
		else
	
		{
			System.out.println("file not saved as ");
			
		}
	}

	@Override
	public void closeaddressbook() {
	}

	@Override
	public void quit() {
	}

	@Override
	public void showAddressBook() {
		int count = 0;
		System.out.println("AddressBook Present in System \n");
		File f = new File(path);
		String[] s = f.list();
		for (String s1 : s) {
			count++;
			System.out.println(s1);
		}
		System.out.println("======================");
	}

}
