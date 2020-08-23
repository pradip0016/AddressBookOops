package com;

import java.io.IOException;
import java.util.*;

class AddressBookOops {
	static Object ob;
	public static void main(String[] args) throws ReflectiveOperationException, RuntimeException, IOException {

		while (true) {
			System.out.println("1) create new Address Book \n" + "2) Open Address Book \n" + "3) Save Address Book \n"
					+ "4) Save As Address Book \n" + "5) Close Address Book \n" + "6) Quit \n"
					+ "7) Show AddressBooks\n");
			System.out.println("Please Enter Your Choice \n");
			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();
			AddressBookManagerImplementation AddressbookManagerImplementation = new AddressBookManagerImplementation();
			switch (ch)

			{
			case 1:
				ob=AddressbookManagerImplementation.newaddressbook();
				break;
			case 2:
			
				AddressbookManagerImplementation.openaddressbook();
				break;
			case 3:
				AddressbookManagerImplementation.saveaddressbook(ob.toString());
				break;
			case 4:
				AddressbookManagerImplementation.saveasaddressbook();
				break;
			case 5:
				AddressbookManagerImplementation.closeaddressbook();
				break;
			case 6:
				AddressbookManagerImplementation.quit();
				break;
			case 7:
				AddressbookManagerImplementation.showAddressBook();
				break;
			default:
				System.out.println("Wrong choice please enter choice from above menu");

			}
		}
	}

}
