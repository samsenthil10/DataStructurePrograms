package com.bridgelabz.datastructureprograms;

import java.util.Scanner;
import com.bridgelabz.datastructures.Deque;
import com.bridgelabz.datastructures.Node;

public class PalindromeChecker {

	public static boolean checkForPalindrome(String[] arrayOfCharacters) {

		Deque<String> deque = new Deque<String>();
		for(int index=0;index<arrayOfCharacters.length;index++) {
			Node<String> myNode = new Node<String>(arrayOfCharacters[index]);
			deque.addRear(myNode);
		}

		while(deque.size()!=0 && deque.size()!=1) {

			String firstCharacter=deque.removeFront().getKey();
			String lastCharacter=deque.removeRear().getKey();
			if(firstCharacter.equals(lastCharacter)) {
				continue;
			}
			else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		System.out.print("Enter word/sentence: ");
		Scanner scanner = new  Scanner(System.in);
		String string=scanner.nextLine();
		String[] arrayOfCharacters = string.split("");
		scanner.close();
		boolean result=checkForPalindrome(arrayOfCharacters);
		if(result==true) {
			System.out.println("Given word/sentence "+string+"  is a palindrome");
		}
		else {
			System.out.println("Given word/sentence "+string+"  is not a palindrome");
		}
	}
}