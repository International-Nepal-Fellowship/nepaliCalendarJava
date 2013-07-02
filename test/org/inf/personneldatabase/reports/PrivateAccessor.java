/*
 * @package org.inf.personneldatabase.reports
 * @project stdScriptlet
 * @file PrivateAccessor.java
 * 
 * @author <a href="http://www.oreillynet.com/pub/au/1356">Ross Burton</a> ross@burtonini.com
 *
 * 
 * @edited 16.02.2012 12:32:53
 * 
 * @JRE 1.6.0_22
 */

package org.inf.personneldatabase.reports;

import java.lang.reflect.Field;
import junit.framework.Assert;

/**
 * Provides access to private members in classes. 
 * @see <a href="http://onjava.com/pub/a/onjava/2003/11/12/reflection.html">Subverting Java Access Protection for Unit Testing</a>
 */
public class PrivateAccessor {
	
  /**
   * Gets the private field.
   *
   * @param o the private Object you like to access
   * @param fieldName the field name
   * @return the private field
   */
  public static Object getPrivateField (Object o, String fieldName) {
    /* Check we have valid arguments */
    Assert.assertNotNull(o);
    Assert.assertNotNull(fieldName);
    /* Go and find the private field... */
    final Field fields[] =
        o.getClass().getDeclaredFields();
    for (int i = 0; i < fields.length; ++i) {
      if (fieldName.equals(fields[i].getName())) {
        try {
          fields[i].setAccessible(true);
          return fields[i].get(o);
        } catch (IllegalAccessException ex) {
          Assert.fail ("IllegalAccessException accessing " +
            fieldName);
        }
      }
    }
    Assert.fail ("Field '" + fieldName +
                 "' not found");
    return null;
  }
  
  /**
   * Sets the private field.
   *
   * @param o the private Object you like to access
   * @param fieldName the field name
   * @param newValue the new value for the private Object
   * @return true when the private Object was updated, false if the Object was not found
   */
  public static Boolean setPrivateField (Object o, String fieldName, Object newValue) {
	    /* Check we have valid arguments */
	    Assert.assertNotNull(o);
	    Assert.assertNotNull(fieldName);
	    /* Go and find the private field... */
	    final Field fields[] =
	        o.getClass().getDeclaredFields();
	    for (int i = 0; i < fields.length; ++i) {
	      if (fieldName.equals(fields[i].getName())) {
	        try {
	          fields[i].setAccessible(true);
       		  fields[i].set(o, newValue);
       		  return true;
	        } catch (IllegalAccessException ex) {
	          Assert.fail ("IllegalAccessException accessing " +
	            fieldName);
	        }
	      }
	    }
	    Assert.fail ("Field '" + fieldName +
	                 "' not found");
	    return false;
	  }  
  
}