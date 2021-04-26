package com.mj.mRestaurant.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Ticket implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 필드변수
	private int tNo;
	private Date tDuration;
	private Date tDate;
	private String tContent;
	private String tTitle;
	private char tStatus;
	private int mNo;
	
	// 생성자
	public Ticket() {}
	
	public Ticket(int tNo, Date tDuration, Date tDate, String tContent, String tTitle, char tStatus, int mNo) {
		super();
		this.tNo = tNo;
		this.tDuration = tDuration;
		this.tDate = tDate;
		this.tContent = tContent;
		this.tTitle = tTitle;
		this.tStatus = tStatus;
		this.mNo = mNo;
	}

	// 메소드
	@Override
	public String toString() {
		return "Ticket [tNo=" + tNo + ", tDuration=" + tDuration + ", tDate=" + tDate + ", tContent=" + tContent
				+ ", tTitle=" + tTitle + ", tStatus=" + tStatus + ", mNo=" + mNo + "]";
	}

	public int gettNo() {
		return tNo;
	}

	public void settNo(int tNo) {
		this.tNo = tNo;
	}

	public Date gettDuration() {
		return tDuration;
	}

	public void settDuration(Date tDuration) {
		this.tDuration = tDuration;
	}

	public Date gettDate() {
		return tDate;
	}

	public void settDate(Date tDate) {
		this.tDate = tDate;
	}

	public String gettContent() {
		return tContent;
	}

	public void settContent(String tContent) {
		this.tContent = tContent;
	}

	public String gettTitle() {
		return tTitle;
	}

	public void settTitle(String tTitle) {
		this.tTitle = tTitle;
	}

	public char gettStatus() {
		return tStatus;
	}

	public void settStatus(char tStatus) {
		this.tStatus = tStatus;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	
	
	
}
