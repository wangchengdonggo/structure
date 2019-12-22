package com.second.week;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author PitterWang
 * @create 2019/11/30
 * @since 1.0.0
 */
public class LinkListdDemo {
	public static void main(String[] args) {
		HeroNode heroNode1 = new HeroNode(1,"小王","PJ");

		HeroNode heroNode3 = new HeroNode(3,"小张","HQ");
		HeroNode heroNode2 = new HeroNode(2,"小李","DD");
	    SingleLinkedList singleLinkedList = new SingleLinkedList();
		singleLinkedList.addOrderBy(heroNode1);
		singleLinkedList.addOrderBy(heroNode3);
		singleLinkedList.addOrderBy(heroNode2);



		singleLinkedList.list();
		System.out.println("有效个数节点个数=" +  singleLinkedList.size());


		HeroNode heroNode4= new HeroNode(1,"小王","PJ");

		HeroNode heroNode5 = new HeroNode(4,"小刘","HQ");
		HeroNode heroNode6 = new HeroNode(5,"小狗","DD");
		SingleLinkedList singleLinkedList2 = new SingleLinkedList();
		singleLinkedList2.addOrderBy(heroNode4);
		singleLinkedList2.addOrderBy(heroNode5);
		singleLinkedList2.addOrderBy(heroNode6);

		singleLinkedList2.list();

		System.out.println("有效个数节点个数=" +  singleLinkedList2.size());
		SingleLinkedList s =  new SingleLinkedList();
		HeroNode heroNode = s.mergeList(singleLinkedList.getHeroNode(),singleLinkedList2.getHeroNode());
		s.add(heroNode);

		s.list();

		/*HeroNode newHero = new HeroNode(2,"小赵","ZZ");




		singleLinkedList.update(newHero);
		System.out.println("修改后-------");
		System.out.println("有效个数节点个数=" +  singleLinkedList.size());
		singleLinkedList.list();*/
/*
		singleLinkedList.delete(1);
		System.out.println("删除后-------");
		singleLinkedList.list();
		System.out.println("有效个数节点个数=" +  singleLinkedList.size());

		HeroNode heroNode = singleLinkedList.findLastIndexNode(2);
		System.out.println(heroNode);*/
/*		System.out.println("---------------");
		singleLinkedList.revererNode();
		singleLinkedList.list();*/

/*singleLinkedList.reversePrint();*/




/*
		DoubleLindedList doubleLindedList = new DoubleLindedList();
		doubleLindedList.addOrderBy(heroNode1);
		doubleLindedList.addOrderBy(heroNode3);
		doubleLindedList.addOrderBy(heroNode2);
		doubleLindedList.list();
*/


	/*	System.out.println("更新------------");
		HeroNode newHero = new HeroNode(2,"小赵","ZZ");
		doubleLindedList.update(newHero);
		doubleLindedList.list();
		System.out.println("删除------------");
		doubleLindedList.delete(3);
		doubleLindedList.list();
*/

	}
}