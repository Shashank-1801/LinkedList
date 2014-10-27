package doubleLinkedList;

public class Node {
	
	//Node class for double linked list
	private int data;
	private Node next = null;
	private Node previous = null;
	
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
	
	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}	
	
	public String toString(){
		return String.valueOf(this.data);
		
	}

}
