package com.stack;

/**
 * 〈数组模拟栈>
 * @author PitterWang
 * @create 2019/12/21
 * @since 1.0.0
 */
public class ArrayTack {

	private int maxSize;
	private int[] stack;
	private int top = -1;

	public ArrayTack(int maxSize){
		this.maxSize = maxSize;
		stack = new  int[this.maxSize];
	}

	public boolean isFull(){
		return top == maxSize-1;
	}

	public boolean isEmpty(){
		return top == -1;
	}

	public void push(int value){
		if(isFull()){
			System.out.printf("栈满");
			return;
		}

		top++;
		stack[top] = value;
	}

	public int pop(){
		if(isEmpty()){
			throw new RuntimeException("栈空");
		}
		int value = stack[top];
		top--;
		return value;
	}

	public void list(){
		if(isEmpty()){
			System.out.println("栈空");
			return;
		}

		System.out.println("top = " + top);
		for(int i = top; i>=0; i--){
			System.out.printf(" stack[%d] = %d \n",i, stack[i]);
		}
	}


	/***
	 * 返回当前栈顶
	 */
	public int peek(){
		return stack[top];
	}
}