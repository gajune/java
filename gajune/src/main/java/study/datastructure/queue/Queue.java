package study.datastructure.queue; 



/**
 * <pre>
 * study.stack 
 * Queue.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 6. 28.
 * @author : user
 * @version : v1.0
 */
public class Queue {
	private final int MAX_SIZE = 50;
	private int rear = -1;
	private int front = 0;
	private int[] queue;
	
	public Queue() {
		// TODO Auto-generated constructor stub
		queue = new int[MAX_SIZE];
	}
	
	public void push(int num) {
		rear = rear+1;
		queue[rear] = num;
	}
	
	public int peek() {
		front = front + 1 ;
		return queue[front-1];
	}
	
	public boolean isEmpty(){
		if(front > rear){
			return true;
		}
		return false;
	}
	
	public int size() {
		return rear;
	}

}
