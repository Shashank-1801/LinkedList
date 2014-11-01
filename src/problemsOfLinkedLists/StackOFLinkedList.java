package problemsOfLinkedLists;

import singleLinkedList.Node;
import singleLinkedList.SingleLinkedList;

public class StackOFLinkedList {

	SingleLinkedList L1 = new SingleLinkedList();
	
	Node top = L1.getHead();
			
	public StackOFLinkedList() {
		// TODO Auto-generated constructor stub
	}
	
	public void push(int value){
		Node valueNode = new Node(value);
		L1.insertNode(valueNode, 0);		
	}
	
	public Integer pop(){
		if(L1.lengthOfLinkedlist()>0){
			int value = L1.getHead().getData();
			L1.deleteNode(0);
			return value;
		}
		else{
			System.out.println("stack underflow!");
			return null;
		}
	}
	
	public void display(){
		Node temp = L1.getHead();
		while(temp!=null){
			System.out.print(temp.getData() + "->");
			temp = temp.getNext();
		}
		System.out.println("null");
	}
	
	public static void main(String args[]){
		
		StackOFLinkedList stack = new StackOFLinkedList();
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(10000);

		stack.display();
		
		System.out.println("popped out value is: " + stack.pop());
		System.out.println("popped out value is: " + stack.pop());
		System.out.println("popped out value is: " + stack.pop());
		System.out.println("popped out value is: " + stack.pop());
		System.out.println("popped out value is: " + stack.pop());
		
		
	}
	
}
