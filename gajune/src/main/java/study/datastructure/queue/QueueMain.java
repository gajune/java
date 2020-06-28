package study.datastructure.queue; 



/**
 * <pre>
 * study.stack 
 * QueueMain.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 6. 28.
 * @author : user
 * @version : v1.0
 */
public class QueueMain {
	public static void main(String[] args) {
		Queue q = new Queue();
		for (int i = 0; i < 50; i++) {
			q.push(i);
		}
		while(!q.isEmpty()){
			System.out.println(q.peek());
		}
		}
	}

