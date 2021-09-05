package com.bridgelabz.datastructureprograms;

import java.util.Scanner; 

import com.bridgelabz.datastructures.LinkedList;
import com.bridgelabz.datastructures.Node;

public class UnOrderedList {

	public static void main(String[] args) {

		System.out.print("Enter the list of words:");
		Scanner scanner = new  Scanner(System.in);
		String string=scanner.nextLine();
		String[] listOfWordsStrings = string.split(" ");
		LinkedList<String> linkedList = new LinkedList<>();

		for(int index=0;index<listOfWordsStrings.length;index++) {
			
			String currentString=listOfWordsStrings[index];
			Node<String> myNode= new Node<String>(currentString);
			linkedList.appendNode(myNode);
		}
		System.out.print("Enter the key word to search: ");
		String key=scanner.next();
		Node<String> searchNode= new Node<String>(key);
		if(linkedList.search(key)==null) {
			System.out.print("Given word is not found in the list, hence adding it to the list:");
			linkedList.appendNode(searchNode);
		}
		else {
			System.out.print("Given word is found in the list, hence removing it from the list:");
			linkedList.deleteGivenKeyNode(key);
		}
		System.out.println(linkedList);
		scanner.close();
	}
}