package com.comp.algos;

class Dlink{
	int info;
	Dlink next;
	Dlink prev;
	public Dlink(int info) {
		this.info = info;
	}
	
	
}

public class DoublyLinkedList {
	Dlink first;
	Dlink last;
	public DoublyLinkedList() {
		super();
		this.first = null;
		this.last = null;
	}
	
	//isempty
	public boolean isEmpty() {
		return first==null;
	}
	
	//insertfirst
	public void insertFirst(int data) {
		Dlink link = new Dlink(data);

		if(isEmpty()) {
			last = link;
		}else {
			first.prev = link;
			link.next = first;

		}
		first = link;
	}
	
	//insertlast
	public void insertLast(int data) {
		Dlink link = new Dlink(data);
			
		if(isEmpty()) {
			first = link;
			
		}else {
			last.next = link;
			link.prev = last;

		}	
		last = link;
	}	
	
	//deleteFirst
	public Dlink deleteFirst() {
		
		if(isEmpty())
			return null;
		Dlink tmp = first;
		if(first.next == null)
			last = null;
		else {
			first.next.prev = null;
			
		}
		first = first.next;
		return tmp;
	}
	
	//deleteLast
	public Dlink deleteLast() {
		if(isEmpty())
			return null;
		Dlink tmp = last;
		if(last.prev == null)
			first = null;
		else {
			last.prev.next = null;
			
		}
		last = last.prev;
		return tmp;
	}
	
	//delete
	public Dlink delete(int data) {
		if(isEmpty())
			return null;
		Dlink cur = first;
		while(cur.info != data) {
			
			if(cur.next == null)
				return null;
			
			cur = cur.next;
			
		}
		
		if(cur == first) {
			first = cur.next;
		}else {
			cur.prev.next = cur.next;
		}
		
		
		if(cur == last) {
			last = cur.prev;
		}else {
			cur.next.prev = cur.prev;
		}
				
		return cur;
	}
	
	// -------------------------------------------------------------
	// insert dd just after key
	public boolean insertAfter(int key, int dd)
	{ // (assumes non-empty list)
		Dlink current = first; // start at beginning
		
		
		while(current.info != key) // until match is found,
		{
			current = current.next; // move to next link
			if(current == null)
				return false; // didn’t find it
		}
		
		Dlink newLink = new Dlink(dd); // make new link
		if(current==last) // if last link,
		{
			newLink.next = null; // newLink --> null
			last = newLink; // newLink <-- last
		}
		else // not last link,
		{
			newLink.next = current.next; // newLink --> old next
			// newLink <-- old next
			current.next.prev = newLink;
		}
		newLink.prev = current; // old current <-- newLink
		current.next = newLink; // old current --> newLink
		return true; // found it, did insertion
	}
	// -------------------------------------------------------------
}			
			