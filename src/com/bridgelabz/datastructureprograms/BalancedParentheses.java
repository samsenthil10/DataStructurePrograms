package com.bridgelabz.datastructureprograms;

import java.util.Scanner;
import com.bridgelabz.datastructures.Node;
import com.bridgelabz.datastructures.Stack;

public class BalancedParentheses {

	public static boolean checkForBalancedParenthese(String[] arithmeticExpression) {
		
		Stack<String> stack = new Stack<>();
		for(int index=0;index<arithmeticExpression.length;index++) {
			String currentString=arithmeticExpression[index];
			Node<String> myNode = new Node<String>(currentString);
			if (currentString.equals("{") ||currentString.equals("(") || currentString.equals("[")) {
				stack.push(myNode);
			}
			if (currentString.equals("}") ||currentString.equals(")") || currentString.equals("]")) {
				if (stack.isEmpty())
					return false;
				String lastString = stack.peek().getKey();

				if (currentString.equals("}") && lastString.equals("{") || currentString.equals(")") && lastString.equals("(") ||currentString.equals("]") && lastString.equals("["))
					stack.pop();
				else 
					return false;
			}
		}
		if(stack.isEmpty()) {
			return true;
		}
		else
			return false;
	}
	public static void main(String[] args) {
		
		System.out.print("Enter the Arithmetic expression: ");
		Scanner scanner = new  Scanner(System.in);
		String string=scanner.nextLine();
		scanner.close();
		String[] arithmeticExpression = string.split("");
		boolean result=checkForBalancedParenthese(arithmeticExpression);
		if(result==true) {
			System.out.println("Given expression "+string+"  is balanced");
		}
		else {
			System.out.println("Given expression "+string+"  is not balanced");
		}
	}
}