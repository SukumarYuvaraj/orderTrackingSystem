package com.order.management.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import com.order.management.enums.SearchParams;
import com.order.management.mapper.SearchForm;

/**
 * Utility Method used across the application 
 *
 */
public class Utilities {
	
	public static boolean proceedSearch(SearchForm form)
	{
		return (!form.getKey().isEmpty() && !form.getValue().isEmpty()
			&& Arrays.stream(SearchParams.values()).anyMatch(values -> values.name().contentEquals(form.getKey().toUpperCase())));	
	}

	public static LocalDate parselocalDate(String format, String dateValue)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return LocalDate.parse(dateValue, formatter);
	}
}
