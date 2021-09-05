package com.bridgelabz.datastructureprograms;

import java.util.ArrayList;
import java.util.Scanner;

import com.bridgelabz.datastructures.Node;
import com.bridgelabz.datastructures.OrderedLinkedList;
import com.bridgelabz.datastructures.HashTable;

public class HashingCollision {

	private static  int numBuckets=0;
	private static ArrayList<OrderedLinkedList<Integer>> myBucketArray;

	public static void assignBuckets(int givenBuckets) {

		numBuckets=givenBuckets;
		myBucketArray=new ArrayList<>(numBuckets);

		for(int index=0;index<numBuckets;index++) {

			myBucketArray.add(null);
		}
	}

	public static void add(Node<Integer> myNode,Integer key) {

		int index=getBucketIndex(key);
		OrderedLinkedList<Integer> orderedLinkedList = myBucketArray.get(index);

		if(orderedLinkedList==null) {
			orderedLinkedList = new OrderedLinkedList<Integer>();
			orderedLinkedList.addIncreasingOrder(myNode);
			myBucketArray.set(index, orderedLinkedList);
		}
		else {
			orderedLinkedList.addDecreasingOrder(myNode);
			myBucketArray.set(index, orderedLinkedList);
		}
	}

	public static void remove(Integer key) {

		int index=getBucketIndex(key);
		OrderedLinkedList<Integer> orderedLinkedList=myBucketArray.get(index);
		orderedLinkedList.deleteGivenKeyNode(key);
	}

	public static String print() {

		return "MyLinkedHashMap List{" + myBucketArray +'}';
	}

	private static int getBucketIndex(Integer key) {

		int hashCode= Math.abs(key.hashCode());
		int index=hashCode%numBuckets;
		return index;
	}

	public static void main(String[] args) {

		assignBuckets(11);
		System.out.print("Enter the size of numbers: ");
		Scanner scanner = new  Scanner(System.in);
		int size = scanner.nextInt();
		System.out.print("Enter "+size+" numbers: ");
		for(int index=0;index<size;index++) {

			Integer number=scanner.nextInt();
			Node<Integer> myNode= new Node<Integer>(number);
			add(myNode,number);	
		}
		System.out.println(print());
		scanner.close();
	}
}