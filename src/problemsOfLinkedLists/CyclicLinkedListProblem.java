package problemsOfLinkedLists;

import java.util.Hashtable;
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

		System.out.println("#########################");

		System.out.println(isCyclic(L1));
		System.out.println(isCyclic(L2));
		
		System.out.println("#########################");

		System.out.println(isCyclicHashTable(L1));
		System.out.println(isCyclicHashTable(L2));
		
		System.out.println("#########################");

		System.out.println(isCyclicFloyd(L1));
		System.out.println(isCyclicFloyd(L2));
		
		System.out.println("#########################");
		
	}
	
	public static boolean isCyclic(SingleLinkedList List){
		Node temp = List.getHead();
		int count =0;
		while(temp!=null ){
			temp=temp.getNext();
			Node temp2 = List.getHead();
			for(int i=0; i<count ; i++){
				if(temp == temp2){
					System.out.println("Cyclic at "+ temp.getData());
					return true;
				}
				else{
					temp2 = temp2.getNext();
				}
			}
			count++;
			
		}
		
		return false;
	}
	
	public static boolean isCyclicFloyd(SingleLinkedList List){
		Node fastptr = List.getHead();
		Node slowptr = List.getHead();
		int count = 1;
		while(fastptr!=null ){
			if(count%2 == 0){
				slowptr = slowptr.getNext();
			}
			fastptr = fastptr.getNext();
			if(fastptr == slowptr){
				Node loop = slowptr.getNext();
				int len = 1;
				while(loop != slowptr){
					loop = loop.getNext();
					len++;
				}
				System.out.println("Lenght of the loop is " + len);
				//loop found, now finding the head of the loop
//				slowptr = List.getHead();
//				while(fastptr!=slowptr){
//					fastptr = fastptr.getNext();
//					slowptr = slowptr.getNext();
//				}
//				System.out.println("Cyclic at "+ fastptr.getData());
				return true;
			}
			count ++;			
		}
		
		return false;
	}
	
	public static boolean isCyclicHashTable(SingleLinkedList List){
		Node temp = List.getHead();
		Hashtable<Integer, Node> hashLinkedList = new Hashtable<Integer, Node>();
		while(temp!=null ){
			hashLinkedList.put(temp.getData(), temp);
			//System.out.println("key = "+ temp.getData() + " and Value = "+ temp + " or " + hashLinkedList.get(temp.getData()) );
			temp=temp.getNext();
			if(temp!=null){
				if(temp == hashLinkedList.get((temp.getData()))){
					System.out.println("Cyclic at "+ temp.getData());
					return true;
				}
			}
									
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
