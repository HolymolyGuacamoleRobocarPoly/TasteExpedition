package com.mj.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Coupon implements Serializable {
	
	private static final long serialVersionUID = 1006;
	
	private int cNo;
	private int cDuration;
	private Date cDate;
	private Date cContent;
	private String cTitle;
	private String cStatus;
	private char mNo;
	
	public Coupon() {}

	public Coupon(int cNo, int cDuration, Date cDate, Date cContent, String cTitle, String cStatus, char mNo) {
		super();
		this.cNo = cNo;
		this.cDuration = cDuration;
		this.cDate = cDate;
		this.cContent = cContent;
		this.cTitle = cTitle;
		this.cStatus = cStatus;
		this.mNo = mNo;
	}

	@Override
	public String toString() {
		return "Coupon [cNo=" + cNo + ", cDuration=" + cDuration + ", cDate=" + cDate + ", cContent=" + cContent
				+ ", cTitle=" + cTitle + ", cStatus=" + cStatus + ", mNo=" + mNo + "]";
	}

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public int getcDuration() {
		return cDuration;
	}

	public void setcDuration(int cDuration) {
		this.cDuration = cDuration;
	}

	public Date getcDate() {
		return cDate;
	}

	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}

	public Date getcContent() {
		return cContent;
	}

	public void setcContent(Date cContent) {
		this.cContent = cContent;
	}

	public String getcTitle() {
		return cTitle;
	}

	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}

	public String getcStatus() {
		return cStatus;
	}

	public void setcStatus(String cStatus) {
		this.cStatus = cStatus;
	}

	public char getmNo() {
		return mNo;
	}

	public void setmNo(char mNo) {
		this.mNo = mNo;
	}

}
