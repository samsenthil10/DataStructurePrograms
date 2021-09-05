package com.bridgelabz.datastructureprograms;

import java.util.Scanner;

import com.bridgelabz.datastructures.Node;
import com.bridgelabz.datastructures.OrderedLinkedList;


public class OrderedList {

	public static void main(String[] args) {
		System.out.print("Enter the size of numbers :");
		Scanner scanner = new  Scanner(System.in);
		int size = scanner.nextInt();
		System.out.print("Enter "+size+" numbers: ");
		OrderedLinkedList<Integer> orderedLinkedList = new OrderedLinkedList<>();
		for(int index=0;index<size;index++) {

			Integer number=scanner.nextInt();
			Node<Integer> myNode= new Node<Integer>(number);
			orderedLinkedList.addIncreasingOrder(myNode);
		}
		System.out.print("Enter the number to be added or removed: ");
		Integer key = scanner.nextInt();
		Node<Integer> searchNode= new Node<Integer>(key);
		if(orderedLinkedList.search(key)==null) {
			System.out.print("Given number is not found in the list, hence adding it to the list: ");
			orderedLinkedList.addIncreasingOrder(searchNode);
		}
		else {
			System.out.print("Given number is found in the list, hence removing it from the list: ");
			searchNode=(Node<Integer>) orderedLinkedList.deleteGivenKeyNode(key);
		}
		System.out.println(orderedLinkedList);
		scanner.close();
	}
}