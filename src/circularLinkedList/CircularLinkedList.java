package circularLinkedList;

public class CircularLinkedList {
	
	private Node headNode = null;
	
	public CircularLinkedList() {
		headNode = null;
	}

	public CircularLinkedList(int value) {
		headNode = new Node(value);
		headNode.setNext(headNode);
	}
	
	public CircularLinkedList(Node someNode) {
		headNode = someNode;
		headNode.setNext(headNode);
	}
	
	public CircularLinkedList(CircularLinkedList cLL) {
		headNode = cLL.getHead();
	}
	
	public Node getHead() {
		return headNode;
	}
	
	public int lenghtOfLinkedList(){
		Node temp = headNode;
		if (temp==null){
			return 0;
		}
		else{
			int lenght = 0;
			while(temp!=null){
				temp = temp.getNext();
				lenght++;
				if(temp == headNode){
					break;
				}
			}
			 return lenght;
		}
	}
	
	public void display(){
		Node temp = headNode;
		if (isEmpty()){
			System.out.println("List is empty!");
		}
		else if(temp.getNext()==headNode){
			System.out.println(headNode.getData());
		}
		
		else{
			for(int i=0; i<lenghtOfLinkedList(); i++){
				System.out.print(temp.getData() + "->");
				temp = temp.getNext();
			}
			System.out.println("headNode("+ headNode.getData()+")");
		}
	}


	public boolean isEmpty() {
		if(headNode==null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void insertNode(Node newNode, int position){
		//invalid position
		if(position < 0 || position > lenghtOfLinkedList()){
			System.out.println("Invalid position for insertion! at "+ position);
		}
		//invalid newNode 
		else if(newNode==null){
			System.out.println("Node to be inserted is null!");
		}
		//if LL is empty
		else if(isEmpty()){
			headNode = newNode;
			headNode.setNext(headNode);
		}
		//insertion at position 0
		else if(position==0){
			Node lastNode = null;
			Node temp = headNode;
			while(temp!=null){
				temp = temp.getNext();
				if(temp.getNext()==headNode){
					break;
				}
			}
			//temp will be the last node
			lastNode = temp;
			newNode.setNext(headNode);
			lastNode.setNext(newNode);
			headNode = newNode;
		}
		
		//rest cases
		else{
			Node temp = headNode;
			for(int i=0; i<position-1 ; i++){
				temp=temp.getNext();
			}
			//temp is the node after which insertion will occur
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
		}
	}
	
	public void deleteNode(int position){
		//if position is valid
		int lenght = lenghtOfLinkedList();
		if(position < 0 || position > lenght-1){
			System.out.println("Invalid position for deletion! at "+ position);
		}
		//deletion when list has only one node
		else if(lenghtOfLinkedList()==1){
			headNode = null;
		}
		
		//deletion on 0th position
		else if(position==0){
			Node lastNode= headNode;
			while(lastNode.getNext()!= headNode){
				lastNode = lastNode.getNext();
			}
			lastNode.setNext(headNode.getNext());
			Node delNode = headNode;
			headNode = headNode.getNext();
			delNode = null;
		}
		
		//valid deletions
		else{
			Node temp = headNode;
			for(int i=0; i<position-1; i++){
				temp=temp.getNext();
			}
			//temp is the node before the node to be deleted.
			Node delNode = temp.getNext();
			temp.setNext(delNode.getNext());			
			delNode = null;
		}
	}
	

}
