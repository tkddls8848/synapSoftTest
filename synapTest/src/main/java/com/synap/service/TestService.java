package com.synap.service;

import java.util.ArrayList;
import java.util.Stack;

public class TestService {

	// ���� ��ȣ �б�
	public static String readNumber(char ch, int unit) {
		switch (ch) {
		case '0':
			return "";
		// �� �̻󿡸� ���ڸ� �θ�
		case '1':
			if (unit == 0) {
				return "��";
			} else {
				return "";
			}
		case '2':
			return "��";
		case '3':
			return "��";
		case '4':
			return "��";
		case '5':
			return "��";
		case '6':
			return "��";
		case '7':
			return "ĥ";
		case '8':
			return "��";
		case '9':
			return "��";

		}
		return "";
	}

	// ,�� �� ������ ���ڿ� �����
	public static void numberFilter(String example) {

		ArrayList<Character> arr = new ArrayList<Character>();
		Stack<String> result = new Stack<String>();
		int len = example.length();

		for (int i = len - 1; i >= 0; i--) {
			char ch = example.charAt(i);
			if (ch == ',' || ch == '��') {
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

	// õ �̻� ���� ����
	public static Stack<String> unitNumber(ArrayList<Character> arr) {

		int order = 0;
		Stack<String> stack = new Stack<String>();

		for (int j = 0; j < arr.size(); j++) {

			String str = "";
			char arrNumber = arr.get(j);

			if (j % 4 == 1) {
				str = str + readNumber(arrNumber, order) + '��';
				stack.push(str);
				System.out.println("str" + str);
			} else if (j % 4 == 2) {
				str = str + readNumber(arrNumber, order) + '��';
				stack.push(str);
				System.out.println("str" + str);
			} else if (j % 4 == 3) {
				str = str + readNumber(arrNumber, order) + 'õ';
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

	// �� �̻� ���� ����
	public static String orderNumber(int it) {
		String order = "";
		switch (it) {
		case 0:
			order = "��";
			break;
		case 1:
			order = "�� ";
			break;
		case 2:
			order = "��";
			break;
		case 3:
			order = "��";
			break;
		}
		return order;
	}

	public static void main(String[] args) {

		String example = "1,204,567,890��";

		numberFilter(example);

	}

}
