package problemsOfLinkedLists;

import java.util.Random;

import singleLinkedList.Node;
import singleLinkedList.SingleLinkedList;

public class MidList {

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
	
		Node midNode = findMid(L1);
		System.out.println("Mid node "+ midNode.getData());
		
		midNode = findMid(L2);
		System.out.println("Mid node "+ midNode.getData());
		System.out.println("#########################");

		midNode = findmidPtr(L1);
		System.out.println("Mid node "+ midNode.getData());
		
		midNode = findmidPtr(L2);
		System.out.println("Mid node "+ midNode.getData());
		System.out.println("#########################");


	}

	public static Node findMid(SingleLinkedList List){
		Node mid = null;
		if(List != null){
			mid = List.getHead();
			int midNode;
			if(List.lengthOfLinkedlist()%2 ==0){
				midNode = (List.lengthOfLinkedlist()/2)-1;
			}else{
				midNode = (List.lengthOfLinkedlist()/2);
			}
			for(int i=0; i<midNode; i++){
				mid = mid.getNext();
			}
		}
		return mid;
	}

	public static Node findmidPtr(SingleLinkedList List){
		Node mid = null;
		if(List != null){
			mid = List.getHead();
			Node lastNode = List.getHead();
			int count = 0;
			while(lastNode.getNext()!=null){
				if(count%2!=0){
					mid = mid.getNext();
				}
				lastNode = lastNode.getNext();
				count ++;
			}
		}
		
		return mid;
	}
}
