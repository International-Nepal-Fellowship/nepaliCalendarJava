/*
 * @package org.inf.personneldatabase.reports
 * @project stdScriptlet
 * @file NepaliCalendar.java
 * 
 * @author Artur Neumann ICT Projects INFN - ict.projects@nepal.inf.org
 * 
 * @edited 16.02.2012 11:56:27
 * 
 * @JRE 1.6.0_22
 */
package org.inf.nepalicalendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The Class Calendar.
 * does all the calculation we need with the nepali dates
 */

public class NepaliCalendar{


	/** contains all data that we need convert the dates. 
	 * <br/>
	 * for every year we need 13 values: 
	 * <ul>
	 * <li>1: the day in Paush (9th. nepali month) that is equal to the first January in this year</li>
	 * <li>2-13: amount of days in month beginning with Baisakh and ending with Chaitra</li>   
	 * </ul>
	 * {@code HashMap<nepali year , List<day in Paush for 1st Jan, no of days in Baisakh, no of days in Jestha, no of days in Ashadh, ...>>}
	 * <br/>
	 * example:<br/>
	 * {@code put((2068), Arrays.asList(17, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30));}<br/>
	 *  
	 * 
	 * */
	public static final HashMap<Integer, List<Integer>> NEPALI_CALENDAR_DATA =
			new HashMap<Integer , List<Integer>>() 
			{ 

		private static final long serialVersionUID = 1L;

		{
			//this data are from http://www.ashesh.com.np
			put((1970), Arrays.asList(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((1971), Arrays.asList(18, 31, 31, 32, 31, 32, 30, 30, 29, 30, 29, 30, 30));
			put((1972), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30));
			put((1973), Arrays.asList(19, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31));
			put((1974), Arrays.asList(19, 31, 31, 32, 30, 31, 31, 30, 29, 30, 29, 30, 30));
			put((1975), Arrays.asList(18, 31, 31, 32, 32, 30, 31, 30, 29, 30, 29, 30, 30));
			put((1976), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31));
			put((1977), Arrays.asList(18, 31, 32, 31, 32, 31, 31, 29, 30, 29, 30, 29, 31));
			put((1978), Arrays.asList(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((1979), Arrays.asList(18, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30));
			put((1980), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31));
			put((1981), Arrays.asList(18, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30));
			put((1982), Arrays.asList(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((1983), Arrays.asList(18, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30));
			put((1984), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31));
			put((1985), Arrays.asList(18, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30));
			put((1986), Arrays.asList(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((1987), Arrays.asList(18, 31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30));
			put((1988), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31));
			put((1989), Arrays.asList(18, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30));
			put((1990), Arrays.asList(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((1991), Arrays.asList(18, 31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30));	

			//this data are from http://nepalicalendar.rat32.com/index.php
			put((1992), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31));
			put((1993), Arrays.asList(18, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30));
			put((1994), Arrays.asList(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((1995), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30));
			put((1996), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31));
			put((1997), Arrays.asList(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((1998), Arrays.asList(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((1999), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31));
			put((2000), Arrays.asList(17, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31));
			put((2001), Arrays.asList(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2002), Arrays.asList(18, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30));
			put((2003), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31));
			put((2004), Arrays.asList(17, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31));
			put((2005), Arrays.asList(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2006), Arrays.asList(18, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30));
			put((2007), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31));
			put((2008), Arrays.asList(17, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31));
			put((2009), Arrays.asList(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2010), Arrays.asList(18, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30));
			put((2011), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31));
			put((2012), Arrays.asList(17, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30));
			put((2013), Arrays.asList(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2014), Arrays.asList(18, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30));
			put((2015), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31));
			put((2016), Arrays.asList(17, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30));
			put((2017), Arrays.asList(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2018), Arrays.asList(18, 31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30));
			put((2019), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31));
			put((2020), Arrays.asList(17, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2021), Arrays.asList(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2022), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30));
			put((2023), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31));
			put((2024), Arrays.asList(17, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2025), Arrays.asList(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2026), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31));
			put((2027), Arrays.asList(17, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31));
			put((2028), Arrays.asList(17, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2029), Arrays.asList(18, 31, 31, 32, 31, 32, 30, 30, 29, 30, 29, 30, 30));
			put((2030), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 30, 30, 30, 31));
			put((2031), Arrays.asList(17, 31, 32, 31, 32, 31, 31, 31, 31, 31, 31, 31, 31));
			put((2032), Arrays.asList(17, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32));
			put((2033), Arrays.asList(18, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30));
			put((2034), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31));
			put((2035), Arrays.asList(17, 30, 32, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31));
			put((2036), Arrays.asList(17, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2037), Arrays.asList(18, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30));
			put((2038), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31));
			put((2039), Arrays.asList(17, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30));
			put((2040), Arrays.asList(17, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2041), Arrays.asList(18, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30));
			put((2042), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31));
			put((2043), Arrays.asList(17, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30));
			put((2044), Arrays.asList(17, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2045), Arrays.asList(18, 31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30));
			put((2046), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31));
			put((2047), Arrays.asList(17, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2048), Arrays.asList(17, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2049), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30));
			put((2050), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31));
			put((2051), Arrays.asList(17, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2052), Arrays.asList(17, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2053), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30));
			put((2054), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31));
			put((2055), Arrays.asList(17, 31, 31, 32, 31, 31, 31, 30, 29, 30, 30, 29, 30));
			put((2056), Arrays.asList(17, 31, 31, 32, 31, 32, 30, 30, 29, 30, 29, 30, 30));
			put((2057), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31));
			put((2058), Arrays.asList(17, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31));
			put((2059), Arrays.asList(17, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2060), Arrays.asList(17, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30));
			put((2061), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31));
			put((2062), Arrays.asList(17, 30, 32, 31, 32, 31, 31, 29, 30, 29, 30, 29, 31));
			put((2063), Arrays.asList(17, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2064), Arrays.asList(17, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30));
			put((2065), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31));
			put((2066), Arrays.asList(17, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31));
			put((2067), Arrays.asList(17, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2068), Arrays.asList(17, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30));
			put((2069), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31));
			put((2070), Arrays.asList(17, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30));
			put((2071), Arrays.asList(17, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2072), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30));
			put((2073), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31));
			put((2074), Arrays.asList(17, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2075), Arrays.asList(17, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2076), Arrays.asList(16, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30));
			put((2077), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31));
			put((2078), Arrays.asList(17, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2079), Arrays.asList(17, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30));
			put((2080), Arrays.asList(16, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30));

			//this data are from http://www.ashesh.com.np/nepali-calendar/
			put((2081), Arrays.asList(17, 31, 31, 32, 32, 31, 30, 30, 30, 29, 30, 30, 30));
			put((2082), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30));
			put((2083), Arrays.asList(17, 31, 31, 32, 31, 31, 30, 30, 30, 29, 30, 30, 30));
			put((2084), Arrays.asList(17, 31, 31, 32, 31, 31, 30, 30, 30, 29, 30, 30, 30));
			put((2085), Arrays.asList(17, 31, 32, 31, 32, 31, 31, 30, 30, 29, 30, 30, 30));
			put((2086), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30));
			put((2087), Arrays.asList(16, 31, 31, 32, 31, 31, 31, 30, 30, 29, 30, 30, 30));
			put((2088), Arrays.asList(16, 30, 31, 32, 32, 30, 31, 30, 30, 29, 30, 30, 30));
			put((2089), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30));
			put((2090), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30));
			put((2091), Arrays.asList(16, 31, 31, 32, 31, 31, 31, 30, 30, 29, 30, 30, 30));
			put((2092), Arrays.asList(16, 31, 31, 32, 32, 31, 30, 30, 30, 29, 30, 30, 30));
			put((2093), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30));
			put((2094), Arrays.asList(17, 31, 31, 32, 31, 31, 30, 30, 30, 29, 30, 30, 30));
			put((2095), Arrays.asList(17, 31, 31, 32, 31, 31, 31, 30, 29, 30, 30, 30, 30));
			put((2096), Arrays.asList(17, 30, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30));
			put((2097), Arrays.asList(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30));
			put((2098), Arrays.asList(17, 31, 31, 32, 31, 31, 31, 29, 30, 29, 30, 30, 31));
			put((2099), Arrays.asList(17, 31, 31, 32, 31, 31, 31, 30, 29, 29, 30, 30, 30));
			put((2100), Arrays.asList(17, 31, 32, 31, 32, 30, 31, 30, 29, 30, 29, 30, 30));


		} };



		/** The possible types of fiscal years. */
		private static  Map<String, FiscalYear> possibleFiscalYears =
				new HashMap<String , FiscalYear>();
		static {
			Map<String, FiscalYear> aMap = new HashMap<String , FiscalYear>();
			aMap.put("01-Shrawan", new FiscalYear(4, 1, "Nepali"));
			aMap.put("01-Baisakh", new FiscalYear(1, 1, "Nepali"));
			aMap.put("01-January", new FiscalYear(1, 1, "Gregorian"));
			aMap.put("Shrawan", new FiscalYear(4, 1, "Nepali"));
			aMap.put("Baisakh", new FiscalYear(1, 1, "Nepali"));
			aMap.put("January", new FiscalYear(1, 1, "Gregorian"));
			possibleFiscalYears = Collections.unmodifiableMap(aMap);
		}




		/**
		 * Convert english to nepali date.
		 * The idea for converting bases on this pages:
		 * <ul>
		 * <li><a href="http://codeissue.com/articles/a04e050dea7468f/algorithm-to-convert-english-date-to-nepali-date-using-c-net">
		 * Algorithm to convert English date to Nepali date using C# .NET</a></li>
		 * <li><a href="http://birenj2ee.blogspot.com/2011/04/nepali-calendar-in-java.html">
		 * Biren & J2EE in Java Blogs - Nepali Calendar in java</a></li>
		 * </ul>
		 *
		 * @param gregorianDate the english date
		 * @return a valid nepali date object
		 * @throws NepaliDateException 
		 */
		public final NepaliDate convertGregorianToNepaliDate(final Date gregorianDate) throws NepaliDateException {

			Calendar gregorianCalendar = Calendar.getInstance();
			int gregorianYear;
			int gregorianDayOfYear;
			int dayOfFirstJanInPaush;
			int nepaliMonth = 9; //Jan 1 always fall in Nepali month Paush which is the 9th month of Nepali calendar.
			int daysSinceJanFirstToEndOfNepaliMonth; //days calculated from 1st Jan till the end of the actual Nepali month, 
			//we use this value to check if the gregorian Date is in the actual Nepali month.
			int nepaliYear;
			int nepaliDayOfMonth;
			gregorianCalendar.setTime(gregorianDate);
			gregorianYear = gregorianCalendar.get(Calendar.YEAR);

			//			System.out.println(gregorianDate.toString());


			gregorianDayOfYear = gregorianCalendar.get(Calendar.DAY_OF_YEAR);
			nepaliYear = gregorianYear + 56; //this is not final, it could be also +57 but +56 is always true for 1st Jan.
			NepaliDate nepaliDate;

			//get the nepali day in Paush (month 9) of 1st January 
			dayOfFirstJanInPaush = NEPALI_CALENDAR_DATA.get(nepaliYear).get(0);

			//check how many days are left of Paush 
			daysSinceJanFirstToEndOfNepaliMonth = NEPALI_CALENDAR_DATA.get(nepaliYear).get(nepaliMonth) - dayOfFirstJanInPaush + 1;

			//If the gregorian day-of-year is smaller o equal than the sum of days between the 1st January and 
			//the end of the actual nepali month we found the correct nepali month.
			//Example: 
			//The 4th February 2011 is the gregorianDayOfYear 35 (31 days of January + 4)
			//1st January 2011 is in the nepali year 2067, where 1st. January is in the 17th day of Paush (9th month)
			//In 2067 Paush has 30days, This means (30-17+1=14) there are 14days between 1st January and end of Paush 
			//(including 17th January)
			//The gregorianDayOfYear (35) is bigger than 14, so we check the next month
			//The next nepali month (Mangh) has 29 days 
			//29+14=43, this is bigger than gregorianDayOfYear(35) so, we found the correct nepali month
			while (gregorianDayOfYear > daysSinceJanFirstToEndOfNepaliMonth) {
				nepaliMonth++;
				if (nepaliMonth > 12) {
					nepaliMonth = 1;
					nepaliYear++;
				}			
				daysSinceJanFirstToEndOfNepaliMonth += NEPALI_CALENDAR_DATA.get(nepaliYear).get(nepaliMonth);



			}

			//the last step is to calculate the nepali day-of-month
			//to continue our example from before:
			//we calculated there are 43 days from 1st. January (17 Paush) till end of Mangh (29 days)
			//when we subtract from this 43days the day-of-year of the the gregorian date (35), we know how far the searched day is away
			//from the end of the nepali month. So we simply subtract this number from the amount of days in this month (30) 
			nepaliDayOfMonth = NEPALI_CALENDAR_DATA.get(nepaliYear).get(nepaliMonth)
					- (daysSinceJanFirstToEndOfNepaliMonth - gregorianDayOfYear);

			try {
				nepaliDate = new NepaliDate(nepaliYear, nepaliMonth, nepaliDayOfMonth);
			} catch (NepaliDateException e) {
				throw new NepaliDateException("convertGregorianToNepaliDate tried to create an invalid Nepali Date. " 
						+ "This should not happen, because this date is calculated from the gregorian Date: "
						+ gregorianCalendar.get(Calendar.YEAR) + "-" + gregorianCalendar.get(Calendar.MONTH) + "-" 
						+ gregorianCalendar.get(Calendar.DAY_OF_MONTH) 
						+ e);
			}

			return nepaliDate;

		}

		/**
		 * Convert nepali to gregorian date.
		 * 
		 * @param nepaliDate
		 *            the nepali date
		 * @return the gregorian date
		 */
		public final Date convertNepaliToGregorianDate(final NepaliDate nepaliDate) {

			int nepaliMonthToCheck = nepaliDate.getMonthNumber();
			int nepaliYearToCheck = nepaliDate.getYear();
			int gregorianDayOfYear = 0; //we will add all the days that went by since the 1st. 
			//January and then we can get the gregorian Date
			int gregorianYear;
			GregorianCalendar gregorianCalendar = new GregorianCalendar(); // = GregorianCalendar.getInstance();


			//get the correct year
			if (nepaliMonthToCheck > 9
					|| (nepaliMonthToCheck == 9 && nepaliDate.getDay() >= NEPALI_CALENDAR_DATA.get(nepaliYearToCheck).get(0))) {
				gregorianYear = nepaliDate.getYear() - 56;
			} else {
				gregorianYear = nepaliDate.getYear() - 57;
			}

			//first we add the amount of days in the actual Nepali month as the day of year in the gregorian one
			//because at least this days are gone since the 1st. Jan. 
			if (nepaliDate.getMonthNumber() != 9) {
				gregorianDayOfYear =  nepaliDate.getDay();
				nepaliMonthToCheck--;
			}

			//now we loop throw all nepali month and add the amount of days to gregorianDayOfYear 
			//we do this till we reach Paush (9th month). 1st. January always falls in this month  
			while (nepaliMonthToCheck != 9) {

				if (nepaliMonthToCheck <= 0) {
					nepaliMonthToCheck = 12;
					nepaliYearToCheck--;

				}				

				gregorianDayOfYear += NEPALI_CALENDAR_DATA.get(nepaliYearToCheck).get(nepaliMonthToCheck);
				nepaliMonthToCheck--;

			}

			//If the date that has to be converted is in Paush (month no. 9) we have to do some other calculation
			if (nepaliDate.getMonthNumber() == 9) {

				//add the days that are passed since the first day of Paush and substract the amount of days that lie between
				//1st. Jan and 1st Paush
				gregorianDayOfYear += nepaliDate.getDay() - NEPALI_CALENDAR_DATA.get(nepaliDate.getYear()).get(0) + 1;


				//for the first days of Paush we are now in negative values, because in the end of the gregorian year we substract
				//365 / 366 days (P.S. remember math in school + - gives -)
				if (gregorianDayOfYear <= 0) {
					if (gregorianCalendar.isLeapYear(gregorianYear)) {
						gregorianDayOfYear = 366 + gregorianDayOfYear;
					} else {
						gregorianDayOfYear = 365 + gregorianDayOfYear;

					}
				}


			} else {
				gregorianDayOfYear += NEPALI_CALENDAR_DATA.get(nepaliYearToCheck).get(9) 
						- NEPALI_CALENDAR_DATA.get(nepaliYearToCheck).get(0) + 1;
			}


			gregorianCalendar.set(GregorianCalendar.YEAR, gregorianYear);			
			gregorianCalendar.set(GregorianCalendar.HOUR_OF_DAY, 0);
			gregorianCalendar.set(GregorianCalendar.MINUTE, 0);
			gregorianCalendar.set(GregorianCalendar.SECOND, 0);
			gregorianCalendar.set(GregorianCalendar.MILLISECOND, 0);
			gregorianCalendar.set(GregorianCalendar.DAY_OF_YEAR, gregorianDayOfYear);



			return gregorianCalendar.getTime();

		}	

		/**
		 * Gets the start fiscal year.
		 * 
		 * @param nepaliYearNumberPart1
		 *            the year of the start of the fiscal year. So "2067" of
		 *            "2067/2068"
		 * @param fiscalYearType
		 *            the fiscal year type
		 * @return Date object of the first day in the  fiscal year
		 * @throws NepaliDateException
		 *             
		 */
		public final Date getStartFiscalYear(final int nepaliYearNumberPart1, final String fiscalYearType) throws NepaliDateException {

			FiscalYear fiscalYear = NepaliCalendar.possibleFiscalYears.get(fiscalYearType);
			Date startFiscalYear;
			Calendar gregorianCalendar = Calendar.getInstance();

			if (fiscalYear == null) {
				throw new NepaliDateException("the fiscalYearType " + fiscalYearType + " is unknown");
			}

			try {

				if (fiscalYear.getFiscalYearCalendar() == "Nepali") {
					startFiscalYear = convertNepaliToGregorianDate(new NepaliDate(nepaliYearNumberPart1,
							fiscalYear.getFiscalYearStartMonth(), 
							fiscalYear.getFiscalYearStartDay()));
				} else if (fiscalYear.getFiscalYearCalendar() == "Gregorian") {
					//the 1.10 of the in the nepali calendar is always after 1st Jan, so we are already in the correct year
					startFiscalYear = convertNepaliToGregorianDate(new NepaliDate(nepaliYearNumberPart1, 10, 1)); 
					gregorianCalendar.setTime(startFiscalYear);
					gregorianCalendar.set(Calendar.DAY_OF_MONTH, fiscalYear.getFiscalYearStartDay());
					gregorianCalendar.set(Calendar.MONTH, fiscalYear.getFiscalYearStartMonth() - 1); //Calendar.MONTH starts counting from 0
					gregorianCalendar.set(Calendar.HOUR_OF_DAY, 0);
					gregorianCalendar.set(Calendar.MINUTE, 0);
					gregorianCalendar.set(Calendar.SECOND, 0);
					gregorianCalendar.set(Calendar.MILLISECOND, 0);

					startFiscalYear.setTime(gregorianCalendar.getTimeInMillis());
				} else {
					throw new NepaliDateException("something went totaly wrong, check the Scriptlet-Code");
				}

				return startFiscalYear;

			} catch (NepaliDateException e) {
				throw new NepaliDateException(e);
			}


		}


		/**
		 * Gets the end of the fiscal year.
		 * 
		 * @param nepaliYearNumberPart2
		 *            the year of the end of the fiscal year. So "2068" of
		 *            "2067/2068"
		 * @param fiscalYearType
		 *            the fiscal year type
		 * @return Date object of the last day in the  fiscal year
		 * @throws NepaliDateException
		 *             
		 */
		public final Date getEndFiscalYear(final int nepaliYearNumberPart2, final String fiscalYearType) throws NepaliDateException {

			//we are calculating the start of the next year and substracting one day.

			Calendar gregorianCalendar = Calendar.getInstance();
			gregorianCalendar.setTime(getStartFiscalYear(nepaliYearNumberPart2, fiscalYearType));
			gregorianCalendar.set(Calendar.HOUR_OF_DAY, 0);
			gregorianCalendar.set(Calendar.MINUTE, 0);
			gregorianCalendar.set(Calendar.SECOND, 0);
			gregorianCalendar.set(Calendar.MILLISECOND, 0);			
			gregorianCalendar.add(Calendar.DATE, -1);

			return gregorianCalendar.getTime();


		}	


		/**
		 * Gets the amount of days between a specific date and the end of the fiscal year.
		 * 
		 * 
		 * @param date
		 *          the date object of the specific date  
		 * @param nepaliYearNumberPart2
		 *            the year of the end of the fiscal year. So "2068" of
		 *            "2067/2068"
		 * @param fiscalYearType
		 *            the fiscal year type
		 * @return amount of days between today and the end of the fiscal year
		 * @throws NepaliDateException
		 *             
		 */
		public final long getDaysTillEndOfFiscalYear(final Date date, final int nepaliYearNumberPart2, final String fiscalYearType) throws NepaliDateException {

			Calendar startCalendar = Calendar.getInstance();
			startCalendar.setTime(date);
			startCalendar.clear(Calendar.HOUR);
			startCalendar.clear(Calendar.MINUTE);
			startCalendar.clear(Calendar.SECOND);
			startCalendar.clear(Calendar.MILLISECOND);

			Calendar endCalendar = Calendar.getInstance();
			endCalendar.setTime(this.getEndFiscalYear(nepaliYearNumberPart2, fiscalYearType));

			long daysBetween = 0;
			while (startCalendar.before(endCalendar)) {
				startCalendar.add(Calendar.DAY_OF_MONTH, 1);
				daysBetween++;
			}
			return daysBetween;

		}

		/**
		 * Gets the amount of days between today and the end of the fiscal year.
		 * 
		 * @param nepaliYearNumberPart2
		 *            the year of the end of the fiscal year. So "2068" of
		 *            "2067/2068"
		 * @param fiscalYearType
		 *            the fiscal year type
		 * @return amount of days between today and the end of the fiscal year
		 * @throws NepaliDateException
		 *             
		 */
		public final long getDaysTillEndOfFiscalYear(final int nepaliYearNumberPart2, final String fiscalYearType) throws NepaliDateException {

			Calendar startCalendar = Calendar.getInstance();

			return getDaysTillEndOfFiscalYear(startCalendar.getTime(), nepaliYearNumberPart2, fiscalYearType);

		}


		/**
		 * Gets the amount of month between a specific date and the end of the fiscal year.
		 * 
		 * @param date
		 *          the date object of the specific date 
		 * @param nepaliYearNumberPart2
		 *            the year of the end of the fiscal year. So "2068" of
		 *            "2067/2068"
		 * @param fiscalYearType
		 *            the fiscal year type
		 * @return amount of month between today and the end of the fiscal year
		 * @throws NepaliDateException
		 *             
		 */
		public final long getMonthsTillEndOfFiscalYear(final Date date, final int nepaliYearNumberPart2, final String fiscalYearType) throws NepaliDateException {

			Calendar startCalendar = Calendar.getInstance();
			startCalendar.setTime(date);
			startCalendar.clear(Calendar.HOUR);
			startCalendar.clear(Calendar.MINUTE);
			startCalendar.clear(Calendar.SECOND);
			startCalendar.clear(Calendar.MILLISECOND);

			Calendar endCalendar = Calendar.getInstance();
			endCalendar.setTime(this.getEndFiscalYear(nepaliYearNumberPart2, fiscalYearType));

			long monthsBetween = 0;
			while (startCalendar.before(endCalendar)) {
				startCalendar.add(Calendar.MONTH, 1);
				monthsBetween++;
			}
			return monthsBetween;

		}		


		/**
		 * Gets the amount of month between today and the end of the fiscal year.
		 * 
		 * @param nepaliYearNumberPart2
		 *            the year of the end of the fiscal year. So "2068" of
		 *            "2067/2068"
		 * @param fiscalYearType
		 *            the fiscal year type
		 * @return amount of month between today and the end of the fiscal year
		 * @throws NepaliDateException
		 *             
		 */
		public final long getMonthsTillEndOfFiscalYear(final int nepaliYearNumberPart2, final String fiscalYearType) throws NepaliDateException {

			Calendar startCalendar = Calendar.getInstance();
			return getMonthsTillEndOfFiscalYear(startCalendar.getTime(),nepaliYearNumberPart2, fiscalYearType);
		}		

		/**
		 * Convert string to gregorian date.
		 * 
		 * @param dateString
		 *            the date string
		 * @param format
		 *            the format
		 * @return the date
		 * @throws ParseException
		 *             - if the beginning of the specified string cannot be parsed.
		 */
		public final Date convertStringToGregorianDate(final String dateString, final String format) 
				throws ParseException {
			DateFormat formatter; 
			formatter = new SimpleDateFormat(format);
			return  (Date) formatter.parse(dateString);
		}


		/**
		 * Convert string to gregorian date.
		 * 
		 * @param dateString
		 *            the date string
		 * @return the date
		 * @throws ParseException
		 *             - if the beginning of the specified string cannot be parsed.
		 */
		public final Date convertStringToGregorianDate(final String dateString) 
				throws ParseException {
			return convertStringToGregorianDate(dateString, "yyyy-MM-dd");
		}	


}
