package com.first.week;

import java.util.Scanner;

/**
 * 〈数组模拟环形队列〉
 *
 * @author PitterWang
 * @create 2019/11/18
 * @since 1.0.0
 */
public class CircleArrayQueueDemo {

	public static void main(String[] args) {
		CircleArray quear = new CircleArray(4);  //设置4，有效数据最大是3

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

class CircleArray{
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;

	public CircleArray(int arrMaxSize){
		maxSize = arrMaxSize;
		arr = new int[maxSize];

		front = 0; //指向队列头部，队列的第一个位置
		rear = 0;  //队列尾，指向队列尾的的后一个位置
	}

	public boolean isFull(){
		return (rear + 1) % maxSize == front;
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


		arr[rear] = n;
		rear = (rear + 1) % maxSize;
	}

	/**
	 * 出队列
	 * @return
	 */
	public int getQueue(){
		if(isEmpty()){
			throw new RuntimeException("队列空");
		}

		//先把front 对应的值保留到临时变量
		//front 后移
		//将临时保存的变量返回
       int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}

	/**
	 * 显示队列
	 */
	public void showQueue(){
		if(isEmpty()){
			System.out.println("队列空");
			return;
		}


		for (int i = front;i < front + size(); i++){
			System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
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

		return arr [rear];
	}

	//有效数据的个数
	public int size(){
		return (rear + maxSize -front) % maxSize;
	}

}