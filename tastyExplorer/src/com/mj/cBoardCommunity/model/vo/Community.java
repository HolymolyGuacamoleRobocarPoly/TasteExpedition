package com.mj.cBoardCommunity.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Community implements Serializable{

	private static final long serialVersionUID = 3030;
	
	private int cBoardNo;
	private String cBoardTitle;
	private String cBoardContent;
	private String cBoardwriter;
	private String mNickname;
	private int cBoardTeam;
	private int cBoardCount;
	private Date cBoardDate;
	private char cBoardStatus;
	
	public Community() {}

	public Community(int cBoardNo, String cBoardTitle, String cBoardContent, String cBoardwriter, String mNickname,
			int cBoardTeam, int cBoardCount, Date cBoardDate, char cBoardStatus) {
		super();
		this.cBoardNo = cBoardNo;
		this.cBoardTitle = cBoardTitle;
		this.cBoardContent = cBoardContent;
		this.cBoardwriter = cBoardwriter;	//작성자
		this.mNickname = mNickname;			// 닉네임가져오기
		this.cBoardTeam = cBoardTeam;
		this.cBoardCount = cBoardCount;
		this.cBoardDate = cBoardDate;
		this.cBoardStatus = cBoardStatus;
	}

	public Community(String cBoardTitle, String cBoardContent, String mNickname) {
		super();
		this.cBoardTitle = cBoardTitle;
		this.cBoardContent = cBoardContent;
		this.mNickname = mNickname;
	}

	
	@Override
	public String toString() {
		return "Community [cBoardNo=" + cBoardNo + ", cBoardTitle=" + cBoardTitle + ", cBoardContent=" + cBoardContent
				+ ", cBoardwriter=" + cBoardwriter + ", mNickname=" + mNickname + ", cBoardTeam=" + cBoardTeam
				+ ", cBoardCount=" + cBoardCount + ", cBoardDate=" + cBoardDate + ", cBoardStatus=" + cBoardStatus
				+ "]";
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

	public String getcBoardwriter() {
		return cBoardwriter;
	}

	public void setcBoardwriter(String cBoardwriter) {
		this.cBoardwriter = cBoardwriter;
	}

	public String getmNickname() {
		return mNickname;
	}

	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
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

	public char getcBoardStatus() {
		return cBoardStatus;
	}

	public void setcBoardStatus(char cBoardStatus) {
		this.cBoardStatus = cBoardStatus;
	}
	
	
	
	
}