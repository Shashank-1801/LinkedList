package problemsOfLinkedLists;

import java.util.Random;

import singleLinkedList.Node;
import singleLinkedList.SingleLinkedList;

public class SortedLinkedList {

	public static void main(String[] args) {

		SingleLinkedList L1 = new SingleLinkedList();
		
		for(int i=0; i<10; i++){
			L1 = insertSorted(L1, nodeRandom());
			L1.display();
			}
		
	}
	
	public static SingleLinkedList insertSorted(SingleLinkedList List, Node inNode){
		if(List.getHead() == null){
			List.insertNode(inNode, 0);
		}
		else if(inNode == null){
			System.out.println("Invalid node for insertion");		
		}
		else if(inNode.getData() < List.getHead().getData()){
			inNode.setNext(List.getHead());
			List.setHead(inNode);
		}
		else{
			//System.out.println("New Node is being inserted with a value of " + inNode.getData());
			Node temp = List.getHead();
			while(temp.getNext()!=null && inNode.getData() > temp.getData()){
					temp = temp.getNext();
			}
			if(temp.getNext()==null){
				if(inNode.getData()> temp.getData()){
					inNode.setNext(temp.getNext());
					temp.setNext(inNode);
				}
				else{
					Node lastToTemp = List.getHead();
					while(lastToTemp.getNext() != temp){
						lastToTemp = lastToTemp.getNext();
					}
					lastToTemp.setNext(inNode);
					inNode.setNext(temp);
				}
			}
			else{
				Node lastToTemp = List.getHead();
				while(lastToTemp.getNext() != temp){
					lastToTemp = lastToTemp.getNext();
				}
				lastToTemp.setNext(inNode);
				inNode.setNext(temp);
			}
			
		}
//		else{
//			System.out.println("New Node is being inserted with a value of " + inNode.getData());
//			Node temp = List.getHead();
//			while(temp.getNext()!=null){
//				if(inNode.getData() > temp.getData()){
//					temp = temp.getNext();
//				}
//				else{
//					break;
//				}
//			}
//			if(inNode.getData() < temp.getData() && temp.getNext() == null){
//				List.insertNode(inNode, 0);
//			}
//			inNode.setNext(temp.getNext());
//			temp.setNext(inNode);
//
//		}

		return List;
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
