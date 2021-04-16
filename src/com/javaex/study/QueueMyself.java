package com.javaex.study;

import java.util.NoSuchElementException;

public class QueueMyself {

	public static void main(String[] args) {
		// 정수형 큐 테스트
		MyQueue<Integer> q = new MyQueue<Integer>();
		
		q.add(2);
		q.add(4);
		q.add(6);
		q.add(8);
		q.add(10);
		
		System.out.println(q.chkData());
		System.out.println(q.getData());
		System.out.println(q.getData());
		System.out.println(q.getData());
		System.out.println(q.getData());
		System.out.println(q.isEmpty());
		System.out.println(q.chkData());
		System.out.println(q.getData());
		System.out.println(q.isEmpty());

	}
}

//큐 클래스 생성
class MyQueue<T> {
	
	//노드 클래스 생성
	class Node<T>{
		
		//필드
		private T data;				//데이터
		private Node<T> next;		//다음 노드
		
		//생성자
		public Node(T data) {
			this.data = data;
		}
	}
	
	//필드
	private Node<T> firstNode;	//처음 노드
	private Node<T> lastNode;	//마지막 노드

	//일반메소드
	
	//큐에 데이터 추가
	public void add(T value) {
		
		//value값으로 노드를 생성
		Node<T> node = new Node<T>(value);
		
		//마지막 노드가 있다면 (Null이 아니면)
		if(lastNode != null) {
			//마지막 노드의 다음 노드에 value노드를 추가
			lastNode.next = node;
		}
		
		//마지막 노드를 value노드로 변경
		lastNode = node;
		
		//처음 노드가 없다면 (Null이면)
		if(firstNode == null) {
			//처음 노드도 value노드로 지정 (1개일 경우니까 처음이면서 끝임)
			firstNode = node;
		}
	}
	
	//큐에서 데이터를 가져옴
	public T getData() {
		
		//큐에 처음 데이터가 없는 경우(비어있음)의 예외처리
		if(firstNode == null) {
			throw new NoSuchElementException();
		}
		
		//처음 노드의 데이터를 가져옴
		T data = firstNode.data;
		
		//다음 노드를 처음노드로 변경
		firstNode = firstNode.next;
		
		//다음노드가 없을 경우 마지막 노드 삭제 (큐가 비어있음)
		if(firstNode == null) {
			lastNode = null;
		}

		return data;
	}
	
	//큐의 처음 데이터 값을 확인(큐에서 꺼내지 않음)
	public T chkData() {
		//큐에 처음 데이터가 없는 경우(비어있음)의 예외처리
		if(firstNode == null) {
			throw new NoSuchElementException();
		}
		
		return firstNode.data;
	}
	
	//큐가 비어있는지 확인
	public boolean isEmpty() {
		return firstNode == null;
	}
}
