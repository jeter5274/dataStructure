package com.javaex.study;

import java.util.EmptyStackException;

public class StackMyself {

	public static void main(String[] args) {
		//정수형 스택 테스트
		MyStack<Integer> stack = new MyStack<Integer>();
		
		stack.push(1);
		stack.push(3);
		stack.push(5);
		stack.push(7);
		stack.push(9);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		System.out.println(stack.chkData());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
	}
}

class MyStack<T> {
	
	//Node 클래스
	class Node<T>{
		
		//필드
		private T data;
		private Node<T> next;
		
		//생성자
		public Node(T data){
			this.data = data;
		}
	}
	
	//필드
	private Node<T> top;
	
	//생성자 - 생략(기본생성자 활용)
	
	//일반메소드
	
	//스택에 값 추가
	public void push(T value) {
		
		//새로운 노드를 만들고
		Node<T> pushNode = new Node<T>(value);
		
		//새로운 노드의 다음 노드에 탑을 저장
		pushNode.next = top;
		
		//새로운 노드를 탑으로 변경
		top = pushNode;
 	}
	
	//스택에서 데이터 가져오기
	public T pop() {
		
		//스택이 비어있는 경우, 예외 처리
		if(top == null) {
			throw new EmptyStackException();
		}
		
		//탑의 데이터를 꺼내고
		T data = top.data;
		
		//다음 값을 탑으로 변경
		top = top.next;
		
		return data;
	}
	
	//스택의 현재 top데이터를 출력(가져오지는 않음)
	public T chkData() {
		//스택이 비어있는 경우, 예외 처리
		if(top == null) {
			throw new EmptyStackException();
		}
		
		return top.data;
	}
	
	//스택이 비어있는지 확인
	public boolean isEmpty() {
		return top == null;
	}
}

