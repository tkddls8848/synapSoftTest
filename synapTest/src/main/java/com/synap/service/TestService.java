package com.synap.service;

import java.util.ArrayList;
import java.util.Stack;

public class TestService {

	// 개별 번호 읽기
	public static String readNumber(char ch, int unit) {
		switch (ch) {
		case '0':
			return "";
		// 만 이상에만 숫자를 부름
		case '1':
			if (unit == 0) {
				return "일";
			} else {
				return "";
			}
		case '2':
			return "이";
		case '3':
			return "삼";
		case '4':
			return "사";
		case '5':
			return "오";
		case '6':
			return "육";
		case '7':
			return "칠";
		case '8':
			return "팔";
		case '9':
			return "구";

		}
		return "";
	}

	// ,와 원 제외한 문자열 만들기
	public static void numberFilter(String example) {

		ArrayList<Character> arr = new ArrayList<Character>();
		Stack<String> result = new Stack<String>();
		int len = example.length();

		for (int i = len - 1; i >= 0; i--) {
			char ch = example.charAt(i);
			if (ch == ',' || ch == '원') {
				continue;
			} else {
				arr.add(ch);
			}
		}

		result = unitNumber(arr);

		while (!result.isEmpty()) {
			System.out.println("result" + result.pop());
		}

	}

	// 천 이상 숫자 단위
	public static Stack<String> unitNumber(ArrayList<Character> arr) {

		int order = 0;
		Stack<String> stack = new Stack<String>();

		for (int j = 0; j < arr.size(); j++) {

			String str = "";
			char arrNumber = arr.get(j);

			if (j % 4 == 1) {
				str = str + readNumber(arrNumber, order) + '십';
				stack.push(str);
				System.out.println("str" + str);
			} else if (j % 4 == 2) {
				str = str + readNumber(arrNumber, order) + '백';
				stack.push(str);
				System.out.println("str" + str);
			} else if (j % 4 == 3) {
				str = str + readNumber(arrNumber, order) + '천';
				stack.push(str);
				System.out.println("str" + str);
			} else if (j % 4 == 0) {
				str = str + readNumber(arrNumber, order) + orderNumber(order);
				str.replace(" ", "");
				stack.push(str);
				System.out.println("str" + str);
				order++;
			}
		}

		return stack;
	}

	// 만 이상 숫자 단위
	public static String orderNumber(int it) {
		String order = "";
		switch (it) {
		case 0:
			order = "원";
			break;
		case 1:
			//만 단위 이후 띄어쓰기
			order = "만 ";
			break;
		case 2:
			order = "억";
			break;
		case 3:
			order = "조";
			break;
		}
		return order;
	}

	public static void main(String[] args) {

		String example = "1,204,567,890원";

		numberFilter(example);

	}

}