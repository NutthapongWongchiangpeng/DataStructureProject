package AmusementPark;

public class MyNode {
	
	private Object data;
	private MyNode nextNode;
	
	MyNode(Object object){
		this(object,null);
	}
	
	MyNode(Object object,MyNode node){
		data=object;
		nextNode=node;
	}
	
	public void setNextNode(MyNode node){
		nextNode=node;
	}
	
	public MyNode getNextNode(){
		return nextNode;
	}
	
	public void setData(Object object){
		data=object;
	}
	
	public Object getData(){
		return data;
	}
}
