package com.mj.mRestaurant.model.vo;

import java.io.Serializable;

public class Menu implements Serializable {

	/**
	 * 식당 메뉴 객체
	 */
	private static final long serialVersionUID = 126L;

	// 필드 변수
	private int mRestaurantNo;
	private int menuName;
	private int menuPrice;

	// 생성자
	public Menu() {
	}

	public Menu(int mRestaurantNo, int menuName, int menuPrice) {
		super();
		this.mRestaurantNo = mRestaurantNo;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}

	// 메소드

	// toString
	@Override
	public String toString() {
		return "Menu [mRestaurantNo=" + mRestaurantNo + ", menuName=" + menuName + ", menuPrice=" + menuPrice + "]";
	}

	// getter & setter
	public int getmRestaurantNo() {
		return mRestaurantNo;
	}

	public void setmRestaurantNo(int mRestaurantNo) {
		this.mRestaurantNo = mRestaurantNo;
	}

	public int getMenuName() {
		return menuName;
	}

	public void setMenuName(int menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

}
