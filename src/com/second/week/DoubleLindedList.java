package com.second.week;

/**
 * 〈一句话功能简述〉<br>
 * 〈双向列表〉
 *
 * @author PitterWang
 * @create 2019/11/30
 * @since 1.0.0
 */
public class DoubleLindedList {

	//初始化头节点
	private HeroNode head = new HeroNode(0, "", "");

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

		newHeroNode.preHeroNode = temp;

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
			newHeroNode.preHeroNode = temp;
			newHeroNode.nextHeroNode = temp.nextHeroNode;

			if(temp.nextHeroNode != null){
				temp.nextHeroNode.preHeroNode = newHeroNode;
			}
			temp.nextHeroNode = newHeroNode;
		}else{
			System.out.println("已存在不能添加");
		}

	}


	public void update(HeroNode newHeroNode) {
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
		HeroNode temp = head.nextHeroNode;

		if(temp == null){
			System.out.println("空链表");
		}

		boolean isDelete = false;

		while (true){
			if(temp == null){
				break;
			}

			if (temp.no == no){
				isDelete = true;
				break;
			}

			temp = temp.nextHeroNode;
		}

		if(isDelete){

			if(temp.nextHeroNode != null){
				temp.nextHeroNode.preHeroNode = temp.preHeroNode;

			}
			temp.preHeroNode.nextHeroNode = temp.nextHeroNode;

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
}