package com.synap.service;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

import org.springframework.stereotype.Service;

@Service
public class TestService {
	public String solution(String enter) {
		System.out.println("enter"+enter);
		String str = "";
		String[] decimal = {"Z","일","이","삼","사","오","육","칠","팔","구"};
		String[] smallOrder = {"O","십","백","천"};
		String[] bigOrder = {"조","억","만",""};
		Stack<String> newStr = new Stack<String>();
		HashMap<String, String> hm = new HashMap<String, String>();
		
		//,제거
		for(int a = 0 ; a < enter.length() ; a++) {
			char tmp = enter.charAt(a);
				if(tmp >= 48 && tmp <= 57) {
					str += tmp;
				}				
		}

		//입력 숫자 역순 저장
		for(int i = 0 ; i < 16 ; i++) {
			if(i < str.length()) {
				char tmp = str.charAt(str.length()-i-1);
				if(tmp >= 48 && tmp <= 57) {
					newStr.add(decimal[tmp - 48]+smallOrder[i%4]);						
				}				
			} else {
				newStr.add("N"+smallOrder[i%4]);
			}
		}	
		
		//숫자단위별로 문자열 분해 후 map에 저장
		String splice = ""; 
		int nzCount = 0;
		for(int j = 0 ; j < 16 ; j++) {
			String tmp = newStr.pop();
			char first = tmp.charAt(0);
			char second = tmp.charAt(1);
			
			if(second == 'O') {
				String s = "";
				if(first == 'N' || first == 'Z') {
					s = bigOrder[j/4];					
				} else {
					s = first + bigOrder[j/4];					
				}
				splice += s;
				hm.put(bigOrder[j/4], splice);
				splice = "";
				System.out.println(hm.get(bigOrder[j/4]));						
			} else {
				if(first == '일') {
					splice += second;					
				} else if(first == 'Z' || first == 'N') {
					nzCount++;
					continue;					
				} else {
					splice += tmp;					
				}

			}

		}
		
		//만단위 이상과 이하
		String str1 = hm.get(bigOrder[0])+hm.get(bigOrder[1])+hm.get(bigOrder[2]);
		String str2 = hm.get(bigOrder[3]);
		
		System.out.println("str1"+str1);
		System.out.println("str2"+str2);
		
		String result = "";
	
		boolean bStr3 = false;
		boolean bStr4 = false;	
		
		if(str1.length() != 3) {
			bStr3 = true;
		}
		if(str2.length() != 0) {
			bStr4 = true;
		}
		
		if(bStr3 && bStr4) {
			result = str1 + " " + str2 + "원";
		} else {
			result = str1 + str2 + "원";			
		}
		System.out.println("result"+result);
		return result;
	}
	
}