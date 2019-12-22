package com.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 〈一句话功能简述〉<br>
 * 〈波兰表达式〉
 *
 * @author PitterWang
 * @create 2019/12/21
 * @since 1.0.0
 */
public class PolandNotation {


	public static void main(String[] args) {
		String express = "1+((2+3)*4)-5";

		List<String> list = toIndixExpressionList(express);

		System.out.println(list);
		List<String> parseSuffix = parseSuffix(list);
		System.out.println(parseSuffix);

		System.out.println(suffixCaclulator(parseSuffix));

	}
	public static List<String> getList(String expression){
		String[] sp = expression.split(" ");
		List<String> list = new ArrayList<>();

		for (String s : sp){
			list.add(s);
		}
		return list;
	}


	/**
	 * 后缀表达式计算
	 * @param list
	 * @return
	 */
	public static int suffixCaclulator(List<String> list){
		Stack<String> stack = new Stack<>();

		for (String item: list){
			if(item.matches("\\d+")){
				stack.push(item);
			}else {
				int num2 = Integer.parseInt(stack.pop());
				int num1 = Integer.parseInt(stack.pop());
				int res = 0;

				if(item.equals("+")){

					res = num1 + num2;
				}else if(item.equals("-")){
					res = num1 - num2;
				}else if(item.equals("*")){
					res = num1 * num2;
				}else if(item.equals("/")){
					res = num1 / num2;
				}else {
					throw new RuntimeException("YUNSUANFUCUOLE");
				}
				stack.push("" + res);
			}
		}

		return Integer.valueOf(stack.pop());
	}

	/***
	 * 将后缀表达式的值转到list里
	 * @param s
	 * @return
	 */
	public static List<String> toIndixExpressionList(String s){

		List<String> ls = new ArrayList<>();
		int i = 0;
		String str;
		char c;

		do {
			//如果c式一个非数字，就加入到list
			if((c=s.charAt(i))<48||(c=s.charAt(i))>57){
				ls.add(c+"");
				i++;
			}else{
				str  ="";
				while (i<s.length() && (c=s.charAt(i))>=48 && (c=s.charAt(i))<=57){
					str += c;
					i++;
				}
				ls.add(str);

			}
		}while (i<s.length());

		return ls;
	}

	/***
	 * 将中缀的list转为后缀list
	 * @param list
	 * @return
	 */
	public static List<String> parseSuffix(List<String> list){

		Caclulator caclulator = new Caclulator();
		Stack<String> s1 = new Stack<>();

		List<String> s2 = new ArrayList<>();

		for(String item: list){
			if(item.matches("\\d+")){

				s2.add(item);
			}else if(item.equals("(")){

				s1.push(item);
			}else if(item.equals(")")){

				while (!s1.peek().equals("(")){
					s2.add(s1.pop());

				}
				s1.pop();
			}else{
				while(s1.size() !=0 && (caclulator.priority(s1.peek()) >= caclulator.priority(item))){

					s2.add(s1.pop());
				}
				s1.push(item);
			}


		}

		while (s1.size() != 0){
			s2.add(s1.pop());
		}


		return s2;
 	}



}