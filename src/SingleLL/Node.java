package singleLL;

public class Node {

	//Node class for single linked list
	private int data;
	private Node next = null;
	
	public Node(int data){
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public String toString(){
		return String.valueOf(this.data);
	}

}
