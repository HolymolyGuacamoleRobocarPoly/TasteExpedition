package com.mj.event.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class EventAdmin implements Serializable {

	private static final long serialVersionUID = 1002L;
	
	private int eNo;
	private String eContent;
	private String eTitle;
	private Date eDuration;
	private String check; // 이미 참여했는지 확인하는 참여 여부 Y/N
	
	public EventAdmin() {}

	public EventAdmin(int eNo, String eContent, String eTitle, Date eDuration) {
		super();
		this.eNo = eNo;
		this.eContent = eContent;
		this.eTitle = eTitle;
		this.eDuration = eDuration;
	}

	@Override
	public String toString() {
		return "EventAdmin [eNo=" + eNo + ", eComment=" + eContent + ", eTitle=" + eTitle + ", eDuration=" + eDuration
				+ "]";
	}

	public int geteNo() {
		return eNo;
	}

	public void seteNo(int eNo) {
		this.eNo = eNo;
	}

	public String geteContent() {
		return eContent;
	}

	public void seteContent(String eComment) {
		this.eContent = eComment;
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

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}
	
	
	
	
	
	

}
