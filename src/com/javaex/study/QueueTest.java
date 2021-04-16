package com.javaex.study;

import java.util.NoSuchElementException;

public class QueueTest {

	public static void main(String[] args) {
		//큐 테스트
		Queue<Integer> q = new Queue<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.peek());
		System.out.println(q.remove());
		System.out.println(q.isEmpty());
		System.out.println(q.remove());
		System.out.println(q.isEmpty());
	}

}

class Queue<T>{
	
	class Node<T>{
		
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	private Node<T> first;
	private Node<T> last;
	
	//큐에 데이터 추가
	public void add(T item) {
		Node<T> node = new Node<T>(item);
		
		if(last != null) {
			last.next = node;
		}
		
		last = node;
		
		if(first == null) {
			first = node;
		}
	}
	
	//큐에서 데이터를 삭제
	public T remove() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		
		T data = first.data;
		first = first.next;
		
		if(first == null) {
			last = null;
		}
		
		return data;
	}
	
	//큐에서 나올 데이터를 보여줌
	public T peek() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}
	
	//큐가 비어있는지 확인
	public boolean isEmpty() {
		return first == null;
	}
	
}