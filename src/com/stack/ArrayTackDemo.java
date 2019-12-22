package com.stack;

import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author PitterWang
 * @create 2019/12/21
 * @since 1.0.0
 */
public class ArrayTackDemo {

	public static void main(String[] args) {
		/*ArrayTack arrayTack = new ArrayTack(3);

		String key = "";

		Scanner scanner = new Scanner(System.in);

		boolean loop = true;

		while(loop) {

			System.out.println("push");
			System.out.println("pop");
			System.out.println("show");
			System.out.println("exit");

			key = scanner.next(); //获取输入

			switch (key){
				case "push":
					System.out.println("请输入一个数字");
					int value = scanner.nextInt();
					arrayTack.push(value);
					break;
				case "pop":
					try {

						int v = arrayTack.pop();
						System.out.printf("出栈的数据是%d \n", v);
					}catch (Exception e){
						System.out.println(e.getMessage());
					}
					break;
				case "show":

					arrayTack.list();
					break;

				case "exit":
					scanner.close();
					loop = false;
					break;
				default:
					break;
			}

		}
		System.out.println("退出");*/





		LindedListTask lindedListTask = new LindedListTask();

		lindedListTask.push("a");
		lindedListTask.push("b");
		lindedListTask.push("c");
		lindedListTask.list();
		System.out.println("-------------------");
		String a = (String) lindedListTask.pop();
		System.out.println("出栈的数据" + a);
		lindedListTask.list();
	}
}