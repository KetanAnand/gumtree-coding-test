package com.gumtree.services;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import com.gumtree.domain.Gender;
import com.gumtree.domain.Person;

// TODO: Auto-generated Javadoc
/**
 * The Class AddressBookService.
 *
 * @author ketan
 */
/**
 * @author ketan
 *
 */
public class AddressBookService {

	/** The persons list. */
	private List<Person> personsList = new ArrayList<Person>();

	/**
	 * Sets the persons list.
	 *
	 * @param personsList
	 *            the new persons list
	 */
	public void setPersonsList(List<Person> personsList) {
		this.personsList = personsList;
	}

	/**
	 * Gets the quantity by gender.
	 *
	 * @param gender
	 *            the gender
	 * @return the quantity by gender
	 */
	public int getQuantityByGender(Gender gender) {
		return (int) getPersonsList().stream()
				.filter(person -> person.getGender() == gender).count();
	}

	/**
	 * Gets the person by oldest.
	 *
	 * @return the person by oldest
	 */
	public Person getPersonByOldest() {

		Stream<Person> sortedPersonsList = getPersonsList().stream().sorted(
				(person1, person2) -> person1.getDateOfBirth().compareTo(person2.getDateOfBirth()));
		return sortedPersonsList.findFirst().get();
	}

	/**
	 * Gets the persons list.
	 *
	 * @return the persons list
	 */
	public List<Person> getPersonsList() {
		return personsList;
	}

	/**
	 * Calculate age difference in days.
	 *
	 * @param p1
	 *            the p1
	 * @param p2
	 *            the p2
	 * @return the int
	 */
	public long calculateAgeDifferenceInDays(Person p1, Person p2) {
		return ChronoUnit.DAYS
				.between(p1.getDateOfBirth(), p2.getDateOfBirth());

	}

	/**
	 * Calculate age difference in days.
	 *
	 * @param firstPersonName
	 *            the first person name
	 * @param secondPersonName
	 *            the second person name
	 * @return the int
	 * @throws NoSuchElementException
	 *             the no such element exception
	 */
	public long calculateAgeDifferenceInDays(String firstPersonName,
			String secondPersonName) throws NoSuchElementException {
		Person firstPerson = getPersonsList()
				.stream()
				.filter(person -> person.getName().equalsIgnoreCase(
						firstPersonName)).findFirst().get();

		Person secondPerson = getPersonsList()
				.stream()
				.filter(person -> person.getName().equalsIgnoreCase(
						secondPersonName)).findFirst().get();

		return calculateAgeDifferenceInDays(firstPerson, secondPerson);

	}
}
