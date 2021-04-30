package com.mj.review.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Review implements Serializable {

	private static final long serialVersionUID = 1000L;

	private int rNo;
	private String rContent;
	private int rLike;
	private int rUnLike;
	private String rHashTag;
	private char rStatus;
	private int rScore;
	private Date rDate;
	private int mNo;
	private int mRestaurantNo;
	
	public Review() {}

	public Review(int rNo, String rContent, int rLike, int rUnLike, String rHashTag, char rStatus, int rScore,
			Date rDate, int mNo, int mRestaurantNo) {
		super();
		this.rNo = rNo;
		this.rContent = rContent;
		this.rLike = rLike;
		this.rUnLike = rUnLike;
		this.rHashTag = rHashTag;
		this.rStatus = rStatus;
		this.rScore = rScore;
		this.rDate = rDate;
		this.mNo = mNo;
		this.mRestaurantNo = mRestaurantNo;
	}

	@Override
	public String toString() {
		return "Review [rNo=" + rNo + ", rContent=" + rContent + ", rLike=" + rLike + ", rUnLike=" + rUnLike
				+ ", rHashTag=" + rHashTag + ", rStatus=" + rStatus + ", rScore=" + rScore + ", rDate=" + rDate
				+ ", mNo=" + mNo + ", mRestaurantNo=" + mRestaurantNo + "]";
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public int getrLike() {
		return rLike;
	}

	public void setrLike(int rLike) {
		this.rLike = rLike;
	}

	public int getrUnLike() {
		return rUnLike;
	}

	public void setrUnLike(int rUnLike) {
		this.rUnLike = rUnLike;
	}

	public String getrHashTag() {
		return rHashTag;
	}

	public void setrHashTag(String rHashTag) {
		this.rHashTag = rHashTag;
	}

	public char getrStatus() {
		return rStatus;
	}

	public void setrStatus(char rStatus) {
		this.rStatus = rStatus;
	}

	public int getrScore() {
		return rScore;
	}

	public void setrScore(int rScore) {
		this.rScore = rScore;
	}

	public Date getrDate() {
		return rDate;
	}

	public void setrDate(Date rDate) {
		this.rDate = rDate;
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

	public int getmRestaurantNo() {
		return mRestaurantNo;
	}

	public void setmRestaurantNo(int mRestaurantNo) {
		this.mRestaurantNo = mRestaurantNo;
	}

	
	
}
