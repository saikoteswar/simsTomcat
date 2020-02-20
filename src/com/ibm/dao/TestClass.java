package com.ibm.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String current_day = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
		int remaining_days=0;
		try{
		
			Calendar current_date = Calendar.getInstance();
			current_date.setTime(sdf.parse(current_day));
			Calendar to_date = Calendar.getInstance();
			to_date.setTime(sdf.parse("07/04/2013"));
			
			if(current_date.before(to_date)){
				
				while(current_date.before(to_date)){
				remaining_days++;
				current_date.add(Calendar.DATE, 1);
				}
			}else{
				while(!current_date.before(to_date)){
					remaining_days--;
					to_date.add(Calendar.DATE, 1);
					}
			}
			
			System.out.println("remaining days are ::" +remaining_days);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}

}
