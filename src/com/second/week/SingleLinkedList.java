package com.second.week;

import java.util.Stack;

/**
 * 〈单向链表〉<br>
 * 〈〉
 *
 * @author PitterWang
 * @create 2019/11/30
 * @since 1.0.0
 */
public class SingleLinkedList {


	//初始化头节点
	private HeroNode head = new HeroNode(0, "", "");


	public HeroNode getHeroNode(){
		return this.head;
	}
	//添加(在最后节点添加)
	public void add(HeroNode newHeroNode){

		HeroNode temp = head;

		while (true){
			if(temp.nextHeroNode == null){
				break;
			}

			temp = temp.nextHeroNode;
		}

		temp.nextHeroNode = newHeroNode;

	}


	public void addOrderBy(HeroNode newHeroNode){
		HeroNode temp = head;

		boolean isAdd = true;
		while (true){
			if(temp.nextHeroNode == null){
				break;
			}

			if (temp.nextHeroNode.no > newHeroNode.no){
				break;
			}else if(temp.nextHeroNode.no == newHeroNode.no){
				isAdd = false;
				break;
			}

			temp = temp.nextHeroNode;
		}

		if(isAdd){

			newHeroNode.nextHeroNode = temp.nextHeroNode;
			temp.nextHeroNode = newHeroNode;
		}else{
			System.out.println("已存在不能添加");
		}

	}


	public void update(HeroNode newHeroNode){
		HeroNode temp = head;

		if(temp.nextHeroNode == null){
			System.out.println("空链表");
		}

		boolean isUpdate = false;
		while (true){
			if(temp == null){
				break;
			}

			if (temp.no == newHeroNode.no){
				isUpdate = true;
				break;
			}

			temp = temp.nextHeroNode;
		}

		if(isUpdate){
			temp.name = newHeroNode.name;
			temp.nikeName = newHeroNode.nikeName;


		}else{
			System.out.println("不存在");
		}
	}


	public void delete(int no){
		HeroNode temp = head;

		if(temp.nextHeroNode == null){
			System.out.println("空链表");
		}

		boolean isDelete = false;
		while (true){
			if(temp.nextHeroNode == null){
				break;
			}

			if (temp.nextHeroNode.no == no){
				isDelete = true;
				break;
			}

			temp = temp.nextHeroNode;
		}

		if(isDelete){

			temp.nextHeroNode = temp.nextHeroNode.nextHeroNode;


		}else{
			System.out.println("不存在");
		}
	}
	public void list(){
		if(head.nextHeroNode == null){
			System.out.println("空");
			return;
		}
		HeroNode temp = head.nextHeroNode;
		while (true){
			if(temp == null){
				break;
			}
			System.out.println(temp);

			temp = temp.nextHeroNode;
		}
	}

	/**
	 * 获取列表长度
	 * @return
	 */
	public int size(){
		if(head.nextHeroNode == null){
			System.out.println("空");
			return 0;
		}
		HeroNode temp = head.nextHeroNode;
		int lenth = 0;
		while (true){
			if(temp == null){
				break;
			}
			temp = temp.nextHeroNode;
			lenth ++ ;
		}
		return lenth;
	}

	/**
	 * 获取倒数地index的节点
	 * @param index
	 * @return
	 */
	public HeroNode findLastIndexNode(int index){


		if(head.nextHeroNode == null){
			return null;
		}

		int size = this.size();

		if(index <= 0 || index > size){
			return null;
		}

		HeroNode temp = head.nextHeroNode;

		for (int i = 0 ; i < size - index ; i ++){
			temp = temp.nextHeroNode;
		}

		return temp;
	}


	/***
	 * 列表逆序
	 * @return
	 */
	public HeroNode revererNode(){
		HeroNode revererNode = new HeroNode(0, "", "");

		if(head.nextHeroNode == null || head.nextHeroNode.nextHeroNode == null){
			return head;
		}


		HeroNode temp = head.nextHeroNode;

		HeroNode next = null; //指向cur的下一个节点

		while (temp != null){


			next = temp.nextHeroNode;

			temp.nextHeroNode = revererNode.nextHeroNode;

			revererNode.nextHeroNode = temp;

			temp = next;
		}

		head.nextHeroNode = revererNode.nextHeroNode;



		return head;

	}


	public void reversePrint(){
		if(head.nextHeroNode == null){
			return;
		}

		Stack<HeroNode> stack = new Stack<HeroNode>();

		HeroNode temp = head.nextHeroNode;


		while (temp != null){
			stack.add(temp);
			temp = temp.nextHeroNode;
		}

		while (stack.size() > 0){
			System.out.println(stack.pop());
		}
	}

	/***
	 * 合并两个有序单链表(用到递归)
	 * @param a
	 * @param b
	 * @return
	 */
	public  HeroNode mergeList(HeroNode a,HeroNode b) {
		HeroNode result = null;
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		if (a.getNo() <= b.getNo()) {
			result = a;
			result.setNextHeroNode(mergeList(a.getNextHeroNode(), b));
		} else {
			result = b;
			result.setNextHeroNode(mergeList(a, b.getNextHeroNode()));
		}
		return result;
	}
}