package study.stack; 


/**
 * <pre>
 * study.stack 
 * StackMain.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 6. 21.
 * @author : user
 * @version : v1.0
 */
public class StackMain {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s = new Stack(50);
		for (int i = 0; i < 50; i++) {
			s.push(i);
		}
		while(!s.isEmpty()){
			System.out.println(s.pop());
		}
		}
	}

