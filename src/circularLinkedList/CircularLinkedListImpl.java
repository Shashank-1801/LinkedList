package circularLinkedList;

import java.util.Random;

public class CircularLinkedListImpl {

	public static void main(String[] args) {

		CircularLinkedList c1 = new CircularLinkedList();
		c1.display();
		
		CircularLinkedList c2 = new CircularLinkedList(120);
		c2.display();
		
		CircularLinkedList c3 = new CircularLinkedList(addRandom());
		c3.display();
		
		for(int i=0; i<20 ; i++){
			c3.insertNode(addRandom(), posRandom(c3.lenghtOfLinkedList()));
			c3.display();
		}
		System.out.println(c3.lenghtOfLinkedList() + " is the lenght of CLL");
		
		for(int i=0; i<27 ; i++){
			c3.deleteNode(posRandom(c3.lenghtOfLinkedList()));
			c3.display();
		}
		System.out.println(c3.lenghtOfLinkedList() + " is the lenght of CLL after deletion");


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
		//System.out.println("Node returned with value: "+ value);
		return value;
	}

}
