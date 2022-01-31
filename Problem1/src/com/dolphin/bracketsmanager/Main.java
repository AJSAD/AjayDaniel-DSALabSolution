package com.dolphin.bracketsmanager;

import java.util.Stack;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String bracketExpression = sc.next();

		if (isBalanced(bracketExpression)) {

			System.out.print("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}

	}

	private static boolean isBalanced(String bracketExpression) {

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < bracketExpression.length(); i++) {
			char character = bracketExpression.charAt(i);

			if (character == '(' || character == '[' || character == '{') {
				stack.push(character);
				continue;
			}

			if (stack.isEmpty()) {
				return false;
			}
			
			char c;
			
			switch (character) {
				case '}':
					c = stack.pop();
					if (c == '(' || c == '[')
						return false;
					break;
	
				case ')':
					c = stack.pop();
					if (c == '{' || c == '[')
						return false;
					break;
	
				case ']':
					c = stack.pop();
					if(c == '(' || c== '{')
						return false;
					break;
			}		
		}
		
		return stack.isEmpty();
	}
}
