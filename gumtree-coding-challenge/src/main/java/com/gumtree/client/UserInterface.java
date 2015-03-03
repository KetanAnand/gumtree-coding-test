package com.gumtree.client;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import com.gumtree.domain.Gender;
import com.gumtree.domain.Person;
import com.gumtree.processor.AddressBookFileProcessor;
import com.gumtree.services.AddressBookService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserInterface.
 *
 * @author ketan
 */
public class UserInterface {

	/** The Constant ADDRESS_BOOK_FILE_NAME. */
	private static final String ADDRESS_BOOK_FILE_NAME = "AddressBook";

	/** The Constant ADDRESS_BOOK_FILE_PATH. */
	private static final String ADDRESS_BOOK_FILE_PATH = "/Users/ketan/Downloads";

	/** The address book service. */
	static AddressBookService addressBookService;

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		addressBookService = new AddressBookService();

		try {
			readAddressBook();

			int numberOfMales = addressBookService
					.getQuantityByGender(Gender.MALE);
			System.out.println("There are " + numberOfMales
					+ " males in the group");

			Person oldestPerson = addressBookService.getPersonByOldest();
			System.out.println(oldestPerson.getName()
					+ " is the oldest person in the group.");
			
			long differenceInDays = addressBookService
					.calculateAgeDifferenceInDays("Bill McKnight",
							"Paul Robinson");
			System.out.println("Bill is older to Paul by " + differenceInDays
					+ " days.");
			
		} catch (NoSuchElementException nsee) {
			System.err
					.println("Required user - Bill or Paul is not present in the address book.");
			System.exit(1);
		} catch (IOException e) {
			System.err
					.println("I/O Exception while reading the input address book!");
			System.exit(1);
		} catch (NumberFormatException nfe) {
			System.err
					.println("Invalid Input data. Error while reading the input address book!");
			System.exit(1);
		}
	}

	/**
	 * Read address book.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private static void readAddressBook() throws IOException,
			NumberFormatException {
		System.out.println("Reading attached address book "
				+ ADDRESS_BOOK_FILE_PATH + File.separatorChar
				+ ADDRESS_BOOK_FILE_NAME);
		List<Person> personsList = AddressBookFileProcessor.readFile(
				ADDRESS_BOOK_FILE_PATH, ADDRESS_BOOK_FILE_NAME);
		addressBookService.setPersonsList(personsList);
	}

}
