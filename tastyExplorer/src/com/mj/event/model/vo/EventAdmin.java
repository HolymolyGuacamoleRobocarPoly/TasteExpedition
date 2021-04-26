package com.mj.event.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class EventAdmin implements Serializable {

	private static final long serialVersionUID = 1002L;
	
	private int eNo;
	private String eComment;
	private String eTitle;
	private Date eDuration;
	
	public EventAdmin() {}

	public EventAdmin(int eNo, String eComment, String eTitle, Date eDuration) {
		super();
		this.eNo = eNo;
		this.eComment = eComment;
		this.eTitle = eTitle;
		this.eDuration = eDuration;
	}

	@Override
	public String toString() {
		return "EventAdmin [eNo=" + eNo + ", eComment=" + eComment + ", eTitle=" + eTitle + ", eDuration=" + eDuration
				+ "]";
	}

	public int geteNo() {
		return eNo;
	}

	public void seteNo(int eNo) {
		this.eNo = eNo;
	}

	public String geteComment() {
		return eComment;
	}

	public void seteComment(String eComment) {
		this.eComment = eComment;
	}

	public String geteTitle() {
		return eTitle;
	}

	public void seteTitle(String eTitle) {
		this.eTitle = eTitle;
	}

	public Date geteDuration() {
		return eDuration;
	}

	public void seteDuration(Date eDuration) {
		this.eDuration = eDuration;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

}
