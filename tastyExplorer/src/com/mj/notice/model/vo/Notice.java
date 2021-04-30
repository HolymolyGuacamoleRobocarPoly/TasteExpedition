package com.mj.notice.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Notice implements Serializable{
	
	private static final long serialVersionUID = 1030;
	
	// 필드변수
	private int nNo ;
	private String nTitle;
	private String nContent;
	private Date nDate;
	private int nCount;
	private String nStatus; // 홍석 수정 String으로 변환 -> DB에서 넘어올 땐 String으로만 넘어와서
	
	// 생성자
	public Notice()	{}
	
	
	public Notice(int nNo, String nTitle, String nContent, Date nDate, int nCount, String nStatus) {
		super();
		this.nNo = nNo;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nDate = nDate;
		this.nCount = nCount;
		this.nStatus = nStatus;
	}


	@Override
	public String toString() {
		return "Notice [nNo=" + nNo + ", nTitle=" + nTitle + ", nContent=" + nContent + ", nDate=" + nDate + ", nCount="
				+ nCount + ", nStatus=" + nStatus + "]";
	}


	public int getnNo() {
		return nNo;
	}


	public void setnNo(int nNo) {
		this.nNo = nNo;
	}


	public String getnTitle() {
		return nTitle;
	}


	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}


	public String getnContent() {
		return nContent;
	}


	public void setnContent(String nContent) {
		this.nContent = nContent;
	}


	public Date getnDate() {
		return nDate;
	}


	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}


	public int getnCount() {
		return nCount;
	}


	public void setnCount(int nCount) {
		this.nCount = nCount;
	}

	public String getnStatus() {
		return nStatus;
	}

	public void setnStatus(String nStatus) {
		this.nStatus = nStatus;
	}
	
	
}