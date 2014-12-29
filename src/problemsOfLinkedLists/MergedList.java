package problemsOfLinkedLists;

import java.util.Hashtable;
import java.util.Random;

import singleLinkedList.Node;
import singleLinkedList.SingleLinkedList;

public class MergedList {

	/**
	 * @param args
	 */
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
	
		//get the last node form list2 
		Node last = L2.getHead();
		for(int i=0; i<L2.lengthOfLinkedlist()-1; i++){
			last = last.getNext();
		}
		System.out.println("Last node of L2 is at " + last.getData());
		
		//join the last node of L2 to some random node at L1
		last.setNext(nodeRandomfromList(L1));

		L2.display();

		SingleLinkedList L3 = new SingleLinkedList();

		for(int i=0;i<10; i++){
			L3.insertNode(nodeRandom(), posRandom(L3.lengthOfLinkedlist()));
		}
		L3.display();
		
		System.out.println("#########################");
		System.out.println("The list is merged : " + isMerged(L1, L2));
		System.out.println("#########################");
		System.out.println("The list is merged : " + isMerged(L1, L3));
		System.out.println("#########################");
		System.out.println("The list is merged : " + isMergedHashTable(L1, L2));
		System.out.println("#########################");
		System.out.println("The list is merged : " + isMergedHashTable(L1, L3));
		System.out.println("#########################");
	}
	
	public static boolean isMerged(SingleLinkedList List1, SingleLinkedList List2)
	{
		Node temp1 = List1.getHead();
		for(int i =0 ; i< List1.lengthOfLinkedlist();i++)
		{
			Node temp2 = List2.getHead();

			for(int j =0; j<List2.lengthOfLinkedlist(); j++){
				if(temp2==temp1){
					System.out.println("Merged at " + temp1.getData());
					return true;
				}
				temp2 = temp2.getNext();
			}
			temp1 = temp1.getNext();
		}
		
		return false;
		
	}

	
	public static boolean isMergedHashTable(SingleLinkedList List1, SingleLinkedList List2)
	{
		Hashtable<Integer, Node> table1 =new Hashtable<>();
		Hashtable<Integer, Node> table2 =new Hashtable<>();
		
		Node temp1 = List1.getHead();
		for(int i =0 ; i< List1.lengthOfLinkedlist();i++){
			table1.put(temp1.getData(), temp1);
			temp1 = temp1.getNext();
		}
		
		Node temp2 = List2.getHead();
		for(int x =0 ; x < List2.lengthOfLinkedlist(); x++){
			Node temp = table1.get(temp2.getData());
			if(temp!= null){
				if(temp == temp2){
					System.out.println("Merged at " + temp2.getData());
					return true;
				}
			}
			temp2 = temp2.getNext();
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
