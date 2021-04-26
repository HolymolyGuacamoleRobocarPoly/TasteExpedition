package com.mj.event.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class EventMember implements Serializable {

	private static final long serialVersionUID = 1001L;
	
	private int eNo;
	private int mNo;
	private Date eDate;
	
	public EventMember() {}

	public EventMember(int eNo, int mNo, Date eDate) {
		super();
		this.eNo = eNo;
		this.mNo = mNo;
		this.eDate = eDate;
	}

	@Override
	public String toString() {
		return "EventMember [eNo=" + eNo + ", mNo=" + mNo + ", eDate=" + eDate + "]";
	}

	public int geteNo() {
		return eNo;
	}

	public void seteNo(int eNo) {
		this.eNo = eNo;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public Date geteDate() {
		return eDate;
	}

	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
