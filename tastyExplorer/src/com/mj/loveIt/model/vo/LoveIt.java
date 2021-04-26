package com.mj.loveIt.model.vo;

import java.io.Serializable;

public class LoveIt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 필드변수
	private int mNo;
	private int mRestaurantNo;
	
	// 생성자
	public LoveIt() {}

	public LoveIt(int mNo, int mRestaurantNo) {
		super();
		this.mNo = mNo;
		this.mRestaurantNo = mRestaurantNo;
	}

	// 메소드
	@Override
	public String toString() {
		return "loveIt [mNo=" + mNo + ", mRestaurantNo=" + mRestaurantNo + "]";
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public int getmRestaurantNo() {
		return mRestaurantNo;
	}

	public void setmRestaurantNo(int mRestaurantNo) {
		this.mRestaurantNo = mRestaurantNo;
	}
	
	
	
	
}
