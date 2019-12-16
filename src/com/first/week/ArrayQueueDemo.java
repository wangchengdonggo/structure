package com.first.week;

import java.util.Scanner;

/**
 * 〈数组模拟队列〉
 *
 * @author PitterWang
 * @create 2019/11/18
 * @since 1.0.0
 */
public class ArrayQueueDemo {


	public static void main(String[] args) {
		ArrayQuear quear = new ArrayQuear(3);

		char key = ' ';

		Scanner scanner = new Scanner(System.in);

		boolean loop = true;

		while(loop) {

			System.out.println("show");
			System.out.println("add");

			System.out.println("get");

			System.out.println("head");

			System.out.println("exit");

			key = scanner.next().charAt(0); //获取输入

			switch (key){
				case 's':
					quear.showQueue();
					break;
				case 'a':
					System.out.println("请输入一个数");

					int value = scanner.nextInt();

					quear.addQueue(value);
					break;
				case 'g':

					try {

						int res = quear.getQueue();
						System.out.println(res);
					}catch (Exception e){
						System.out.println(e.getMessage());

					}
					break;
				case 'h':
					try {

						int res = quear.headQueue();
						System.out.println(res);
					}catch (Exception e){

						System.out.println(e.getMessage());
					}
					break;
				case 'e':
					scanner.close();
					loop = false;
					break;
				default:
					break;
			}

		}
	}

}

class ArrayQuear{

	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;

	public ArrayQuear(int arrMaxSize){
		maxSize = arrMaxSize;
		arr = new int[maxSize];

		front = -1; //指向队列头部，队列头的前一个位置
		rear = -1;  //队列尾，指向队列尾的数据
	}

	public boolean isFull(){
		return rear == maxSize -1;
	}

	public boolean isEmpty(){
		return rear == front;
	}


	/**
	 * 入队列
	 * @param n
	 */
	public  void addQueue(int n){
		if(isFull()){
			System.out.println("队列满");
			return;
		}

		rear ++;
		arr [rear] = n;
	}

	/**
	 * 出队列
	 * @return
	 */
	public int getQueue(){
		if(isEmpty()){
			throw new RuntimeException("队列空");
		}

		front++;
		return arr[front];
	}

	/**
	 * 显示队列
	 */
	public void showQueue(){
		if(isEmpty()){
			System.out.println("队列空");
			return;
		}

		for (int i = 0;i<arr.length;i++){
			System.out.println(i + "" + arr[i]);
		}
	}

	/***
	 * 获取队列头
	 * @return
	 */
	public int headQueue(){
		if(isEmpty()){
			throw new RuntimeException("队列空");

		}

		return arr [rear + 1];
	}

}