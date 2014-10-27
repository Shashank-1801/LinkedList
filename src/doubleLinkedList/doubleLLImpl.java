package doubleLinkedList;

import java.util.Random;

public class doubleLLImpl {

	public static void main(String[] args) {

		DoubleLinkedList D1 = new DoubleLinkedList();
		D1.display();
		System.out.println("**********************");
		for(int i=0; i<20; i++){
			D1.insertNode(addRandom(),posRandom(D1.lengthOfLinkedlist()));
			D1.display();
		}
		System.out.println("**********************");

		System.out.println(D1.getHead());
		int posvalue = posRandom(D1.lengthOfLinkedlist());
		System.out.print("Value at : "+ posvalue + " is ");
		System.out.println(D1.getValue(posvalue) + " for the list with lenght "+ D1.lengthOfLinkedlist());

		System.out.println("**********************");
		for(int i=0; i<20; i++){
			D1.deleteNode(posRandom(D1.lengthOfLinkedlist()));
			D1.display();		
		}
		System.out.println("**********************");
		
		DoubleLinkedList D2 = new DoubleLinkedList(2000);
		System.out.println("**********************");
		for(int i=0; i<20; i++){
			D2.insertNode(addRandom(),posRandom(D1.lengthOfLinkedlist()));
			D2.display();		
		}
		System.out.println("**********************");
		
		System.out.println("**********************");
		D2.concatList(D1);
		D1.display();
		D2.display();
		System.out.println("**********************");

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
		int value = (r.nextInt(lenght+3));
		return value;
	}
}
