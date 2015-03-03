package com.gumtree.processor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gumtree.domain.Gender;
import com.gumtree.domain.Person;
import com.gumtree.domain.PersonBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class AddressBookFileProcessor.
 */
public class AddressBookFileProcessor {

	/**
	 * Read file.
	 *
	 * @param path
	 *            the path
	 * @param fileName
	 *            the file name
	 * @return the list
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws NumberFormatException
	 *             the number format exception
	 */

	public static List<Person> readFile(String path, String fileName)
			throws IOException, NumberFormatException {
		List<Person> personsList = new ArrayList<Person>();
		List<String> personInfoStringList = Files.readAllLines(Paths.get(path,
				fileName));

		for (String personInfoString : personInfoStringList) {
			String[] personInfoStringArray = personInfoString.split(",");
			
			// 3 elements in the string array : Name, Gender, DateOfBirth 
			if (personInfoStringArray.length == 3) {

				String name = personInfoStringArray[0].trim();
				Gender gender = PersonBuilder
						.getGender(personInfoStringArray[1].trim());
				LocalDate dob = PersonBuilder
						.getDateOfBirth((personInfoStringArray[2].trim()));

				if (StringUtils.isNotBlank(name) && gender != null
						&& dob != null) {
					Person person = new Person(name, gender, dob);
					personsList.add(person);
				}
			}
		}
		return personsList;
	}
}
