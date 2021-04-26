package com.mj.payment.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Payment implements Serializable {

	private static final long serialVersionUID = 1004L;

	private int pNo;
	private int mNo;
	private int mRestaurantNo;
	private int cNo;
	private int tNo;
	private int pTotalPrice;
	private Date pDate;
	
	public Payment() {}

	public Payment(int pNo, int mNo, int mRestaurantNo, int cNo, int tNo, int pTotalPrice, Date pDate) {
		super();
		this.pNo = pNo;
		this.mNo = mNo;
		this.mRestaurantNo = mRestaurantNo;
		this.cNo = cNo;
		this.tNo = tNo;
		this.pTotalPrice = pTotalPrice;
		this.pDate = pDate;
	}

	@Override
	public String toString() {
		return "Payment [pNo=" + pNo + ", mNo=" + mNo + ", mRestaurantNo=" + mRestaurantNo + ", cNo=" + cNo + ", tNo="
				+ tNo + ", pTotalPrice=" + pTotalPrice + ", pDate=" + pDate + "]";
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
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

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public int gettNo() {
		return tNo;
	}

	public void settNo(int tNo) {
		this.tNo = tNo;
	}

	public int getpTotalPrice() {
		return pTotalPrice;
	}

	public void setpTotalPrice(int pTotalPrice) {
		this.pTotalPrice = pTotalPrice;
	}

	public Date getpDate() {
		return pDate;
	}

	public void setpDate(Date pDate) {
		this.pDate = pDate;
	};
	
	
}