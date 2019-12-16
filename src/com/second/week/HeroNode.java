package com.second.week;

/**
 * 〈一句话功能简述〉<br>
 * 〈英雄〉
 *
 * @author PitterWang
 * @create 2019/11/30
 * @since 1.0.0
 */
public class HeroNode {

	int no;
	String name;
	String nikeName;
	HeroNode nextHeroNode;
	HeroNode preHeroNode;

	public HeroNode(int no, String name, String nikeName) {
		this.no = no;
		this.name = name;
		this.nikeName = nikeName;
	}

	@Override
	public String toString() {
		return "HeroNode{" +
				"no=" + no +
				", name='" + name + '\'' +
				", nikeName='" + nikeName + '\'' +
				'}';
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNikeName() {
		return nikeName;
	}

	public void setNikeName(String nikeName) {
		this.nikeName = nikeName;
	}

	public HeroNode getNextHeroNode() {
		return nextHeroNode;
	}

	public void setNextHeroNode(HeroNode nextHeroNode) {
		this.nextHeroNode = nextHeroNode;
	}

	public HeroNode getPreHeroNode() {
		return preHeroNode;
	}

	public void setPreHeroNode(HeroNode preHeroNode) {
		this.preHeroNode = preHeroNode;
	}
}