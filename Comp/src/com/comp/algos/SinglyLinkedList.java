package com.comp.algos;

class Link	{
	int info;
	Link next;
	public Link(int info) {
		this.info = info;
	}
	
	
}

class LinkedList {
	Link first;

	public LinkedList() {
		this.first = null;
	}
	
	//Insert first
	public void insertFirst(int data) {
		Link link = new Link(data);
		link.next = first;
		first = link;
	}
	
	//Insert last
	public void insertLast(int data) {
		Link link = new Link(data);
		if( first == null ) {
			
			first = link;
			return;
		}
		Link tmp = first;
		while(tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = link;
	}
	
	//Find
	public Link find(int data) {
		Link tmp = first;
		
		while(tmp != null) {
			
			if(tmp.info == data) {
				return tmp;
			}
			
			tmp = tmp.next;
		}
		return null;
	}
	
	//delete
	public Link delete(int data) {
		Link prev = first;
		Link curr = first;
		
		while( curr.info != data) {
			
			if(curr.next == null)
				return null;
			else {
				prev = curr;
				curr = curr.next;
			}
		}
		if(curr == first) {
			first = first.next;
		}else {
			prev.next = curr.next;
		}
		return curr;
	}
	
	//Display list
	public int displayList() {
		Link tmp = first;
		while(tmp != null) {
			System.out.print(tmp.info + " ");
			tmp = tmp.next;
		}
		System.out.print("\n");
		if(first == null) {
			return -1;
		}
		return 1;
	}
	
	//Delete first
	public Link deleteFirst() {
		
		if(first == null) {
			return null;
		}
		Link rem = first;
		first = first.next;

		return rem;
	}
}
public class SinglyLinkedList{
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertLast(3);

		list.insertFirst(1);
		list.insertFirst(2);
		list.insertLast(3);
		list.insertLast(4);
		list.displayList();
		list.delete(2);
		list.find(2);
		list.deleteFirst();
		list.displayList();
	}
}