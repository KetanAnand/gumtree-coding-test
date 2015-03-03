package com.gumtree.domain;

import java.time.LocalDate;

// TODO: Auto-generated Javadoc
/**
 * The Class Person.
 *
 * @author ketan
 */
public class Person {

	/** The name. */
	private String name;

	/** The gender. */
	private Enum<Gender> gender;

	/** The date of birth. */
	private LocalDate dateOfBirth;

	/**
	 * Instantiates a new person.
	 *
	 * @param name
	 *            the name
	 */
	public Person(String name) {
		this.name = name;
	}

	/**
	 * Instantiates a new person.
	 *
	 * @param name
	 *            the name
	 * @param gender
	 *            the gender
	 * @param dateOfBirth
	 *            the date of birth
	 */
	public Person(String name, Enum<Gender> gender, LocalDate dateOfBirth) {
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public Enum<Gender> getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender
	 *            the new gender
	 */
	public void setGender(Enum<Gender> gender) {
		this.gender = gender;
	}

	/**
	 * Gets the date of birth.
	 *
	 * @return the date of birth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Sets the date of birth.
	 *
	 * @param dateOfBirth
	 *            the new date of birth
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
