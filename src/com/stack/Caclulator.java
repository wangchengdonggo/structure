package com.stack;

/**
 * 〈一句话功能简述〉<br>
 * 〈计算器〉
 *
 * @author PitterWang
 * @create 2019/12/21
 * @since 1.0.0
 */
public class Caclulator {


	public static void main(String[] args) {
		Caclulator caclulator = new Caclulator();
		System.out.println(caclulator.infixCaclulator("7+2*6-4"));
	}

	public int infixCaclulator(String expression){
		ArrayTack numTack = new ArrayTack(10);
		ArrayTack operTack = new ArrayTack(10);

		int index = 0;

		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;


		char ch = ' ';

		String keepNum = "";
		while (true){
			ch = expression.substring(index,index+1).charAt(0);

			if(isOper(ch)){
				if(!operTack.isEmpty()){
					if(priority(ch) <= priority(operTack.peek())){

						num1 = numTack.pop();
						num2 = numTack.pop();
						oper = operTack.pop();
						res = cal(num1,num2,oper);

						numTack.push(res);
						operTack.push(ch);
					}else{
						operTack.push(ch);
					}
				}else{

					operTack.push(ch);
				}
			}else{


				keepNum += ch;
				//numTack.push(ch-48);

				if(index == expression.length()){

					numTack.push(Integer.parseInt(keepNum));
				}

				if(isOper(expression.substring(index+1,index+2).charAt(0))){
					numTack.push(Integer.parseInt(keepNum));
					keepNum = "";
				}
			}

			index++;
			if(index >= expression.length()){
				break;
			}
		}

		while (true){
			if(operTack.isEmpty()){
				break;
			}
			num1 = numTack.pop();
			num2 = numTack.pop();
			oper = operTack.pop();
			res = cal(num1,num2,oper);

			numTack.push(res);
		}
		return numTack.pop();
	}

	public int priority(int oper){
		int num = 0;
		if(oper == '+' || oper == '-' ){
			num = 0;
		}else if(oper == '*' || oper == '/'){
			num = 1;
		}
		return num;
	}


	public int priority(String oper){
		int num = 0;
		if("+".equals(oper) || "-".equals(oper) ){
			num = 1;
		}else if("*".equals(oper) || "/".equals(oper)){
			num = 2;
		}else{
			System.out.println("不存在的运算符");
		}



		return num;
	}
	/**
	 * 判断是否是符号
	 * @param oper
	 * @return
	 */
	public boolean isOper(int oper){
		return oper == '+' || oper == '-' || oper == '*' || oper == '/';
	}

	/**
	 * 计算
	 * @param nums1
	 * @param nums2
	 * @param oper
	 * @return
	 */
	public int cal(int nums1,int nums2,int oper){
		int res = 0;

		switch (oper){
			case '+' :
				res = nums1 + nums2;
				break;
			case '-' :
				res =  nums2 - nums1;
			break;
			case '*' :
				res =  nums1 * nums2;
			break;
			case '/' :
				res =  nums2 / nums1;
			break;
			default:
				break;
		}
		return res;
	}
}