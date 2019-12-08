package com.synap.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import org.springframework.stereotype.Service;

@Service
public class TestService {
	public static String strReverse(String str) {
		String result = "";
		
		for(int i = 0 ; i < str.length() ; i++) {
			result += str.charAt(str.length()-i-1);
		}
		return result;
	}
	
	public static String integrater(Queue<String> q) {
		
		String result = "";
		
		while(!q.isEmpty()) {
			result += q.poll();
		}
		System.out.println("FINAL"+result);
		return result;
	}
	
	public static void appendBigOrder(Queue<String> str) {
		
		String[] bigOrder = {"조","억","만",""};		
		String result = "";
		Queue<String> queue = new LinkedList<String>();
		
		while(!str.isEmpty()) {
			String tmp = str.peek();
			int len = tmp.length();
			int nzCnt = 0;
			
			for(int i = 0 ; i < len ; i++) {
				if(tmp.charAt(i) =='N' || tmp.charAt(i) == 'Z') {
					nzCnt++;
				}
			}
			
			if(tmp.charAt(len-2) == '1') {
				result = tmp.substring(0,len-2)+"일"+tmp.substring(len-1,len);
			}
			if(tmp.charAt(len-1) == 'O') {
				result = tmp.substring(0,len-1)+bigOrder[0];
			}
			if(nzCnt == 4) {
				result = "";
				nzCnt = 0;
			}

			str.remove();
		}

		queue.add(result);
		System.out.println("queue : "+queue.peek());		
	}
	
	public static void appendOrder(Queue<String> queue) {

		String[] smallOrder = {"천","백","십","O"};
		String result = "";
		ArrayList<String> arr = new ArrayList<String>();
		Queue<String> st = new LinkedList<String>();
		
		while(!queue.isEmpty()) {
			arr.add(queue.peek());
			queue.remove();
		}
		
		int cnt = 0;
		
		if(arr.get(0).length() == 4) {
			for(int i = 0 ; i < arr.size() ; i++) {
				chopFour(arr.get(i));
			}
		} else if(arr.get(0).length() == 1){
			for(int i = 0 ; i < arr.size() ; i++) {
				result += arr.get(i);
				result += smallOrder[cnt%4];
				cnt++;
				st.add(result);
			}
		
		}


		if(result.length() != 0) {
			appendBigOrder(st);	
			System.out.println("천백십일 : "+result);
		
		}

	}
	
	public static void chopFour(String str) {
		
		int len = str.length()/4;
		Queue<String> st = new LinkedList<String>();
		String tmp = "";
		
		for(int i = 0 ; i < str.length() ; i++) {
			
			char c = str.charAt(i);

			tmp += c;
			if(i%len == len-1) {
				st.add(tmp);
				tmp = "";
			}

		}
		appendOrder(st);
	}

	public static String numberFilter(String enter) {
		//,제거
		String str = "";
		for(int a = 0 ; a < enter.length() ; a++) {
			char tmp = enter.charAt(a);
				if(tmp >= 48 && tmp <= 57) {
					str += tmp;
				}				
		}	
		return str;
	}
	
	public static String solution(String enter) {
		
		String str = "";
		String[] decimal = {"Z","일","이","삼","사","오","육","칠","팔","구"};
		String[] smallOrder = {"O","십","백","천"};
		String[] bigOrder = {"조","억","만","원"};
		boolean[] spacing = {false,false,false,false};
		Stack<String> newStr = new Stack<String>();
		HashMap<String, String> hm = new HashMap<String, String>();
		
		str = numberFilter(enter);
		
		//입력 숫자 역순 저장
		for(int i = 0 ; i < 16 ; i++) {
			if(i < str.length()) {
				char tmp = str.charAt(str.length()-i-1);
				if(tmp >= 48 && tmp <= 57) {
//					newStr.add(tmp+smallOrder[i%4]);	
					newStr.add(decimal[tmp - 48]+smallOrder[i%4]);	
				}				
			} else {
				newStr.add("N"+smallOrder[i%4]);
			}
		}		
		
		// 숫자단위별로 문자열 분해 후 map에 저장
		String splice = "";
		int nzCount = 0;
		for (int j = 0; j < 16; j++) {
			String tmp = newStr.pop();
			char first = tmp.charAt(0);
			char second = tmp.charAt(1);

			if (second == 'O') {
				String s = "";
				if (first == 'N' || first == 'Z') {
					s = bigOrder[j / 4];
					nzCount++;
				} else {
					s = first + bigOrder[j / 4];
				}
				if(nzCount != 4) {
					spacing[j/4] = true;
				}
				splice += s;
				hm.put(bigOrder[j / 4], splice);
				splice = "";
				nzCount = 0;
				
			} else {
				if (first == '일') {
					splice += second;
				} else if (first == 'Z' || first == 'N') {
					nzCount++;
					continue;
				} else {
					splice += tmp;
				}
			}
		}
		
		//만단위 이상과 이하
		String str1 = "";
		String str2 = "";
		for(int a = 0 ; a < 3 ; a++) {
			String tmp = hm.get(bigOrder[a]);
			if(tmp.length() == 1) {
				continue;
			} else if(tmp.length() != 1){
				if(spacing[a] == true && spacing[a+1] == true) {
					str1 += tmp + " ";						
				} else {
					str1 += tmp;					
				}
			}
		}

		if(hm.get(bigOrder[3]).length() != 0) {
			str2 += hm.get(bigOrder[3]);
		}
		
		String result = str1 + str2;
		if(!spacing[0] && !spacing[1] && !spacing[2] && !spacing[3]) {
			result = "영" + result;
		}

		return result;
	}
	
	public static void main(String[] args) {
		
		String ex;
		Scanner sc = new Scanner(System.in);
		ex = sc.nextLine();
		System.out.println(solution(ex));
		chopFour("NNNNNN1234567801");
		
		
	}
}