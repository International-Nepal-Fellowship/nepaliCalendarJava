/*
 * @package org.inf.personneldatabase.reports
 * @project stdScriptlet
 * @file NepaliDate.java
 * 
 * @author Artur Neumann ICT Projects INFN - ict.projects@nepal.inf.org
 * 
 * @edited 16.02.2012 11:56:29
 * 
 * @JRE 1.6.0_22
 */
package org.inf.nepalicalendar;

import java.util.Arrays;
import java.util.List;


/**
 * The Class NepaliDate.
 * Stores a nepali Date object
 */
public class NepaliDate {

	/** The day. */
	private Integer day;

	/** The year. */
	private Integer year;

	/** The month. */
	private Integer month;
	
	/** This is really just to avoid magic-number-warning from checkstyle. */
	private static final Integer MAX_DAYS_IN_MONTH = 32;
	
	/** This is really just to avoid magic-number-warning from checkstyle. */
	private static final Integer MAX_MONTH_IN_YEAR = 12;	
	
	/**
	 * only this month names are valid: "Baisakh", "Jestha", "Ashadh",
	 * "Shrawan", "Bhadra", "Ashwin", "Kartik", "Mangsir", "Paush", "Mangh",
	 * "Falgun", "Chaitra".
	 */
	public static final List<String> VALID_NEPALI_MONTH =
			Arrays.asList("Baisakh", "Jestha", "Ashadh", "Shrawan", "Bhadra", "Ashwin", "Kartik", 
					"Mangsir", "Paush", "Mangh", "Falgun", "Chaitra");	


	/**
	 * Instantiates a new nepali date.
	 * 
	 * @param newYear
	 *            the year
	 * @param newMonth
	 *            the month
	 * @param newDay
	 *            the day
	 * @throws NepaliDateException
	 *             the invalid nepali date exception
	 */
	public NepaliDate(final int newYear, final int newMonth, final int newDay) throws NepaliDateException {		
		if (this.validate(newYear, newMonth, newDay)) {
			this.day = newDay;
			this.month = newMonth;
			this.year = newYear;
		} else {
			throw new NepaliDateException("the date is not valid");
		}		

	}	


	/**
	 * Instantiates a new nepali date.
	 * 
	 * @param newYear
	 *            the year
	 * @param newMonth
	 *            the month
	 * @param newDay
	 *            the day
	 * @throws NepaliDateException
	 *             the invalid nepali date exception
	 */
	public NepaliDate(final int newYear, final String newMonth, final int newDay) throws NepaliDateException {

		int monthNumber;

		//convert month name to number
		try {
			monthNumber = VALID_NEPALI_MONTH.indexOf(newMonth) + 1;
		} catch (NullPointerException e) {
			throw new NepaliDateException("month cannot be null " + e);
		}

		if (monthNumber == -1) {
			throw new NepaliDateException("the month '" + newMonth 
					+ "' is not valid, please use one of these: " 
					+ VALID_NEPALI_MONTH.toString());

		}

		if (this.validate(newYear, monthNumber, newDay)) {

			this.day = newDay;
			this.month = monthNumber;
			this.year = newYear;
		} else {
			throw new NepaliDateException("the date is not valid");
		}


	}

	/**
	 * Instantiates a new nepali date.
	 * 
	 * @param newNepaliDate
	 *            the new nepali date
	 * @throws NepaliDateException
	 *             the invalid nepali date exception
	 */
	public NepaliDate(final String newNepaliDate) throws NepaliDateException {

		String[] nepaliDate = newNepaliDate.split("/");
		int newDay = Integer.parseInt(nepaliDate[2]);
		int monthNumber = Integer.parseInt(nepaliDate[1]);
		int newYear = Integer.parseInt(nepaliDate[0]);
		
		if (this.validate(newYear, monthNumber, newDay)) {
			this.day = newDay;
			this.month = monthNumber;
			this.year = newYear;
		} else {
			throw new NepaliDateException("the date is not valid");
		}		


	}


	/**
	 * Gets the day.
	 * 
	 * @return the day
	 */
	public final int getDay() {
		return day;
	}

	/**
	 * Gets the year.
	 * 
	 * @return the year
	 */
	public final int getYear() {
		return year;
	}

	/**
	 * Gets the month name.
	 * 
	 * @return the month name
	 * @see #VALID_NEPALI_MONTH
	 */
	public final String getMonthName() {
		return VALID_NEPALI_MONTH.get(this.month - 1);
	}	

	/**
	 * Gets the month number.
	 * 
	 * @return the month number
	 */
	public final int getMonthNumber() {
		return month;
	}		

	/**
	 * Validate the given date.
	 * 
	 * @param newYear
	 *            the year
	 * @param newMonth
	 *            the month
	 * @param newDay
	 *            the day
	 * @return false if the date is invalid, true when the date is valid
	 */
	public final Boolean validate(final Integer newYear, final Integer newMonth, final Integer newDay) {

		//some rough testing
		if (newDay.equals(null) 
				|| newDay <= 0 
				|| newDay > MAX_DAYS_IN_MONTH
				|| newMonth.equals(null) 
				|| newMonth <= 0 
				|| newMonth > MAX_MONTH_IN_YEAR 
				|| newYear.equals(null)) {
			return false;
		}

		try { 
			NepaliCalendar.NEPALI_CALENDAR_DATA.get(newYear).get(0); 
		} catch (NullPointerException e) {
			return false;
		}

		if (NepaliCalendar.NEPALI_CALENDAR_DATA.get(newYear).get(newMonth) < newDay) {
			return false;
		}
		
		return true;

	}

	/**
	 * To string.
	 * 
	 * @return the date as string in the format: "yyyy-MM-dd"
	 * @see #toString()
	 */
	public final String toString() {

		return this.toString("yyyy-MM-dd");
	}

	/**
	 * formated output of the date.
	 * 
	 * @param format
	 * <pre>
	 * yyyy	Year(4 char)	2067
	 * yy	Year(2 char)	67
	 * MMMM	Month (string)	Shrawan
	 * MM	Month (number)	4
	 * dd	Day in month	10
	 * </pre>
	 * @return the formated string
	 *             if format is null
	 * @see <a href="http://en.wikipedia.org/wiki/Bikram_Samwat">Bikram_Samwat
	 *      in Wikipedia</a>
	 */
	public final String toString(final String format) {

		String date;


		date = format.replace("yyyy", this.year.toString());
		date = date.replace("yy", this.year.toString().substring(2));
		date = date.replace("MMMM", this.getMonthName());
		date = date.replace("MM", String.format("%02d", this.month));
		date = date.replace("dd", String.format("%02d", this.day));


		return date;
	}	

}
