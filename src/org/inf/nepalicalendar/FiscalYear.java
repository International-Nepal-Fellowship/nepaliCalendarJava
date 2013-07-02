/*
 * @package org.inf.personneldatabase.reports
 * @project stdScriptlet
 * @file FiscalYear.java
 * 
 * @author Artur Neumann ICT Projects INFN - ict.projects@nepal.inf.org
 * 
 * @edited 16.02.2012 11:56:26
 * 
 * @JRE 1.6.0_22
 */
package org.inf.nepalicalendar;



/**
 * The Class FiscalYear, defines the nepali fiscal year. 
 * basically just a new datatype to hold all the informations we need for a fiscal year.
 * 
 */
public class FiscalYear {
	
	/** The fiscal year start month. */
	private int fiscalYearStartMonth = 1;
	
	/** The fiscal year start day. */
	private int fiscalYearStartDay = 1;

	/** The fiscal year calendar. */
	private String fiscalYearCalendar = "Nepali";

	
	
	
	/**
	 * Instantiates a new fiscal year.
	 * 
	 * @param startMonth
	 *            the start month
	 * @param startDay
	 *            the start day
	 * @param calendar
	 *            the calendar
	 */
	FiscalYear(final int startMonth, final int startDay, final String calendar) {
		fiscalYearStartMonth = startMonth;
		fiscalYearStartDay = startDay;
		fiscalYearCalendar = calendar;
		
	}
	

	/**
	 * Gets the fiscal year calendar.
	 * 
	 * @return the fiscalYearCalendar
	 */
	public final String getFiscalYearCalendar() {
		return fiscalYearCalendar;
	}

	/**
	 * Gets the fiscal year start day.
	 *
	 * @return the fiscalYearStartDay
	 */
	public final int getFiscalYearStartDay() {
		return fiscalYearStartDay;
	}


	/**
	 * Gets the fiscal year start month.
	 *
	 * @return the fiscalYearStartMonth
	 */
	public final int getFiscalYearStartMonth() {
		return fiscalYearStartMonth;
	}

	
}
