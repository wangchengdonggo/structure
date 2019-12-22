package com.second.week;

/**
 * 〈环形链表〉
 *
 * @author PitterWang
 * @create 2019/12/21
 * @since 1.0.0
 */
public class CircleSingleLindedList {


	private Boy firstBoy = new Boy(-1);

	public void addBoy(int nums){



		if(nums < 1){
			System.out.println("numsbu正确");
			return;
		}

		Boy curBoy = null; //辅助

		for(int i = 1; i<=nums; i++){

			Boy boy = new Boy(i);
			if(i ==1){

				firstBoy = boy;
				firstBoy.setNextBoy(boy);
				curBoy = boy;
			}else{
				curBoy.setNextBoy(boy);
				boy.setNextBoy(firstBoy);
				curBoy = boy;
			}
		}
	}


	public void showBoy (){
		if(firstBoy == null){
			System.out.println("无人");
			return;
		}

		Boy curBoy = firstBoy;

		while (true){
			System.out.println(curBoy.getNo());

			if(curBoy.getNextBoy() == firstBoy){
				break;
			}
			curBoy = curBoy.nextBoy;
		}
	}



	/***
	 *
	 * @param startNo  开始的编号
	 * @param countNum  数几次
	 * @param nums  几个小孩
	 */
	public void countBoy(int startNo,int countNum,int nums){

		if(firstBoy == null || startNo < 1 || startNo > nums){
			System.out.println("输入有误");
			return;
		}
		Boy helper = firstBoy;
		while (true){
			/**
			 * 指向最后的节点
			 */
			if(helper.getNextBoy() == firstBoy){
				break;
			}
			helper = helper.nextBoy;
		}


		for(int j = 0;j < startNo-1;j++){
			firstBoy = firstBoy.getNextBoy();
			helper = helper.getNextBoy();
		}


		while (true){
			/**
			 * 说明就剩一个小孩
			 */
			if(helper == firstBoy){
				break;
			}

			for (int j = 0;j<countNum-1;j++){
				firstBoy = firstBoy.getNextBoy();
				helper = helper.getNextBoy();
			}

			System.out.printf("小孩%d出圈\n",firstBoy.getNo());

			//将小孩出圈
			firstBoy = firstBoy.getNextBoy();
			helper.setNextBoy(firstBoy);
		}
		System.out.printf("最后出圈的小孩%d \n", firstBoy.getNo());
	}
}