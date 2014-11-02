package problemsOfLinkedLists;
import java.util.Random;

import singleLinkedList.*;

public class NthNodeFromEnd {

	public static void main(String[] args) {
		SingleLinkedList L1 = new SingleLinkedList(20);
		
		for(int i=0;i<10; i++){
			L1.insertNode(nodeRandom(), posRandom(L1.lengthOfLinkedlist()));
		}
		
		L1.display();
		
		for(int i=0;i<10; i++){
			int pos = posRandom(L1.lengthOfLinkedlist());
			Node LastNNode = NodefromEnd(L1, pos);
			if(LastNNode != null){
				System.out.println("Last "+ pos+ " node form end is "+ LastNNode);
			}
		}
	}
	
	public static Node NodefromEnd(SingleLinkedList L, int position){
		if(L.lengthOfLinkedlist()<=0){
			System.out.println("Empty Linked List");
			return null;
		}
		else if(position<0 || position > L.lengthOfLinkedlist()){
			System.out.println("Invalid position -> " + position);
			return null;
		}
		else{
			Node NodeN = null;


			Node LastNode=null;

			for(int i=0; i<position; i++){
				Node temp = L.getHead();
				while(temp.getNext()!=LastNode){
					temp = temp.getNext();
				}
				LastNode = temp;

			}
			NodeN = LastNode;

			return NodeN;
		}
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
