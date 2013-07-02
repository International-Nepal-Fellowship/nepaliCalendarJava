/*
 * @package org.inf.personneldatabase.reports
 * @project stdScriptlet
 * @file NepaliDateTest.java
 * 
 * @author Artur Neumann ICT Projects INFN - ict.projects@nepal.inf.org
 * 
 * @edited 16.02.2012 11:56:27
 * 
 * @JRE 1.6.0_22
 */
package org.inf.personneldatabase.reports;

import static org.junit.Assert.*;

import org.inf.nepalicalendar.NepaliDate;
import org.inf.nepalicalendar.NepaliDateException;
import org.junit.Test;


/**
 * The Class NepaliDateTest.
 */
public class NepaliDateTest {
	

	/**
	 * Test nepali date.
	 *
	 * @throws Exception the exception
	 */
	@Test 
	public void testNepaliDate() throws Exception {		
		
		NepaliDate nepaliDate1;
		
		System.out.println(System.getProperties());
		
		try {
			new NepaliDate(0, 0, 0);
			fail("this date should be invalid");
		} catch (NepaliDateException e) { }

		try {
			new NepaliDate(2069, 13, 2);
			fail("this date should be invalid");
		} catch (NepaliDateException e) { }		
		
		try {
			new NepaliDate(20690, 11, 2);
			fail("this date should be invalid");
		} catch (NepaliDateException e) { }		

		try {
			new NepaliDate(1969, 11, 2);
			fail("this date should be invalid");
		} catch (NepaliDateException e) { }
		
		
		try {
			new NepaliDate(2101, 11, 2);
			fail("this date should be invalid");
		} catch (NepaliDateException e) { }		
		
	
		try {
			new NepaliDate(2068, 06, 32);
			fail("this date should be invalid");
		} catch (NepaliDateException e) { }			
		
		nepaliDate1 = new NepaliDate(2069, 11, 2);
		assertTrue(nepaliDate1.getMonthName().compareTo("Falgun") == 0);

		nepaliDate1 = new NepaliDate(2062, 5, 2);
		assertTrue(nepaliDate1.getMonthName().compareTo("Bhadra") == 0);		
			
		nepaliDate1 = new NepaliDate(2032, "Kartik", 2);
		assertEquals("Kartik month number" , 7, nepaliDate1.getMonthNumber(),0);
		
		nepaliDate1 = new NepaliDate("2064/9/2");
		assertEquals(9, nepaliDate1.getMonthNumber(),0);
		assertEquals(2064, nepaliDate1.getYear(),0);
		assertEquals(2, nepaliDate1.getDay(),0);

		


				
	}	
	

	/**
	 * Test to string string.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testToStringString() throws Exception {
		
		NepaliDate nepaliDate1 = new NepaliDate(2069, 3, 2);
		
		assertEquals("2069.Ashadh.02",nepaliDate1.toString("yyyy.MMMM.dd"));
		assertEquals("2069.03.02",nepaliDate1.toString("yyyy.MM.dd"));
		assertEquals("69.03.02",nepaliDate1.toString("yy.MM.dd"));
		

	}

}
