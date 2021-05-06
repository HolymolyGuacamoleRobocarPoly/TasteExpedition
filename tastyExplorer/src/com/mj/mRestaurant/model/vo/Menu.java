package com.mj.mRestaurant.model.vo;

import java.io.Serializable;
import java.util.Arrays;

public class Menu implements Serializable {

	/**
	 * 식당 메뉴 객체
	 */
	private static final long serialVersionUID = 126L;

	// 필드 변수
	private int mRestaurantNo;
	private String [] menuNames;
	private String [] menuPrices;
	private String menuName;
	private int menuPrice;

	// 생성자
	public Menu() {
	}


	public Menu(int mRestaurantNo, String[] menuNames, String[] menuPrices, String menuName, int menuPrice) {
		super();
		this.mRestaurantNo = mRestaurantNo;
		this.menuNames = menuNames;
		this.menuPrices = menuPrices;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}


	public Menu(int mRestaurantNo, String[] menuNames, String[] menuPrices) {
		super();
		this.mRestaurantNo = mRestaurantNo;
		this.menuNames = menuNames;
		this.menuPrices = menuPrices;
	}

	public Menu(int mRestaurantNo, String menuName, int menuPrice) {
		super();
		this.mRestaurantNo = mRestaurantNo;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}
	
	
	// 메소드

	@Override
	public String toString() {
		return "Menu [mRestaurantNo=" + mRestaurantNo + ", menuNames=" + Arrays.toString(menuNames) + ", menuPrices="
				+ Arrays.toString(menuPrices) + ", menuName=" + menuName + ", menuPrice=" + menuPrice + "]";
	}


	

	// getter & setter
	public int getmRestaurantNo() {
		return mRestaurantNo;
	}





	public void setmRestaurantNo(int mRestaurantNo) {
		this.mRestaurantNo = mRestaurantNo;
	}


	public String[] getMenuNames() {
		return menuNames;
	}


	public void setMenuNames(String[] menuName) {
		this.menuNames = menuName;
	}


	public String[] getMenuPrices() {
		return menuPrices;
	}


	public void setMenuPrices(String[] menuPrice) {
		this.menuPrices = menuPrice;
	}


	public String getMenuName() {
		return menuName;
	}


	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}


	public int getMenuPrice() {
		return menuPrice;
	}


	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}


}
