package com.mj.cBoardCommunity.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Community implements Serializable{

	private static final long serialVersionUID = 3030;
	
	private int cBoardNo;
	private String cBoardTitle;
	private String cBoardContent;
	private int mNo;
	private int cBoardTeam;
	private int cBoardCount;
	private Date cBoardDate;
	private char cBoardStatus;
	
	public Community() {}

	public Community(int cBoardNo, String cBoardTitle, String cBoardContent, int mNo, int cBoardTeam, int cBoardCount,
			Date cBoardDate, char cBoardStatus) {
		super();
		this.cBoardNo = cBoardNo;
		this.cBoardTitle = cBoardTitle;
		this.cBoardContent = cBoardContent;
		this.mNo = mNo;
		this.cBoardTeam = cBoardTeam;
		this.cBoardCount = cBoardCount;
		this.cBoardDate = cBoardDate;
		this.cBoardStatus = cBoardStatus;
	}

	@Override
	public String toString() {
		return "Community [cBoardNo=" + cBoardNo + ", cBoardTitle=" + cBoardTitle + ", cBoardContent=" + cBoardContent
				+ ", mNo=" + mNo + ", cBoardTeam=" + cBoardTeam + ", cBoardCount=" + cBoardCount + ", cBoardDate="
				+ cBoardDate + ", cBoardStatus=" + cBoardStatus + "]";
	}

	public int getcBoardNo() {
		return cBoardNo;
	}

	public void setcBoardNo(int cBoardNo) {
		this.cBoardNo = cBoardNo;
	}

	public String getcBoardTitle() {
		return cBoardTitle;
	}

	public void setcBoardTitle(String cBoardTitle) {
		this.cBoardTitle = cBoardTitle;
	}

	public String getcBoardContent() {
		return cBoardContent;
	}

	public void setcBoardContent(String cBoardContent) {
		this.cBoardContent = cBoardContent;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public int getcBoardTeam() {
		return cBoardTeam;
	}

	public void setcBoardTeam(int cBoardTeam) {
		this.cBoardTeam = cBoardTeam;
	}

	public int getcBoardCount() {
		return cBoardCount;
	}

	public void setcBoardCount(int cBoardCount) {
		this.cBoardCount = cBoardCount;
	}

	public Date getcBoardDate() {
		return cBoardDate;
	}

	public void setcBoardDate(Date cBoardDate) {
		this.cBoardDate = cBoardDate;
	}

	public int getcBoardStatus() {
		return cBoardStatus;
	}

	public void setcBoardStatus(char cBoardStatus) {
		this.cBoardStatus = cBoardStatus;
	}
	
	
	
}  
   