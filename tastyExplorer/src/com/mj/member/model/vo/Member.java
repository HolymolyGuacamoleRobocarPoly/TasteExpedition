package com.mj.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable{
	
	private static final long serialVersionUID = 1004;
	
	private int mNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String nickName;
	private Date Birthday;
	private String phone;
	private String address;
	private String email;
	
	private Date EnrollDate;
	private String mLevel;
	private int mWarning;
	private int mPurchase;
	private String mProfileAtt;
	private int mLoginType;

	public Member() {}

	public Member(int mNo, String userId, String userPwd, String userName, String nickName, Date birthday, String phone,
			String address, String email, Date enrollDate, String mLevel, int mWarning, int mPurchase,
			String mProfileAtt, int mLoginType) {
		super();
		this.mNo = mNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.nickName = nickName;
		Birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.email = email;
		EnrollDate = enrollDate;
		this.mLevel = mLevel;
		this.mWarning = mWarning;
		this.mPurchase = mPurchase;
		this.mProfileAtt = mProfileAtt;
		this.mLoginType = mLoginType;
	}

	public Member(String userId, String userPwd, String userName, String nickName, Date birthday, String phone,
			String address, String email) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.nickName = nickName;
		Birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}

	

	public Member(String userId, String userPwd) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
	}

	@Override
	public String toString() {
		return "Member [mNo=" + mNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", nickName=" + nickName + ", Birthday=" + Birthday + ", phone=" + phone + ", address=" + address
				+ ", email=" + email + ", EnrollDate=" + EnrollDate + ", mLevel=" + mLevel + ", mWarning=" + mWarning
				+ ", mPurchase=" + mPurchase + ", mProfileAtt=" + mProfileAtt + ", mLoginType=" + mLoginType + "]";
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getBirthday() {
		return Birthday;
	}

	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getEnrollDate() {
		return EnrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		EnrollDate = enrollDate;
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

	public int getmLoginType() {
		return mLoginType;
	}

	public void setmLoginType(int mLoginType) {
		this.mLoginType = mLoginType;
	}

	
	
}

