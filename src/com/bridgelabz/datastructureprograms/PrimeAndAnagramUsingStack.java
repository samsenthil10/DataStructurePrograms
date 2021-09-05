package com.bridgelabz.datastructureprograms;

import java.util.Arrays;
import java.util.LinkedList;

import com.bridgelabz.datastructures.Node;
import com.bridgelabz.datastructures.Stack;

public class PrimeAndAnagramUsingStack {

	public static void checkAnagramsUsingStack(LinkedList<Integer> listOfPrime) {

		for(int index1=0;index1<listOfPrime.size();index1++) {
			for(int index2=index1;index2<listOfPrime.size();index2++) {

				boolean isAnagram = true;
				String string1=String.valueOf(listOfPrime.get(index1));
				String string2=String.valueOf(listOfPrime.get(index2));
				if(string1.length()!=string2.length()) {
					isAnagram=false;
				}
				char string1Characters[] = string1.toCharArray();
				char string2Characters[] = string2.toCharArray();
				String[] firstString = new String[string1Characters.length];
				String[] secondString = new String[string2Characters.length];
				for(int index=0;index<string1Characters.length;index++) {
					firstString[index]=String.valueOf(string1Characters[index]);

				}
				for(int index=0;index<string1Characters.length;index++) {
					secondString[index]=String.valueOf(string2Characters[index]);
				}
				Arrays.sort(string1Characters);
				Arrays.sort(string2Characters);
				for(int index=0;index<string1.length();index++) {
					if(string1Characters[index]!=string2Characters[index]) {
						isAnagram= false;
					}
				}

				if(isAnagram==true && string1.equals(string2)==false) {

					System.out.println("Anagrams are : "+string1+" "+string2);
					Stack<String> stack = new Stack<String>();
					System.out.print("Reversing first number using stack: ");
					for(int index=0;index<string1Characters.length;index++) {

						Node<String> node = new Node<String>(firstString[index]);
						stack.push(node);
					}
					for(int index=0;index<string1Characters.length;index++) {

						System.out.print(stack.pop().getKey());
					}
					System.out.print("\nReversing second number using stack: ");
					for(int index=0;index<string2Characters.length;index++) {

						Node<String> node = new Node<String>(secondString[index]);
						stack.push(node);
					}
					for(int index=0;index<string2Characters.length;index++) {
						System.out.print(stack.pop().getKey());
					}
					System.out.println();
					System.out.println();
				}
			}
		}
	}

	public static void main(String[] args) {

		LinkedList<Integer> listOfPrime=PrimeNumbers.findPrimeNumbers(0, 1000);
		checkAnagramsUsingStack(listOfPrime);
	}
}