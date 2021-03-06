package problemsOfLinkedLists;

import java.util.Hashtable;
import java.util.Random;
import java.util.Stack;

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
		System.out.println("The list is merged : " + isMerged(L1, L3));
		System.out.println("#########################");
		System.out.println("The list is merged : " + isMergedHashTable(L1, L2));
		System.out.println("The list is merged : " + isMergedHashTable(L1, L3));
		System.out.println("#########################");
		System.out.println("The list is merged : " + isMergedStacks(L1, L2));
		System.out.println("The list is merged : " + isMergedStacks(L1, L3));
		System.out.println("#########################");
		System.out.println("The list is merged : " + isMergedDiff(L1, L2));
		System.out.println("The list is merged : " + isMergedDiff(L1, L3));
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

	
	//method for merged linked list using the diff form 2 lists
	public static boolean isMergedDiff(SingleLinkedList List1, SingleLinkedList List2)
	{
		int len1 = List1.lengthOfLinkedlist();
		int len2 = List2.lengthOfLinkedlist();
		
		Node temp = null;
		int diff;
		Node temp1, temp2;
		if (len1 > len2){
			diff = len1-len2;
			temp = List1.getHead();
			for(int i=0; i<diff; i++){
				temp = temp.getNext();
			}
			temp2 = List2.getHead();
			temp1 = temp;
		}
		else{
			diff = len2 - len1;
			temp = List2.getHead();
			for(int i=0; i<diff; i++){
				temp = temp.getNext();
			}
			temp2 = List1.getHead();
			temp1 = temp;
		}
		
		while(temp1!=null && temp2!=null){
			if(temp1==temp2){
				System.out.println("Merged at " + temp1.getData());
				return true;
			}
			
			temp1 = temp1.getNext();
			temp2 = temp2.getNext();
		}	
		
		
			return false;

	}
	
	
	//method for merged linked list
	public static boolean isMergedStacks(SingleLinkedList List1, SingleLinkedList List2)
	{
		Stack<Node> s1 = new  Stack<>();
		Node temp = List1.getHead();
		for(int i=0; i< List1.lengthOfLinkedlist(); i++){
			s1.push(temp);
			temp = temp.getNext();
		}
		
		Stack<Node> s2 = new  Stack<>();
		temp = List2.getHead();
		for(int i=0; i< List2.lengthOfLinkedlist(); i++){
			s2.push(temp);
			temp = temp.getNext();
		}
		
		int len;
		if(List1.lengthOfLinkedlist() < List2.lengthOfLinkedlist()){
			len = List1.lengthOfLinkedlist();
		}else{
			len = List2.lengthOfLinkedlist();
		}
		
		Node commonNode = null;
		Node temp2 = null;
		int count = 0;
		for(int i=0 ; i< len ; i++){
			temp = (Node)s1.pop();
			temp2 = (Node)s2.pop();
			if(temp == temp2){
				commonNode = temp;
				count++;
			}
			else{
				break;
			}
		}
		
		if(count> 0){
			System.out.println("Merged at " + commonNode.getData());
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isMergedHashTable(SingleLinkedList List1, SingleLinkedList List2)
	{
		Hashtable<Integer, Node> table1 =new Hashtable<>();
	
		Node temp1 = List1.getHead();
		for(int i =0 ; i< List1.lengthOfLinkedlist();i++){
			table1.put(temp1.getData(), temp1);
			temp1 = temp1.getNext();
		}
		
		//look for a node in List2 which corresponds to a same node data and same address in Hash Table
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
