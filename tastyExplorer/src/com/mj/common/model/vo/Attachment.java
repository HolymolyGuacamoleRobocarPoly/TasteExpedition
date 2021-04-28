package com.mj.common.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Attachment implements Serializable{

	private static final long serialVersionUID = 1200L;
	
	
	private int attMNo;
	private String attMFileName;
	private Date attMUploadDate;
	private int attMFlevel;
	private char attMStatus;
	
	public Attachment() {}

	public Attachment(int attMNo, String attMFileName, Date attMUploadDate, int attMFlevel, char attMStatus) {
		super();
		this.attMNo = attMNo;
		this.attMFileName = attMFileName;
		this.attMUploadDate = attMUploadDate;
		this.attMFlevel = attMFlevel;
		this.attMStatus = attMStatus;
	}

	@Override
	public String toString() {
		return "Attachment [attMNo=" + attMNo + ", attMFileName=" + attMFileName + ", attMUploadDate=" + attMUploadDate
				+ ", attMFlevel=" + attMFlevel + ", attMStatus=" + attMStatus + "]";
	}

	public int getAttMNo() {
		return attMNo;
	}

	public void setAttMNo(int attMNo) {
		this.attMNo = attMNo;
	}

	public String getAttMFileName() {
		return attMFileName;
	}

	public void setAttMFileName(String attMFileName) {
		this.attMFileName = attMFileName;
	}

	public Date getAttMUploadDate() {
		return attMUploadDate;
	}

	public void setAttMUploadDate(Date attMUploadDate) {
		this.attMUploadDate = attMUploadDate;
	}

	public int getAttMFlevel() {
		return attMFlevel;
	}

	public void setAttMFlevel(int attMFlevel) {
		this.attMFlevel = attMFlevel;
	}

	public char getAttMStatus() {
		return attMStatus;
	}

	public void setAttMStatus(char attMStatus) {
		this.attMStatus = attMStatus;
	};

	
}
