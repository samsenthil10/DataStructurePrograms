package com.bridgelabz.datastructureprograms;

import java.util.LinkedList;

public class PrimeNumbers {
	public static LinkedList<Integer> findPrimeNumbers(int lowerBound,int upperBound) {
		
		boolean isPrime=true;
		LinkedList<Integer> listOfPrime=new LinkedList<Integer>();  
		for(int indexForSelectinNumber=lowerBound;indexForSelectinNumber<=upperBound;indexForSelectinNumber++) {

			if(indexForSelectinNumber==1 || indexForSelectinNumber==0)
				continue;

			for(int indexForCheckingPrime=2;indexForCheckingPrime<=indexForSelectinNumber/2;indexForCheckingPrime++) {
				if(indexForSelectinNumber%indexForCheckingPrime==0) {
					isPrime=false;
					break;
				}
			}
			if(isPrime==true) {
				listOfPrime.add(indexForSelectinNumber);
			}
			isPrime=true;
		}
		return listOfPrime;
	}

	public static void numberOfPrimes(int upperBound) {
		
		int numberOfPrime[][] = new int[upperBound/100][1];

		for(int index=0;index<upperBound/100;index=index+1) {

			numberOfPrime[index][0]=findPrimeNumbers((index*100), (index*100)+100).size();
		}

		for(int index=0;index<upperBound/100;index=index+1) {
			
			int lower=index*100;
			int upper=(index*100)+100;
			System.out.print(lower+" to "+upper);
			System.out.print(" "+numberOfPrime[index][0]);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		numberOfPrimes(1000);
	}
}