package problemsOfLinkedLists;

import java.util.Random;
import singleLinkedList.Node;
import singleLinkedList.SingleLinkedList;

public class ReverseLinkedList {

	public static void main(String[] args) {
		SingleLinkedList L1 = new SingleLinkedList(20);

		for(int i=0;i<10; i++){
			L1.insertNode(nodeRandom(), posRandom(L1.lengthOfLinkedlist()));
		}
		
		L1.display();
		
		L1 = ReverseList(L1);
		
		L1.display();
		
		L1 = ReverseListPtr(L1);
		
		L1.display();		
		
	}
	
	public static SingleLinkedList ReverseList(SingleLinkedList List){
		SingleLinkedList reverse = new SingleLinkedList();
		Node temp = List.getHead();
		while(temp!=null){
			Node newNode = new Node(temp.getData());
			reverse.insertNode(newNode, 0);
			temp = temp.getNext();
		}
		return reverse;	
	}

	public static SingleLinkedList ReverseListPtr(SingleLinkedList List){
		Node temp = List.getHead();
		Node tempNxt = temp.getNext();
		Node tempPrv = null;
		
		while(tempNxt!=null){
			temp.setNext(tempPrv);
			tempPrv = temp;
			temp = tempNxt;
			tempNxt = tempNxt.getNext();
		}
		temp.setNext(tempPrv);
		tempPrv = temp;
		
		List.setHead(temp);
	
		return List;
	}
	
	
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
}
