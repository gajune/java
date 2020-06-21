package study.stack; 

/**
 * <pre>
 * study.stack 
 * Stack.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 6. 21.
 * @author : user
 * @version : v1.0
 */
public class Stack {
	private int MAX_SIZE;
	private int top = -1;
	private int[] stack;
	public Stack(int maxsize) {
		MAX_SIZE = maxsize;
		stack = new int[MAX_SIZE];
	}
	
	public void push(int num) {
		top = top + 1;
		stack[top] = num;
	}
	public int pop() {
		top = top - 1;
		return stack[top+1];
	}
	public boolean isEmpty() {
		if(top == -1){
			return true;
		}
		return false;
	}
	public int size() {
		return top+1;
	}
}
