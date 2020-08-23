package com;

import java.util.ArrayList;

public class AddressBookName {

	public AddressBookName(String newAddressBookName) {
		super();
		NewAddressBookName = newAddressBookName;
	}


	public String NewAddressBookName;
	public String getNewAddressBookName() {
		return NewAddressBookName;
	}

	public void setNewAddressBookName(String newAddressBookName) {
		NewAddressBookName = newAddressBookName;
	}


	public String toString() {
		return "The New AddressBook Name is : " +NewAddressBookName;
	}

	
}
