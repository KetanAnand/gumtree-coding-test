package com.gumtree.processor;

import java.io.IOException;
import java.util.List;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import com.gumtree.domain.Person;

// TODO: Auto-generated Javadoc
/**
 * The Class AddressBookFileProcessorTest.
 */
public class AddressBookFileProcessorTest {

	/**
	 * Test read file.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testReadFile() throws IOException {
		List<Person> personList = AddressBookFileProcessor.readFile(
				"/Users/ketan/Downloads", "AddressBook");
		assertEquals(personList.size(), 5);
	}

}
