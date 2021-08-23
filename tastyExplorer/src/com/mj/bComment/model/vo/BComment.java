package com.mj.bComment.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class BComment implements Serializable {

	/**
	 * 댓글 객체
	 */
	private static final long serialVersionUID = 7L;
	
	
	// 필드 변수
	private int commentNo;
	private String commentContent;
	private Date commentDate;
	private int cBoardNo;
	private int mNo;
	private String bcoWriter;
	
	// 생성자
	public BComment () { }

	public BComment(int commentNo, String commentContent, Date commentDate, int cBoardNo, int mNo, String bcoWriter) {
		super();
		this.commentNo = commentNo;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.cBoardNo = cBoardNo;
		this.mNo = mNo;
		this.bcoWriter = bcoWriter;
		
	}
	// 메소드
	
	public BComment(String commentContent, int cBoardNo, int mNo, String bcoWriter) {
		super();
		this.commentContent = commentContent;
		this.cBoardNo = cBoardNo;
		this.mNo = mNo;
		this.bcoWriter = bcoWriter;
	}

	// toString
	@Override
	public String toString() {
		return "BComment [commentNo=" + commentNo + ", commentContent=" + commentContent + ", commentDate="
				+ commentDate + ", cBoardNo=" + cBoardNo + ", mNo=" + mNo + ", bcoWriter=" + bcoWriter + "]";
	}
	
	// getter & setter
	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public int getcBoardNo() {
		return cBoardNo;
	}

	public void setcBoardNo(int cBoardNo) {
		this.cBoardNo = cBoardNo;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public String getBcoWriter() {
		return bcoWriter;
	}

	public void setBcoWriter(String bcoWriter) {
		this.bcoWriter = bcoWriter;
	}

	
}
