package SingleLL;

import java.util.Random;

public class singleLLImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Node firstNode = new Node(10);
		
		SingleLinkedList L1 = new SingleLinkedList();
		SingleLinkedList L2 = new SingleLinkedList(20);
		SingleLinkedList L3 = new SingleLinkedList(firstNode);
		L1.display();
		L2.display();
		L3.display();
		
		System.out.println("*************************");
		for(int i=0; i<20; i++){
			L1.insertNode(addRandom(), posRandom(L1.lengthOfLinkedlist()));
			L1.display();
		}
		System.out.println("*************************");

		System.out.println("-------------------------");
		for(int i=0; i<100; i++){
			L1.deleteNode(posRandom(L1.lengthOfLinkedlist()));
			L1.display();
		}
		System.out.println("-------------------------");
		
		System.out.println("*************************");
		for(int i=0; i<20; i++){
			L1.insertNode(addRandom(), posRandom(L1.lengthOfLinkedlist()));
			L1.display();
		}
		System.out.println("*************************");
		
		System.out.println("-------------------------");
		for(int i=0; i<10; i++){
			L1.update(posRandom(100),posRandom(L1.lengthOfLinkedlist()));
			L1.display();
		}
		System.out.println("-------------------------");
		
		System.out.println("*************************");
		for(int i=0; i<20; i++){
			L1.insertNode(addRandom(), posRandom(L1.lengthOfLinkedlist()));
			L1.display();
		}
		System.out.println("*************************");
		
		SingleLinkedList L4 = new SingleLinkedList(L1);
		L4.display();
		System.out.println("Value of the Node at pos 4 is:" + L4.getValue(4));

		L1.concatList(L2);
		L1.concatList(L3);
		L1.display();
		System.out.println("head of linked List is at : "+ L1.getHead().getData());
		System.out.println("head at: "+ L1.getHead());
		
		
		System.out.println("Adding an extra line here!!");
		
	}
	
	public static Node addRandom(){
		Random r = new Random();
		int value = (r.nextInt())%100;
		Node randomNode = new Node(value);
		//System.out.println("Node returned with value: "+ value);
		return randomNode;
	}
	
	public static int posRandom(int lenght){
		Random r = new Random();
		int value = (r.nextInt(lenght+10));
		return value;
	}

}
