package com.gumtree.domain;

import java.time.LocalDate;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonBuilder.
 */
public class PersonBuilder {

	/**
	 * Gets the date of birth.
	 *
	 * @param dateOfBirth
	 *            the date of birth
	 * @return the date of birth
	 * @throws NumberFormatException
	 *             the number format exception
	 */
	public static LocalDate getDateOfBirth(String dateOfBirth)
			throws NumberFormatException {
		String[] dateContents = dateOfBirth.split("/");

		// 3 elements in the dateContents : Day, Month, Year 
		if (dateContents.length == 3) {
			// Appending year prefix 19 to year if it has only 2 digits.
			String year = dateContents[2].length() == 2 ? "19"
					+ dateContents[2] : dateContents[2];
			return LocalDate.of(Integer.parseInt(year.trim()),
					Integer.parseInt(dateContents[1].trim()),
					Integer.parseInt(dateContents[0].trim()));
		}
		return null;
	}

	/**
	 * Gets the gender.
	 *
	 * @param gender
	 *            the gender
	 * @return the gender
	 */
	public static Gender getGender(String gender) {
		switch (gender.toLowerCase()) {
		case "male":
			return Gender.MALE;
		case "female":
			return Gender.FEMALE;
		default:
			return null;
		}
	}
}
