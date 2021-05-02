package com.mj.cBoardCommunity.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Community implements Serializable{

	private static final long serialVersionUID = 3030L;

	private int cBoardNo;
	private String cBoardTitle;
	private String cBoardContent;
	private int cBoardTeam;
	private int cBoardCount;
	private Date cBoardDate;
	private String cBoardStatus;
	private String cBoardWriter; 	// 게시글 작성자
	private String mNickname;		// 게시글 닉네임
	
	public Community() {}

	public Community(int cBoardNo, String cBoardTitle, String cBoardContent, int cBoardTeam, int cBoardCount,
			Date cBoardDate, String cBoardStatus, String cBoardWriter, String mNickname) {
		super();
		this.cBoardNo = cBoardNo;
		this.cBoardTitle = cBoardTitle;
		this.cBoardContent = cBoardContent;
		this.cBoardTeam = cBoardTeam;
		this.cBoardCount = cBoardCount;
		this.cBoardDate = cBoardDate;
		this.cBoardStatus = cBoardStatus;
		this.cBoardWriter = cBoardWriter;
		this.mNickname = mNickname;
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
				+ ", cBoardTeam=" + cBoardTeam + ", cBoardCount=" + cBoardCount + ", cBoardDate=" + cBoardDate
				+ ", cBoardStatus=" + cBoardStatus + ", cBoardWriter=" + cBoardWriter + ", mNickname=" + mNickname
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

	public String getcBoardStatus() {
		return cBoardStatus;
	}

	public void setcBoardStatus(String cBoardStatus) {
		this.cBoardStatus = cBoardStatus;
	}

	public String getcBoardWriter() {
		return cBoardWriter;
	}

	public void setcBoardWriter(String cBoardWriter) {
		this.cBoardWriter = cBoardWriter;
	}

	public String getmNickname() {
		return mNickname;
	}

	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}

	
	
}