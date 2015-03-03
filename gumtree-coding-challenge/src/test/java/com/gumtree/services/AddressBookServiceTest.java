package com.gumtree.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gumtree.domain.Gender;
import com.gumtree.domain.Person;

// TODO: Auto-generated Javadoc
/**
 * The Class AddressBookServiceTest.
 */
public class AddressBookServiceTest {

	/** The address book service. */
	AddressBookService addressBookService = new AddressBookService();

	/**
	 * Setup.
	 */
	@BeforeMethod
	public void setup() {
		List<Person> personsList = new ArrayList<Person>();
		personsList.add(new Person("Bill McKnight", Gender.MALE, LocalDate.of(
				1977, 3, 16)));
		personsList.add(new Person("Paul Robinson", Gender.MALE, LocalDate.of(
				1985, 1, 15)));
		personsList.add(new Person("Gemma Lane", Gender.FEMALE, LocalDate.of(
				1991, 11, 20)));
		personsList.add(new Person("Sarah Stone", Gender.FEMALE, LocalDate.of(
				1980, 9, 20)));
		personsList.add(new Person("Wes Jackson", Gender.MALE, LocalDate.of(
				1974, 8, 14)));
		addressBookService.setPersonsList(personsList);
	}

	/**
	 * Test get quantity by gender.
	 */
	@Test
	public void testGetQuantityByGender() {
		assertEquals(addressBookService.getQuantityByGender(Gender.MALE), 3);
	}

	/**
	 * Test get person by oldest.
	 */
	@Test
	public void testGetPersonByOldest() {
		assertEquals(addressBookService.getPersonByOldest().getName(),
				"Wes Jackson");
	}

	/**
	 * Test compare age by days using name for younger.
	 */
	@Test
	public void testCompareAgeByDaysUsingNamePositive() {
		assertEquals(addressBookService.calculateAgeDifferenceInDays(
				"Bill McKnight", "Paul Robinson"), 2862);
	}

	/**
	 * Test compare age by days using name for older.
	 */
	@Test
	public void testCompareAgeByDaysUsingNameNegative() {
		assertEquals(addressBookService.calculateAgeDifferenceInDays(
				"Paul Robinson", "Bill McKnight"), -2862);
	}

}
