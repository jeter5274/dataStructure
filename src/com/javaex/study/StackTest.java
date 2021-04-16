package com.javaex.study;

import java.util.EmptyStackException;

public class StackTest {

	public static void main(String[] args) {

		//스택 테스트
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
	}

}

//스택 클래스
class Stack<T>{
	
	class Node<T>{
		private T data;
		private Node<T> next;
		
		public Node(T data){
			this.data = data;
		}
	}
	
	private Node<T> top;
	
	//스택에서 데이터를 꺼냄
	public T pop(){
		if(top == null) {
			throw new EmptyStackException();
		}
		
		T item = top.data;
		top = top.next;
		return item;
	}
	
	//스택에 데이터를 저장
	public void push(T item) {
		Node<T> t = new Node<T>(item);
		t.next = top;
		top = t;
	}
	
	//스택의 top데이터를 보여줌
	public T peek() {
		if(top == null) {
			throw new EmptyStackException();
		}
		return top.data;
	}
	
	//스택이 비어있는지 확인함
	public boolean isEmpty() {
		return top == null;
	}
	
}