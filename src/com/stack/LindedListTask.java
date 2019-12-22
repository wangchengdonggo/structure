package com.stack;

/**
 * 〈链表模拟栈〉
 *
 * @author PitterWang
 * @create 2019/12/21
 * @since 1.0.0
 */
public class LindedListTask {

	private Node headNode;

	/*public LindedListTask(){
		headNode = new Node();
	}*/


	/**
	 * 链表为空
	 * @return
	 */
	public boolean isEmpty(){
		return headNode == null;
	}

	public void push(Object object){

		Node node = new Node();
		node.setObject(object);

		if(isEmpty()){
			headNode = node;
			return;
		}
		node.setNextNode(headNode);
		headNode = node;
	}


	public Object pop(){
		Object object = null;

		if(isEmpty()){
			System.out.println("队列为空");
			return object;
		}


		object = headNode.getObject();
		headNode = headNode.getNextNode();

		return object;
	}

	public void list(){
		if(isEmpty()){
			System.out.println("空");
			return;
		}
		Node temp = headNode;
		while (true){
			if(temp == null){
				break;
			}
			System.out.println(temp.getObject());

			temp = temp.getNextNode();
		}
	}
}