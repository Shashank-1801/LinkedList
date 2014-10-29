package doubleLinkedList;

public class DoubleLinkedList {

	private Node headNode = null;

	public DoubleLinkedList() {
		// TODO Auto-generated constructor stub
			headNode=null;
	}

	public DoubleLinkedList(Node headNode){
		this.headNode = headNode;
		headNode.setNext(null);	
		headNode.setPrevious(null);
	}

	public DoubleLinkedList(int value){
		headNode = new Node(value);
		headNode.setNext(null);
		headNode.setPrevious(null);
	}

	public DoubleLinkedList(DoubleLinkedList List2){
		int size = List2.lengthOfLinkedlist();
		if(size == 0 ){
			//do nothing			
		}
		else{
			this.insertNode(List2.getHead(), this.lengthOfLinkedlist());
		}
		
	}
	
	public void concatList(DoubleLinkedList List2){
		try{
			this.insertNode(List2.getHead(), this.lengthOfLinkedlist());
		}catch(Exception ex){
			System.out.println("Error in concatination!");
		}

	}
	
	public void insertNode(Node newNode, int position){
		try{
			int sizeOfLinkedList = lengthOfLinkedlist();	
			//position is invalid
			if( position<0 || position>sizeOfLinkedList ){
				System.out.println("Invalid Position for insertion, insertion failed! at "+ position);
				//headNode will not change
			}

			//inserting when no headNode exists
			else if(headNode == null){
				//System.out.println("No previous List found, insertion failed!");
				//headNode will not change
				headNode = newNode;
			}
			
			//inserting at position 0
			else if(position == 0){
				newNode.setNext(headNode);
				newNode.setPrevious(null);
				//System.out.println("Head node changed, insertion complete!");
				//headNode will change
				headNode=newNode;
			}

			//insert in between nodes
			else{
				Node temp = headNode;
				Node nextToTemp = null;
				for(int pos=0;pos < position-1 ; pos++){
					temp=temp.getNext();
				}
				nextToTemp = temp.getNext();
				newNode.setNext(nextToTemp);
				if(nextToTemp!=null){		//if temp is not the last node
					nextToTemp.setPrevious(newNode);
				}
				temp.setNext(newNode);
				newNode.setPrevious(temp);
				//headNode will not change
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
				if(headNode!=null){
					headNode.setPrevious(null);
				}
			}

			//deletion at other places
			else {
				Node temp = headNode;
				Node nextToTemp = null;
				for(int pos=0; pos<position-1; pos++){
					temp=temp.getNext();
				}
				System.out.println("temp has the value" + temp.getData());
				//temp is the node just before the required node for deletion
				Node delNode = temp.getNext();
				nextToTemp = delNode.getNext();
				// we have .....->temp->delNode->nextToTemp....
				temp.setNext(nextToTemp);
				if(nextToTemp !=null){
					nextToTemp.setPrevious(temp);
				}
				
				delNode = null; //removing the reference of the node
				//System.out.println("deleted node at  "+position+", deletion completed!");
				//headNode will not change
			}		
		}catch(Exception e){
				System.out.println("Error in deletion! :(" + e.getMessage());

			}
	}

	//TODO change the following implementations for DLL
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

	public void update(int newValue, int position){
		try{
			int size = lengthOfLinkedlist();
			//invalid position for deletion
			if(position<0 || position>size-1){
				System.out.println("Invalid position for updating, updating failed! at "+ position);
				//headNode will not change
			}
			else{
				Node temp = headNode;
				for(int pos=0; pos<position; pos++){
					temp=temp.getNext();
				}
				//temp is the required node for update
				temp.setData(newValue);
				//System.out.println("deleted node at  "+position+", deletion completed!");
				//headNode will not change
			}
		}catch(Exception e){
			System.out.println("Some error in updating!");		
		}
	}

	public Integer getValue(int position){
		try{
			int size = lengthOfLinkedlist();
			//invalid position for deletion
			if(position<0 || position>size-1){
				System.out.println("Invalid position, no Node exist! at "+ position);
				//headNode will not change
				return null;
			}
			else{
				Node temp = headNode;
				for(int pos=0; pos<position; pos++){
					temp=temp.getNext();
				}
				//temp is the required node for update
				return temp.getData();
				//headNode will not change
			}
		}catch(Exception e){
			System.out.println("Some error in updating!");		
		}
		return null;
	}

}
