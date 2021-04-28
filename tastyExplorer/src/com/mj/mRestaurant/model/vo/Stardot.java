package com.mj.mRestaurant.model.vo;

import java.io.Serializable;

public class Stardot implements Serializable {

	/**
	 * 식당 별점 객체
	 */
	private static final long serialVersionUID = 7L;

	// 필드 변수
	private int mRestaurantNo;
	private int stardotCount;
	private int stardotScore;

	// 생성자
	public Stardot() {
	}

	public Stardot(int mRestaurantNo, int stardotCount, int stardotScore) {
		super();
		this.mRestaurantNo = mRestaurantNo;
		this.stardotCount = stardotCount;
		this.stardotScore = stardotScore;
	}

	// 메소드

	// toString
	@Override
	public String toString() {
		return "Stardot [mRestaurantNo=" + mRestaurantNo + ", stardotCount=" + stardotCount + ", stardotScore="
				+ stardotScore + "]";
	}

	// getter & setter
	public int getmRestaurantNo() {
		return mRestaurantNo;
	}

	public void setmRestaurantNo(int mRestaurantNo) {
		this.mRestaurantNo = mRestaurantNo;
	}

	public int getStardotCount() {
		return stardotCount;
	}

	public void setStardotCount(int stardotCount) {
		this.stardotCount = stardotCount;
	}

	public int getStardotScore() {
		return stardotScore;
	}

	public void setStardotScore(int stardotScore) {
		this.stardotScore = stardotScore;
	}

}
