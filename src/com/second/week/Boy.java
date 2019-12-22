package com.second.week;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author PitterWang
 * @create 2019/12/21
 * @since 1.0.0
 */
public class Boy {
	int no;
	Boy nextBoy;

	public Boy(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNextBoy() {
		return nextBoy;
	}

	public void setNextBoy(Boy nextBoy) {
		this.nextBoy = nextBoy;
	}
}