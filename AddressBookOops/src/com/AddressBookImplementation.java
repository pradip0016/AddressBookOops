package com;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class AddressBookImplementation implements AddressbookInterfce {

	String firstname;
	String lastname;
	String city;
	String state;
	int zipcode;
	String phonenumber;
	int count = 0;
	String path = "E:\\Pradip\\AddressBookOops\\demo\\Files\\";
	String fileuse;
	FileWriter fileWriter;
	FileReader filereader;
	BufferedWriter out;
	BufferedReader in;
	int choice = 0, Dbook;
	Scanner sc = new Scanner(System.in);
	ArrayList<Person> personarraylist1 = new ArrayList<Person>(100);

	@Override
	public void addperson() throws IOException {

		int i = 1;
		System.out.println("Enter number of Details to be entered");
		Dbook = sc.nextInt();
		for (i = 0; i < Dbook; i++) {
			System.out.println("Enter First Name :");
			firstname = sc.next();
			System.out.println("Enter Last Name :");
			lastname = sc.next();
			System.out.println("Enter City :");
			city = sc.next();
			System.out.println("Enter State :");
			state = sc.next();
			System.out.println("Enter Zip Code :");
			zipcode = sc.nextInt();
			System.out.println("Enter Phone Number:");
			phonenumber = sc.next();
			personarraylist1.add(new Person(firstname, lastname, city, state, zipcode, phonenumber));

		}
		fileWriter = new FileWriter(path + fileuse + ".txt", true);
		out = new BufferedWriter(fileWriter);
		for (int J = 0; J < personarraylist1.size(); J++) {
			out.write(personarraylist1.get(J).toString() + "\n");
		}
		out.close();
		fileWriter.close();

	}

	@Override
	public void editperson() throws IOException {

		System.out.println("Enter number for edit person data\n");
		String lineToFind = sc.next();

		File inFile = new File((path + fileuse + ".txt"));
		File tempFile = new File(path + fileuse + ".tmp");
		BufferedReader br = new BufferedReader(new FileReader(inFile));
		PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

		String line = null;
		while ((line = br.readLine()) != null) {

			if (!line.trim().contains(lineToFind)) {

				pw.println(line);
				pw.flush();
			}
		}
		pw.close();
		br.close();

		if (inFile.delete())
			System.out.print(" ");
		if (tempFile.renameTo(inFile))
			System.out.print(" ");

		System.out.println("Enter First Name :");
		firstname = sc.next();
		System.out.println("Enter Last Name :");
		lastname = sc.next();
		System.out.println("Enter City :");
		city = sc.next();
		System.out.println("Enter State :");
		state = sc.next();
		System.out.println("Enter Zip Code :");
		zipcode = sc.nextInt();
		System.out.println("Enter Phone Number:");
		phonenumber = sc.next();
		personarraylist1.add(new Person(firstname, lastname, city, state, zipcode, phonenumber));

		fileWriter = new FileWriter(path + fileuse + ".txt", true);
		out = new BufferedWriter(fileWriter);
		for (int J = 0; J < personarraylist1.size(); J++) {
			out.write(personarraylist1.get(J).toString() + "\n");

		}
		out.close();
		fileWriter.close();
	}

	@Override
	public void deleteperson() throws IOException {

		System.out.println("Enter Name for Delete");
		String lineToRemove = sc.next();
		File inFile = new File((path + fileuse + ".txt"));
		File tempFile = new File(path + fileuse + ".tmp");
		BufferedReader br = new BufferedReader(new FileReader(inFile));
		PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

		String line = null;
		while ((line = br.readLine()) != null) {

			if (!line.trim().contains(lineToRemove)) {

				pw.println(line);
				pw.flush();
			}
		}
		pw.close();
		br.close();

		if (inFile.delete())

			System.out.println("deleted");

		if (tempFile.renameTo(inFile))
			System.out.println(" ");

	}

	@Override
	public void searchperson() throws ReflectiveOperationException, RuntimeException, IOException {
		File input = new File((path + fileuse + ".txt"));
		FileReader fr = null;
		Scanner ob = new Scanner(System.in);
		String search, str;
		System.out.println("Please enter number for search :");
		search = ob.nextLine();
		fr = new FileReader(input);
		BufferedReader br = new BufferedReader(fr);
		while ((str = br.readLine()) != null) {
			if (str.contains(search))
				System.out.println(str);

		}

		fr.close();
		br.close();
	}

	@Override
	public void sortbyzipperson() throws IOException {

		File inFile = new File((path + "Book1.txt"));
		File inFile2 = new File((path + "SortByzip.txt"));
		BufferedReader reader = new BufferedReader(new FileReader(inFile));
		ArrayList<Person> lines2 = new ArrayList<Person>();
		String currentLine = reader.readLine();
		while (currentLine != null) {
			String[] persondrtails = currentLine.split("  ");
			String firstname = persondrtails[0];
			String lastname = persondrtails[1];
			String city = persondrtails[2];
			String state = persondrtails[3];
			int zipcode = Integer.valueOf(persondrtails[4]);
			String phonenumber = persondrtails[5];
			lines2.add(new Person(firstname, lastname, city, state, zipcode, phonenumber));
			currentLine = reader.readLine();
		}
		Collections.sort(lines2, new Sortbyzip());
		BufferedWriter writer = new BufferedWriter(new FileWriter(inFile2));

		for (Person P : lines2) {
			System.out.println(P);
			writer.write(P.firstname);
			writer.write("  " + P.lastname);
			writer.write("  " + P.city);
			writer.write("  " + P.state);
			writer.write("  " + P.zipcode);
			writer.write("  " + P.phonenumber);
			writer.newLine();
		}
		writer.close();
		reader.close();
	}



	@Override
	public void sortbynameperson() throws IOException {

		File inFile = new File((path + "Book1.txt"));
		File inFile2 = new File((path + "SortByname.txt"));
		BufferedReader reader = new BufferedReader(new FileReader(inFile));
		ArrayList<String> lines = new ArrayList<String>();
		String currentLine = reader.readLine();
		while (currentLine != null) {
			lines.add(currentLine);
			currentLine = reader.readLine();
		}
		Collections.sort(lines);
		BufferedWriter writer = new BufferedWriter(new FileWriter(inFile2));
		for (String line : lines) {
			System.out.println(line);
			writer.write(line);
			writer.newLine();
		}
		writer.close();
		reader.close();

	}

	@Override
	public void Display() throws IOException {

		Scanner scanner = new Scanner(new File(path + fileuse + ".txt"));
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			System.out.println(line);
		}
		scanner.close();
	}

	@Override
	public void acess() throws FileNotFoundException, IOException {

		System.out.println("AddressBook Present in System \n");
		File f = new File(path);
		String[] s = f.list();
		for (String s1 : s) {
			System.out.println(s1);
		}
		System.out.println("In which AddressBook You want to Perform Operation\n");
		fileuse = sc.next();

	}

}