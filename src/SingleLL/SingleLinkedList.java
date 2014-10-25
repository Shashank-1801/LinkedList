package SingleLL;


public class SingleLinkedList {

	private Node headNode = null;

	//TODO change the way headNode is being implemented
	public SingleLinkedList(){
		headNode=null;
	}

	public SingleLinkedList(Node headNode){
		this.headNode = headNode;
		headNode.setNext(null);		
	}

	public SingleLinkedList(int value){
		headNode = new Node(value);
		headNode.setNext(null);		
	}

	public void insertNode(Node newNode, int position){
		try{
			int sizeOfLinkedList = lengthOfLinkedlist();	
			//position is invalid
			if( position<0 || position>sizeOfLinkedList ){
				System.out.println("Invalid Position for insertion, insertion failed! at "+ position);
				//headNode will not change
			}

			//inserting at position 0
			else if(position == 0){
				newNode.setNext(headNode);
				//System.out.println("Head node changed, insertion complete!");
				//headNode will change
				headNode=newNode;
			}

			//inserting when no headNode exists
			else if(headNode == null){
				//System.out.println("No previous List found, insertion failed!");
				//headNode will not change
			}		

			//insert in between nodes
			else{
				Node temp = headNode;
				for(int pos=0;pos < position-1 ; pos++){
					temp=temp.getNext();
				}
				newNode.setNext(temp.getNext());
				temp.setNext(newNode);
				//System.out.println("new node inserted at "+ position +", insertion complete!");
			}
		}catch(Exception e){
			System.out.println("Error in insertion! :(" + e.getMessage());

		}
	}

	public void deleteNode(int position){
		try{
			int size = lengthOfLinkedlist();
			//invalid position for deletion
			if(position<0 || position>size-1){
				System.out.println("Invalid position for deletion, deletion failed! at "+ position);
				//headNode will not change
			}

			//deletion of head node
			else if(position==0){
				//headNode will change
				headNode = headNode.getNext();
			}

			//deletion at other places
			else {
				Node temp = headNode;
				for(int pos=0; pos<position-1; pos++){
					temp=temp.getNext();
				}
				//temp is the node just before the required node for deletion
				Node delNode = temp.getNext();
				temp.setNext(delNode.getNext());
				//System.out.println("deleted node at  "+position+", deletion completed!");
				//headNode will not change
			}		
		}catch(Exception e){
				System.out.println("Error in deletion! :(" + e.getMessage());

			}
	}

	public int lengthOfLinkedlist(){
		Node temp= headNode;
		int size = 0;
		while(temp != null){
			size++;
			temp = temp.getNext();
		}
		return size;
	}

	public boolean isEmpty(){
		if(lengthOfLinkedlist()>0){
			return false;
		}
		else{
			return true;
		}
	}

	public void display(){
		if(!isEmpty()){
			//System.out.println("Contents of the linked list are:");
			Node temp = headNode;
			while(temp!=null){
				System.out.print(temp.getData() + "->");
				temp=temp.getNext();
			}
			System.out.println("null");
		}else{
			System.out.println("Linked List is empty");		
		}
	}

	public Node getHead(){
		return headNode;
	}


}
