package problemsOfLinkedLists;

import java.util.Random;
import singleLinkedList.Node;
import singleLinkedList.SingleLinkedList;

public class CyclicLinkedListProblem {

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
		Node last = L2.getHead();
		for(int i=0; i<L2.lengthOfLinkedlist()-1; i++){
			last = last.getNext();
		}
		System.out.println("Last node at " + last.getData());
		last.setNext(nodeRandomfromList(L2));
		
		System.out.println(isCyclic(L1));
		System.out.println(isCyclic(L2));
		
		System.out.println("#########################");
		
	}
	
	public static boolean isCyclic(SingleLinkedList List){
		Node temp = List.getHead();
		int count =0;
		while(temp!=null ){
			temp=temp.getNext();
			Node temp2 = List.getHead();
			for(int i=0; i<count ; i++){
				if(temp == temp2)
					return true;
				else{
					temp2 = temp2.getNext();
				}
			}
			count++;
			
		}
		
		return false;
	}
	
	public static Node nodeRandom(){
		Random r = new Random();
		int value = (r.nextInt())%100;
		Node randomNode = new Node(value);
		//System.out.println("Node returned with value: "+ value);
		return randomNode;
	}

	
	public static Node nodeRandomfromList(SingleLinkedList List){
		Random r = new Random();
		int value = (r.nextInt())%100;
		value = value%List.lengthOfLinkedlist();
		System.out.println("Returned Node is at position " + value);
		Node temp = List.getHead();
		for(int i=0; i <value ; i++){
			temp = temp.getNext();
		}
		System.out.println("Value of the Node is " + temp.getData());
		//System.out.println("Node returned with value: "+ value);
		return temp;
	}
	public static int posRandom(int lenght){
		Random r = new Random();
		int value = (r.nextInt(lenght+2));
		return value;
	}

}
