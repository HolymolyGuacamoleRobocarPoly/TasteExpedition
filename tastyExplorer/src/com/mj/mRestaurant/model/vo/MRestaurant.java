package com.mj.mRestaurant.model.vo;

import java.io.Serializable;

public class MRestaurant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 필드변수
	private int mRestaurantNo;
	private String mRestaurantTitle;
	private String mRestaurantContent;
	private char mRestaurantLevel;
	private String mRestaurantAdrress;
	private int mRestaurantTel;
	private String mRestaurantInfo;
	private int mRestaurantLike;
	private char mRestaurantStatus;
	
	// 생성자
	public MRestaurant() {}
	
	public MRestaurant(int mRestaurantNo, String mRestaurantTitle, String mRestaurantContent, char mRestaurantLevel,
			String mRestaurantAdrress, int mRestaurantTel, String mRestaurantInfo, int mRestaurantLike,
			char mRestaurantStatus) {
		super();
		this.mRestaurantNo = mRestaurantNo;
		this.mRestaurantTitle = mRestaurantTitle;
		this.mRestaurantContent = mRestaurantContent;
		this.mRestaurantLevel = mRestaurantLevel;
		this.mRestaurantAdrress = mRestaurantAdrress;
		this.mRestaurantTel = mRestaurantTel;
		this.mRestaurantInfo = mRestaurantInfo;
		this.mRestaurantLike = mRestaurantLike;
		this.mRestaurantStatus = mRestaurantStatus;
	}

	// 메소드
	@Override
	public String toString() {
		return "MRestaurant [mRestaurantNo=" + mRestaurantNo + ", mRestaurantTitle=" + mRestaurantTitle
				+ ", mRestaurantContent=" + mRestaurantContent + ", mRestaurantLevel=" + mRestaurantLevel
				+ ", mRestaurantAdrress=" + mRestaurantAdrress + ", mRestaurantTel=" + mRestaurantTel
				+ ", mRestaurantInfo=" + mRestaurantInfo + ", mRestaurantLike=" + mRestaurantLike
				+ ", mRestaurantStatus=" + mRestaurantStatus + "]";
	}

	public int getmRestaurantNo() {
		return mRestaurantNo;
	}

	public void setmRestaurantNo(int mRestaurantNo) {
		this.mRestaurantNo = mRestaurantNo;
	}

	public String getmRestaurantTitle() {
		return mRestaurantTitle;
	}

	public void setmRestaurantTitle(String mRestaurantTitle) {
		this.mRestaurantTitle = mRestaurantTitle;
	}

	public String getmRestaurantContent() {
		return mRestaurantContent;
	}

	public void setmRestaurantContent(String mRestaurantContent) {
		this.mRestaurantContent = mRestaurantContent;
	}

	public char getmRestaurantLevel() {
		return mRestaurantLevel;
	}

	public void setmRestaurantLevel(char mRestaurantLevel) {
		this.mRestaurantLevel = mRestaurantLevel;
	}

	public String getmRestaurantAdrress() {
		return mRestaurantAdrress;
	}

	public void setmRestaurantAdrress(String mRestaurantAdrress) {
		this.mRestaurantAdrress = mRestaurantAdrress;
	}

	public int getmRestaurantTel() {
		return mRestaurantTel;
	}

	public void setmRestaurantTel(int mRestaurantTel) {
		this.mRestaurantTel = mRestaurantTel;
	}

	public String getmRestaurantInfo() {
		return mRestaurantInfo;
	}

	public void setmRestaurantInfo(String mRestaurantInfo) {
		this.mRestaurantInfo = mRestaurantInfo;
	}

	public int getmRestaurantLike() {
		return mRestaurantLike;
	}

	public void setmRestaurantLike(int mRestaurantLike) {
		this.mRestaurantLike = mRestaurantLike;
	}

	public char getmRestaurantStatus() {
		return mRestaurantStatus;
	}

	public void setmRestaurantStatus(char mRestaurantStatus) {
		this.mRestaurantStatus = mRestaurantStatus;
	}
	
	
}
