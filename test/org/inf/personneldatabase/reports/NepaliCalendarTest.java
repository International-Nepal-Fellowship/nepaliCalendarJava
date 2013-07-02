/*
 * @package org.inf.personneldatabase.reports
 * @project stdScriptlet
 * @file NepaliCalendarTest.java
 * 
 * @author Artur Neumann ICT Projects INFN - ict.projects@nepal.inf.org
 * 
 * @edited 16.02.2012 11:56:28
 * 
 * @JRE 1.6.0_22
 */
package org.inf.personneldatabase.reports;


import static org.junit.Assert.*;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.inf.nepalicalendar.NepaliCalendar;
import org.inf.nepalicalendar.NepaliDate;
import org.inf.nepalicalendar.NepaliDateException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * The Class NepaliCalendarTest.
 */
public class NepaliCalendarTest {

	/** The nepali calendar. */
	NepaliCalendar nepaliCalendar = new NepaliCalendar();
	

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
	}


	/**
	 * Test convert gregorian to nepali date and back.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testConvertGregorianToNepaliDateAndBack() throws Exception {
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

		Date gregorianDate;
		NepaliDate nepaliDate;

		for (int day = 1; day <= 10; day++) {
			gregorianDate = dateFormatter.parse("2011-02-"+day);
			nepaliDate = new NepaliDate(2067, 10, day+17);
			
			assertEquals("converted gregorian Date: " + dateFormatter.format(gregorianDate),
							nepaliDate.toString(), 
							this.nepaliCalendar.convertGregorianToNepaliDate(gregorianDate).toString());
			
			assertEquals("converted nepali Date: " + nepaliDate.toString(), 
							dateFormatter.format(gregorianDate), 
							dateFormatter.format(this.nepaliCalendar.convertNepaliToGregorianDate(nepaliDate)));			
		
		}
		
		
		for (int day = 1; day <= 10; day++) {
			gregorianDate = dateFormatter.parse("2011-01-"+day);
			nepaliDate = new NepaliDate(2067, 9, day+16);
			
			assertEquals("converted gregorian Date: " + dateFormatter.format(gregorianDate),
							nepaliDate.toString(), 
							this.nepaliCalendar.convertGregorianToNepaliDate(gregorianDate).toString());
			
			assertEquals("converted nepali Date: " + nepaliDate.toString(), 
							dateFormatter.format(gregorianDate), 
							dateFormatter.format(this.nepaliCalendar.convertNepaliToGregorianDate(nepaliDate)));	
		
		
		}		
		

		for (int day = 1; day < 10; day++) {
			gregorianDate = dateFormatter.parse("2012-01-"+day);
			nepaliDate = new NepaliDate(2068, 9, day+16);
			
			assertEquals("converted gregorian Date: " + dateFormatter.format(gregorianDate),
							nepaliDate.toString(), 
							this.nepaliCalendar.convertGregorianToNepaliDate(gregorianDate).toString());
			
			assertEquals("converted nepali Date: " + nepaliDate.toString(), 
							dateFormatter.format(gregorianDate), 
							dateFormatter.format(this.nepaliCalendar.convertNepaliToGregorianDate(nepaliDate)));			
			
		}		
		
		for (int day = 16; day <= 30; day++) {
			gregorianDate = dateFormatter.parse("2012-11-"+day);
			nepaliDate = new NepaliDate(2069, 8, day-15);
			assertEquals("converted gregorian Date: " + dateFormatter.format(gregorianDate),
							nepaliDate.toString(), 
							this.nepaliCalendar.convertGregorianToNepaliDate(gregorianDate).toString());
			
			assertEquals("converted nepali Date: " + nepaliDate.toString(), 
							dateFormatter.format(gregorianDate), 
							dateFormatter.format(this.nepaliCalendar.convertNepaliToGregorianDate(nepaliDate)));
		}		

		gregorianDate = dateFormatter.parse("2012-01-04");
		nepaliDate =  new NepaliDate(2068, 9, 20);
		assertEquals("converted gregorian Date: " + dateFormatter.format(gregorianDate),
				nepaliDate.toString(), 
				this.nepaliCalendar.convertGregorianToNepaliDate(gregorianDate).toString());		
		
		assertEquals("converted nepali Date: " + nepaliDate.toString(), 
				dateFormatter.format(gregorianDate), 
				dateFormatter.format(this.nepaliCalendar.convertNepaliToGregorianDate(nepaliDate)));
		
		
		gregorianDate = dateFormatter.parse("2011-12-15");
		nepaliDate =  new NepaliDate(2068, 8, 29);
		assertEquals("converted gregorian Date: " + dateFormatter.format(gregorianDate),
				nepaliDate.toString(), 
				this.nepaliCalendar.convertGregorianToNepaliDate(gregorianDate).toString());		
		
		assertEquals("converted nepali Date: " + nepaliDate.toString(), 
				dateFormatter.format(gregorianDate), 
				dateFormatter.format(this.nepaliCalendar.convertNepaliToGregorianDate(nepaliDate)));		
		
		
		gregorianDate = dateFormatter.parse("2011-12-16");
		nepaliDate =  new NepaliDate(2068, 9, 1);
		assertEquals("converted gregorian Date: " + dateFormatter.format(gregorianDate),
				nepaliDate.toString(), 
				this.nepaliCalendar.convertGregorianToNepaliDate(gregorianDate).toString());		
		
		assertEquals("converted nepali Date: " + nepaliDate.toString(), 
				dateFormatter.format(gregorianDate), 
				dateFormatter.format(
						this.nepaliCalendar.convertNepaliToGregorianDate(nepaliDate)));
		
		gregorianDate = dateFormatter.parse("1981-03-11");
		nepaliDate =  new NepaliDate(2037, 11, 28);
		assertEquals("converted gregorian Date: " + dateFormatter.format(gregorianDate),
				nepaliDate.toString(), 
				this.nepaliCalendar.convertGregorianToNepaliDate(gregorianDate).toString());		
		
		assertEquals("converted nepali Date: " + nepaliDate.toString(), 
				dateFormatter.format(gregorianDate), 
				dateFormatter.format(this.nepaliCalendar.convertNepaliToGregorianDate(nepaliDate)));		

		gregorianDate = dateFormatter.parse("1982-01-01");
		nepaliDate =  new NepaliDate(2038, 9, 17);
		assertEquals("converted gregorian Date: " + dateFormatter.format(gregorianDate),
				nepaliDate.toString(), 
				this.nepaliCalendar.convertGregorianToNepaliDate(gregorianDate).toString());		
		
		assertEquals("converted nepali Date: " + nepaliDate.toString(), 
				dateFormatter.format(gregorianDate), 
				dateFormatter.format(this.nepaliCalendar.convertNepaliToGregorianDate(nepaliDate)));		
		

		gregorianDate = dateFormatter.parse("1981-03-11");
		nepaliDate =  new NepaliDate(2037, 11, 28);
		assertEquals("converted gregorian Date: " + dateFormatter.format(gregorianDate),
				nepaliDate.toString(), 
				this.nepaliCalendar.convertGregorianToNepaliDate(gregorianDate).toString());		
		
		assertEquals("converted nepali Date: " + nepaliDate.toString(), 
				dateFormatter.format(gregorianDate), 
				dateFormatter.format(this.nepaliCalendar.convertNepaliToGregorianDate(nepaliDate)));		
		

		gregorianDate = dateFormatter.parse("1981-03-11");
		nepaliDate =  new NepaliDate(2037, 11, 28);
		assertEquals("converted gregorian Date: " + dateFormatter.format(gregorianDate),
				nepaliDate.toString(), 
				this.nepaliCalendar.convertGregorianToNepaliDate(gregorianDate).toString());		
		assertEquals("converted nepali Date: " + nepaliDate.toString(), 
				dateFormatter.format(gregorianDate), 
				dateFormatter.format(this.nepaliCalendar.convertNepaliToGregorianDate(nepaliDate)));		
		
		gregorianDate = dateFormatter.parse("2011-04-14");
		nepaliDate =  new NepaliDate(2068, 1, 1);		
		assertEquals("converted gregorian Date: " + dateFormatter.format(gregorianDate),
				nepaliDate.toString(), 
				this.nepaliCalendar.convertGregorianToNepaliDate(gregorianDate).toString());	
		
		assertEquals("converted nepali Date: " + nepaliDate.toString(), 
				dateFormatter.format(gregorianDate), 
				dateFormatter.format(this.nepaliCalendar.convertNepaliToGregorianDate(nepaliDate)));		
		

		gregorianDate = dateFormatter.parse("2011-07-17");
		nepaliDate =  new NepaliDate(2068, 4, 1);		
		assertEquals("converted gregorian Date: " + dateFormatter.format(gregorianDate),
				nepaliDate.toString(), 
				this.nepaliCalendar.convertGregorianToNepaliDate(gregorianDate).toString());	
		
		assertEquals("converted nepali Date: " + nepaliDate.toString(), 
				dateFormatter.format(gregorianDate), 
				dateFormatter.format(this.nepaliCalendar.convertNepaliToGregorianDate(nepaliDate)));				
				
		
	}

	
	/**
	 * Test get start and end of fiscal year.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGetStartAndEndOfFiscalYear() throws Exception {
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date gregorianDate;
		
		try {
			this.nepaliCalendar.getStartFiscalYear(2068, "Shrawann");
			fail("this date should be invalid");
		}
		catch (NepaliDateException e) {}	
		
		
		gregorianDate = dateFormatter.parse("2011-07-17");
		assertEquals("start of Fical Year Nepali: " + new NepaliDate(2068,"Shrawan",01).toString(), 
				dateFormatter.format(gregorianDate), 
				dateFormatter.format(this.nepaliCalendar.getStartFiscalYear(2068, "Shrawan")));
		
		assertEquals("start of Fical Year Nepali: " + new NepaliDate(2068,"Shrawan",01).toString(), 
				dateFormatter.format(gregorianDate), 
				dateFormatter.format(this.nepaliCalendar.getStartFiscalYear(2068, "01-Shrawan")));
		

		gregorianDate = dateFormatter.parse("2010-04-14");
		assertEquals("start of Fical Year Nepali: " + new NepaliDate(2067,"Baisakh",01).toString(), 
				dateFormatter.format(gregorianDate), 
				dateFormatter.format(this.nepaliCalendar.getStartFiscalYear(2067, "Baisakh")));		

		
		assertEquals("start of Fical Year Nepali: " + new NepaliDate(2067,"Baisakh",01).toString(), 
				dateFormatter.format(gregorianDate), 
				dateFormatter.format(this.nepaliCalendar.getStartFiscalYear(2067, "01-Baisakh")));		
			
		
		gregorianDate = dateFormatter.parse("2012-01-01");
		assertEquals("start of Fical Year Nepali: " + new NepaliDate(2068,9,17).toString(), 
				dateFormatter.format(gregorianDate), 
				dateFormatter.format(this.nepaliCalendar.getStartFiscalYear(2068, "January")));		
		
		gregorianDate = dateFormatter.parse("2013-01-01");		
		assertEquals("start of Fical Year Nepali: " + new NepaliDate(2068,9,17).toString(), 
				dateFormatter.format(gregorianDate), 
				dateFormatter.format(this.nepaliCalendar.getStartFiscalYear(2069, "01-January")));			
		
		
		
		
		gregorianDate = dateFormatter.parse("2011-07-16");
		assertEquals("end of Fical Year Nepali: " + new NepaliDate(2068,3,32).toString(), 
				dateFormatter.format(gregorianDate), 
				dateFormatter.format(this.nepaliCalendar.getEndFiscalYear(2068, "Shrawan")));
		
	
		gregorianDate = dateFormatter.parse("2011-12-31");
		assertEquals("end of Fical Year Nepali: " + new NepaliDate(2068,9,16).toString(), 
				dateFormatter.format(gregorianDate), 
				dateFormatter.format(this.nepaliCalendar.getEndFiscalYear(2068, "January")));	
		
		
		
		
	}
	
}
