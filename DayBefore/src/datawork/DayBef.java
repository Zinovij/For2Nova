package datawork;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class DayBef {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		LocalDate localDate = LocalDate.now();
		System.out.println("************* Input Birthday date *************************");
		System.out.println("Year: ");
        int bYear = in.nextInt();
        System.out.println("Month: ");
        int bMon = in.nextInt();
        System.out.print("Day: ");
        int bDay = in.nextInt();
        in.close();
        
        LocalDate birthDateInNowYear=LocalDate.of(localDate.getYear(), bMon, bDay);
		LocalDate newbirthDate = LocalDate.of(1,1,1);
		if (birthDateInNowYear.isAfter(localDate)) {
			newbirthDate = LocalDate.of(localDate.getYear(), bMon, bDay);
		}
        if (birthDateInNowYear.isBefore(localDate)) {
        	newbirthDate = LocalDate.of(localDate.getYear()+1, bMon, bDay);
		}
         if (birthDateInNowYear.isEqual(localDate)) {
        	 newbirthDate = LocalDate.of(localDate.getYear()+1, bMon, bDay);
		}
 
        Date dat1= new Date();
        Date dat2= new Date();
        
        dat1=Date.from(newbirthDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        dat2=Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        
        
        System.out.println("************* Num ******************************");
        System.out.println( (dat1.getTime()-dat2.getTime())/(24*60*60*1000)  );
	}
	

}
