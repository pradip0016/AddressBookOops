package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface AddressBookManagerInterface {

	public String newaddressbook() throws IOException;

	public void openaddressbook() throws ReflectiveOperationException, RuntimeException, IOException;

	public File saveaddressbook(String filen) throws IOException;

	public void saveasaddressbook();

	public void closeaddressbook(File file);

	public void quit();
	
	public void showAddressBook();
	
	
}
