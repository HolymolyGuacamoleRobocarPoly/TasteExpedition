package com.mj.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Coupon implements Serializable {
	
	private static final long serialVersionUID = 1006;
	
	private int cNo;
	private Date cDuration;
	private Date cDate;
	private String cContent;
	private String cTitle;
	private String cStatus;
	private int mNo;
	
	public Coupon() {}

	public Coupon(int cNo, Date cDuration, Date cDate, String cContent, String cTitle, String cStatus, int mNo) {
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

	public Date getcDuration() {
		return cDuration;
	}

	public void setcDuration(Date cDuration) {
		this.cDuration = cDuration;
	}

	public Date getcDate() {
		return cDate;
	}

	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}

	public String getcContent() {
		return cContent;
	}

	public void setcContent(String cContent) {
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

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

}
