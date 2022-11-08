package com.synct.james;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

public class question_4 {

	public static void main(String[] args) {
		/*
		int i, j, k;
		for (i = 0; i < 3; i++) {
			for (j = 1 + (i * 3); j < 4 + (i * 3); j++) {
				for (k = 1; k < 10; k++) {
					System.out.printf("%d * %d = %d", j, k, j * k);
					System.out.printf("\t");
				}
				System.out.printf("%n");
			}
			System.out.printf("%n");
		}
		*/
		/*
		//String A = "services.zip";
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date(0);
		String HMS = dateFormat.format(date);
		int tyear = Integer.parseInt(HMS.substring(0,4)) - 1911 ;
		String UPLOAD_DATE = Integer.toString(tyear) + HMS.substring(4).replace("/", "");
		
		System.out.println(UPLOAD_DATE);
		*/
		/*
		String A = "rescue_image_1.jpg";
	    String B = A.substring(A.lastIndexOf("_")+1,A.lastIndexOf(".")) ;
	    
	    int c = Integer.parseInt(B);
	    String d = Integer.toString(c);
	    System.out.println(c);
	    */
		/*
		String filename ="1071114";
		filename = filename.substring(0,3) + "/" + filename.substring(3,5) + "/" + filename.substring(5,7);
		System.out.println(filename);
		*/
		
		//月份推算 +6個月
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		cld.add(Calendar.MONTH, 6);
		
		String NEW_DATE = dateFormat.format(cld.getTime()).replace("/", "");
		String YEAR = Integer.toString(Integer.parseInt(NEW_DATE.substring(0, 4)) - 1911);
		String MONTH = NEW_DATE.substring(4, 6);
		String DAY = NEW_DATE.substring(6, 8);
		
		System.out.println(YEAR);
		

		

		

	}
}
