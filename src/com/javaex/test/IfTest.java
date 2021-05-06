package com.javaex.test;

import java.util.Scanner;

public class IfTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		if(num == 1) System.out.println("1입니다.");
		else if(num == 2) System.out.println("2입니다.");
		else if(num == 3) System.out.println("3입니다.");
		
	}
}
