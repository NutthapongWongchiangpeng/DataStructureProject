package AmusementPark;

public class LinkedQueue {
	
	MyNode head,tail,tmp;
	int size;
	
	public LinkedQueue(){
		head = null;
		tail = null;
		size = 0;
	}
	
	public void enqueue(Object e) throws Exception{
		MyNode NewNode = new MyNode(e,null);
		if(isEmpty()){
			head = NewNode;
		}
		else{
			tail.setNextNode(NewNode);
		}
		tail = NewNode;
		size++;
	}
	
	public Object dequeue() throws Exception{
		Object obj;
		obj = head.getData();
		head = head.getNextNode();
		size--;
		return obj;
	}
	
	public Object front() throws Exception{
		return head.getData();
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public boolean isFull(){
		return false;
	}
	
	public void clear(){
		size = 0;
		head = null;
		tail = null;
	}
	
	public int size(){
		return size;
	}
	
	//find next queue//
	public Object next(){
		tmp = head.getNextNode();
		return tmp.getData();
	}
}
