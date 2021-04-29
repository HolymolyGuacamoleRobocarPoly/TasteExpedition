package com.mj.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable{
	
	private static final long serialVersionUID = 1004;
	
	private int mNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String phone;
	private Date Birthday;
	private String address;
	private Date EnrollDate;
	private String mLevel;
	private int mWarning;
	private int mPurchase;
	private String mProfileAtt;
	private String nickName;
	private int mLoginType;

	public Member() {}
	
	public Member(int mNo, String userId, String userPwd, String userName, String phone, Date Birthday, String address,
			Date EnrollDate, String mLevel, int mWarning, int mPurchase, String mProfileAtt, String nickName,
			int mLoginType) {
		super();
		this.mNo = mNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phone = phone;
		this.Birthday = Birthday;
		this.address = address;
		this.EnrollDate = EnrollDate;
		this.mLevel = mLevel;
		this.mWarning = mWarning;
		this.mPurchase = mPurchase;
		this.mProfileAtt = mProfileAtt;
		this.nickName = nickName;
		this.mLoginType = mLoginType;
	}
	
	public Member(String userId, String userPwd) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
	}
	
	@Override
	public String toString() {
		return "member [mNo=" + mNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", phone=" + phone
				+ ", Birthday=" + Birthday + ", address=" + address + ", EnrollDate=" + EnrollDate + ", mLevel=" + mLevel
				+ ", mWarning=" + mWarning + ", mPurchase=" + mPurchase + ", mProfileAtt=" + mProfileAtt
				+ ", nickName=" + nickName + ", mLoginType=" + mLoginType + "]";
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public String getuserId() {
		return userId;
	}

	public void setuserId(String userId) {
		this.userId = userId;
	}

	public String getuserPwd() {
		return userPwd;
	}

	public void setuserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getphone() {
		return phone;
	}

	public void setphone(String phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return Birthday;
	}

	public void setBirthday(Date Birthday) {
		this.Birthday = Birthday;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public Date getEnrollDate() {
		return EnrollDate;
	}

	public void setEnrollDate(Date EnrollDate) {
		this.EnrollDate = EnrollDate;
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

	public String getnickName() {
		return nickName;
	}

	public void setnickName(String nickName) {
		this.nickName = nickName;
	}

	public int getmLoginType() {
		return mLoginType;
	}

	public void setmLoginType(int mLoginType) {
		this.mLoginType = mLoginType;
	}
	
}

