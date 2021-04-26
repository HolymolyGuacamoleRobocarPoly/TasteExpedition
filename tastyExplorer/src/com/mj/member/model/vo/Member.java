package com.mj.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable{
	
	private static final long serialVersionUID = 1004;
	
	private int mNo;
	private String mId;
	private String mPwd;
	private String mName;
	private String mPhone;
	private Date mBirth;
	private String mAddr;
	private Date mEnrollDate;
	private String mLevel;
	private int mWarning;
	private int mPurchase;
	private String mProfileAtt;
	private String mNickname;
	private int mLoginType;

	public Member() {}
	
	public Member(int mNo, String mId, String mPwd, String mName, String mPhone, Date mBirth, String mAddr,
			Date mEnrollDate, String mLevel, int mWarning, int mPurchase, String mProfileAtt, String mNickname,
			int mLoginType) {
		super();
		this.mNo = mNo;
		this.mId = mId;
		this.mPwd = mPwd;
		this.mName = mName;
		this.mPhone = mPhone;
		this.mBirth = mBirth;
		this.mAddr = mAddr;
		this.mEnrollDate = mEnrollDate;
		this.mLevel = mLevel;
		this.mWarning = mWarning;
		this.mPurchase = mPurchase;
		this.mProfileAtt = mProfileAtt;
		this.mNickname = mNickname;
		this.mLoginType = mLoginType;
	}
	
	@Override
	public String toString() {
		return "member [mNo=" + mNo + ", mId=" + mId + ", mPwd=" + mPwd + ", mName=" + mName + ", mPhone=" + mPhone
				+ ", mBirth=" + mBirth + ", mAddr=" + mAddr + ", mEnrollDate=" + mEnrollDate + ", mLevel=" + mLevel
				+ ", mWarning=" + mWarning + ", mPurchase=" + mPurchase + ", mProfileAtt=" + mProfileAtt
				+ ", mNickname=" + mNickname + ", mLoginType=" + mLoginType + "]";
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmPwd() {
		return mPwd;
	}

	public void setmPwd(String mPwd) {
		this.mPwd = mPwd;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmPhone() {
		return mPhone;
	}

	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}

	public Date getmBirth() {
		return mBirth;
	}

	public void setmBirth(Date mBirth) {
		this.mBirth = mBirth;
	}

	public String getmAddr() {
		return mAddr;
	}

	public void setmAddr(String mAddr) {
		this.mAddr = mAddr;
	}

	public Date getmEnrollDate() {
		return mEnrollDate;
	}

	public void setmEnrollDate(Date mEnrollDate) {
		this.mEnrollDate = mEnrollDate;
	}

	public String getmLevel() {
		return mLevel;
	}

	public void setmLevel(String mLevel) {
		this.mLevel = mLevel;
	}

	public int getmWarning() {
		return mWarning;
	}

	public void setmWarning(int mWarning) {
		this.mWarning = mWarning;
	}

	public int getmPurchase() {
		return mPurchase;
	}

	public void setmPurchase(int mPurchase) {
		this.mPurchase = mPurchase;
	}

	public String getmProfileAtt() {
		return mProfileAtt;
	}

	public void setmProfileAtt(String mProfileAtt) {
		this.mProfileAtt = mProfileAtt;
	}

	public String getmNickname() {
		return mNickname;
	}

	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}

	public int getmLoginType() {
		return mLoginType;
	}

	public void setmLoginType(int mLoginType) {
		this.mLoginType = mLoginType;
	}
	
}

