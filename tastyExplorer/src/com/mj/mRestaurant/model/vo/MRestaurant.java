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
	private String mRestaurantAdrress;
	private String mRestaurantInfo;
	private char mRestaurantStatus;
	private char mRestaurantConfirm;
	private int mRestaurantLevel;
	private int mRestaurantLike;
	private String mRestaurantTel;
	// 추가 변수 
	private String openTime;
	private String brTime;
	private String holiday;
	
	
	// 생성자
	public MRestaurant() {}
	
	public MRestaurant(int mRestaurantNo, String mRestaurantTitle, String mRestaurantContent, String mRestaurantAdrress,
			String mRestaurantInfo, char mRestaurantStatus, char mRestaurantConfirm, int mRestaurantLevel,
			int mRestaurantLike, String mRestaurantTel, String openTime, String brTime, String holiday) {
		super();
		this.mRestaurantNo = mRestaurantNo;
		this.mRestaurantTitle = mRestaurantTitle;
		this.mRestaurantContent = mRestaurantContent;
		this.mRestaurantAdrress = mRestaurantAdrress;
		this.mRestaurantInfo = mRestaurantInfo;
		this.mRestaurantStatus = mRestaurantStatus;
		this.mRestaurantConfirm = mRestaurantConfirm;
		this.mRestaurantLevel = mRestaurantLevel;
		this.mRestaurantLike = mRestaurantLike;
		this.mRestaurantTel = mRestaurantTel;
		this.openTime = openTime;
		this.brTime = brTime;
		this.holiday = holiday;
	}

	// 메소드 


	@Override
	public String toString() {
		return "MRestaurant [mRestaurantNo=" + mRestaurantNo + ", mRestaurantTitle=" + mRestaurantTitle
				+ ", mRestaurantContent=" + mRestaurantContent + ", mRestaurantAdrress=" + mRestaurantAdrress
				+ ", mRestaurantTel=" + mRestaurantTel + ", mRestaurantInfo=" + mRestaurantInfo + ", mRestaurantLike="
				+ mRestaurantLike + ", mRestaurantStatus=" + mRestaurantStatus + ", mRestaurantConfirm="
				+ mRestaurantConfirm + ", mRestaurantLevel=" + mRestaurantLevel + "]";
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

	public int getmRestaurantLevel() {
		return mRestaurantLevel;
	}

	public void setmRestaurantLevel(int mRestaurantLevel) {
		this.mRestaurantLevel = mRestaurantLevel;
	}

	public String getmRestaurantAdrress() {
		return mRestaurantAdrress;
	}

	public void setmRestaurantAdrress(String mRestaurantAdrress) {
		this.mRestaurantAdrress = mRestaurantAdrress;
	}

	public String getmRestaurantTel() {
		return mRestaurantTel;
	}

	public void setmRestaurantTel(String mRestaurantTel) {
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

	public char getmRestaurantConfirm() {
		return mRestaurantConfirm;
	}

	public void setmRestaurantConfirm(char mRestaurantConfirm) {
		this.mRestaurantConfirm = mRestaurantConfirm;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getBrTime() {
		return brTime;
	}

	public void setBrTime(String brTime) {
		this.brTime = brTime;
	}

	public String getHoliday() {
		return holiday;
	}

	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}
	
	
}
