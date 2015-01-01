package problemsOfLinkedLists;

import java.util.Random;

import singleLinkedList.Node;
import singleLinkedList.SingleLinkedList;

public class EvenList {

	public static Node nodeRandom(){
		Random r = new Random();
		int value = (r.nextInt())%100;
		Node randomNode = new Node(value);
		//System.out.println("Node returned with value: "+ value);
		return randomNode;
	}

	public static int posRandom(int lenght){
		Random r = new Random();
		int value = (r.nextInt(lenght+2));
		return value;
	}


	public static void main(String[] args) {
		SingleLinkedList L1 = new SingleLinkedList(100);

		for(int i=0;i<10; i++){
			L1.insertNode(nodeRandom(), posRandom(L1.lengthOfLinkedlist()));
		}
		L1.display();

		SingleLinkedList L2 = new SingleLinkedList();
		for(int i=0;i<10; i++){
			L2.insertNode(nodeRandom(), posRandom(L2.lengthOfLinkedlist()));
		}
		L2.display();

		System.out.println("Is Linked List of even lenght : " + isEven(L1) + " , " + L1.lengthOfLinkedlist());
		System.out.println("Is Linked List of even lenght : " + isEven(L2) + " , " + L2.lengthOfLinkedlist());

	}
	
	public static boolean isEven(SingleLinkedList List){
		Node doublePointer = List.getHead();
		while(doublePointer.getNext() != null && doublePointer.getNext().getNext() != null){
			doublePointer = doublePointer.getNext().getNext();
		}
		
		//starts from 1, 3, 5, 7 ....
		if(doublePointer.getNext() != null){
			return true;
		}else{
			return false;
		}
	}

}
