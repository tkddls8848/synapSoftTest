package com.synap.service;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TestService {

	static String[] num = {"영","일","이","삼","사","오","육","칠","팔","구"};
	static String[] lowOrder = {"","십","백","천"};
	static String[] bigOrder = {"원","만","억","조"};

	public static String readNumber(char ch) {
		
		String str = "";
		int i = ch - '0';
		str = num[i];
		
		return str;
	}
	
	public static String reString(String str) {
		
		int len = str.length();
		String result = "";
		
		for (int i = len-1 ; i >= 0 ; i--) {
			char ch = str.charAt(i);
			if (ch == ',' || ch == '원') {
				continue;
			} else {
				String reStr = readNumber(ch);
				result += reStr;
			}
		}
		
		return result;
	}
	
	public static void solution(String str) {
		
		String answer = "";
		String reStr = reString(str);
		
		for(int i = 0 ; i < reStr.length() ; i++) {
			String tmp = "";
			if(i%4 == 3) {
				if(reStr.charAt(i) != '영') {
					tmp += reStr.charAt(i);	
				}
				tmp += lowOrder[3];
				System.out.println(tmp);
				answer += tmp;
			} else if (i%4 == 2) {
				if(reStr.charAt(i) != '영') {
					tmp += reStr.charAt(i);
				}
				tmp += lowOrder[2];	
				System.out.println(tmp);
				answer += tmp;
			} else if (i%4 == 1) {
				if(reStr.charAt(i) != '영') {
					tmp += reStr.charAt(i);	
				}
				tmp += lowOrder[1];
				System.out.println(tmp);
				answer += tmp;
			} else if (i%4 == 0) {
				if(reStr.charAt(i) != '영') {
					tmp += reStr.charAt(i);	
				}
				tmp += lowOrder[0];
				if(reStr.charAt(i) != '영') {
					tmp += bigOrder[i/4];	
					System.out.println(tmp);
				}
				answer += tmp;
			}
		}

		
	}

	
	public static void main(String[] args) {
		
		String ex;
		Scanner sc = new Scanner(System.in);
		ex = sc.nextLine();
		solution(ex);

	}
}