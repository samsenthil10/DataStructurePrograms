package com.bridgelabz.datastructureprograms;

import java.util.Scanner;

public class Calendar {

	public static int checkDay(int month, int day, int year) {

		int y = year - (14 - month) / 12;
		int x = y + y/4 - y/100 + y/400;
		int m = month + 12 * ((14 - month) / 12) - 2;
		int requiredDay = (day + x + (31*m)/12) % 7;
		return requiredDay;
	}

	public static boolean isLeapYear(int year) {
		if  ((year % 4 == 0) && (year % 100 != 0)) return true;
		if  (year % 400 == 0) return true;
		return false;
	}

	public static void main(String[] args) {

		Scanner scanner= new Scanner(System.in);
		System.out.println("enter month");
		int month = scanner.nextInt(); 
		System.out.println("Enter year");
		int year = scanner.nextInt();    

		String[] months = {"","January", "February", "March","April", "May", "June","July", "August", "September",
				"October", "November", "December"};

		int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		if (month == 2 && isLeapYear(year)) days[month] = 29;


		System.out.println("   " + months[month] + " " + year);
		System.out.println("S    M    T    W    T    F    S");

		int d = checkDay(month, 1, year);
		int weekValue= (days[month]-(7-d));
		int numberOfWeeks;
		if(weekValue%7==0)
			numberOfWeeks=(weekValue/7)+1;
		else
			numberOfWeeks=(weekValue/7)+2;


		int arrayOfWeeks[][] = new int[numberOfWeeks][7];

		int date=1,count=0;
		int flag=1;
		for(int index=0;index<numberOfWeeks;index++) {
			for(int index2=0;index2<7;index2++) {
				while(flag==1 && count<=d) {

					arrayOfWeeks[index][index2]=0;
					count++;
					if(count==d) {

						flag=0;
					}
					index2++;
				}
				arrayOfWeeks[index][index2]=date++;
			}
		}
		for(int index=0;index<numberOfWeeks;index++) {
			for(int index2=0;index2<7;index2++) {
				if(arrayOfWeeks[index][index2]==0)
					System.out.print("     ");
				else if(arrayOfWeeks[index][index2]>days[month]) {
					break;
				}
				else {
					System.out.print(arrayOfWeeks[index][index2]);
					if(arrayOfWeeks[index][index2]<9) {
						System.out.print("    ");
					}
					else {
						System.out.print("   ");
					}
				}
			}
			System.out.println();
		}
		scanner.close();
	}
}