package com.cognizant.truyum.util;

import java.util.*;
import java.text.SimpleDateFormat;  

public class DateUtil {

	public static Date convertToDate(String s) throws Exception
	{
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");

		Date date1 = simpleDateFormat.parse(s);
		
		return date1;
		
	}
}
