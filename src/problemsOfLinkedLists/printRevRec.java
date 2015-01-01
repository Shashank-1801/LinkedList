package problemsOfLinkedLists;

import java.util.Random;

import singleLinkedList.Node;
import singleLinkedList.SingleLinkedList;

public class printRevRec {

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
		System.out.println("#########################");
		PrintReverse(L1.getHead());
		System.out.println("null");
		System.out.println("#########################");
		PrintReverse(L2.getHead());
		System.out.println("null");
		System.out.println("#########################");

	}
	
	public static void PrintReverse(Node head){
		if(head==null){
			return;
		}
		PrintReverse(head.getNext());
		System.out.print(head.getData() + "->");
	}
}


