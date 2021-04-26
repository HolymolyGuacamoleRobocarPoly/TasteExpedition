package com.mj.mRestaurant.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Reservation implements Serializable{
	
	private static final long serialVersionUID = 1004;
	
	private int rbNo;
	private Date rvDate;
	private Date rvTime;
	private char rvStatus;
	private String rvRuquest;
	private int mNo;
	
	public Reservation() {}

	public Reservation(int rbNo, Date rvDate, Date rvTime, char rvStatus, String rvRuquest, int mNo) {
		super();
		this.rbNo = rbNo;
		this.rvDate = rvDate;
		this.rvTime = rvTime;
		this.rvStatus = rvStatus;
		this.rvRuquest = rvRuquest;
		this.mNo = mNo;
	}

	@Override
	public String toString() {
		return "Review [rbNo=" + rbNo + ", rvDate=" + rvDate + ", rvTime=" + rvTime + ", rvStatus=" + rvStatus
				+ ", rvRuquest=" + rvRuquest + ", mNo=" + mNo + "]";
	}

	public int getRbNo() {
		return rbNo;
	}

	public void setRbNo(int rbNo) {
		this.rbNo = rbNo;
	}

	public Date getRvDate() {
		return rvDate;
	}

	public void setRvDate(Date rvDate) {
		this.rvDate = rvDate;
	}

	public Date getRvTime() {
		return rvTime;
	}

	public void setRvTime(Date rvTime) {
		this.rvTime = rvTime;
	}

	public int getRvStatus() {
		return rvStatus;
	}

	public void setRvStatus(char rvStatus) {
		this.rvStatus = rvStatus;
	}

	public String getRvRuquest() {
		return rvRuquest;
	}

	public void setRvRuquest(String rvRuquest) {
		this.rvRuquest = rvRuquest;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	
	
	
	
}
