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
//		if(value==0){
//			value=1;
//		}
		//System.out.println("position generated is: "+ value);
		return value;
	}

}
