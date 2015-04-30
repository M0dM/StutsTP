package com.javaquarium.util;

import java.util.Map;

/**
 * Util class used to deal with session values in jsp.
 * 
 * @author Benoit
 */
public class SessionUtils {

	/**
	 * Get the SESSION_USER_POISSON value and return the number of poisson this
	 * session object contains.
	 * 
	 * @param sessionUserPoisson
	 *            the session object
	 * @return the number of poisson
	 */
	@SuppressWarnings("unchecked")
	public static int countNumberOfPoisson(final Object sessionUserPoisson) {
		int count = 0;
		if (sessionUserPoisson != null) {
			for (String key : ((Map<String, Integer>) sessionUserPoisson).keySet()) {
				count = count 
						+ ((Map<String, Integer>) sessionUserPoisson)
						.get(key);
			}
		}
		return count;
	}

}
