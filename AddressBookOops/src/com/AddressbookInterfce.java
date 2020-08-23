package com;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface AddressbookInterfce {

	public void addperson() throws IOException;

	public void editperson() throws FileNotFoundException, IOException;

	public void deleteperson() throws IOException;

	public void searchperson() throws ReflectiveOperationException, RuntimeException, FileNotFoundException, IOException;

	public void sortbyzipperson() throws FileNotFoundException, IOException;

	public void sortbynameperson() throws FileNotFoundException, IOException;
	
	public void Display() throws IOException;
 
	public void acess() throws FileNotFoundException, IOException;
}
