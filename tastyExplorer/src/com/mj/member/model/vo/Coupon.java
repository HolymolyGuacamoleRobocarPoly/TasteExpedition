package com.mj.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Coupon implements Serializable {
<<<<<<< HEAD
   
   private static final long serialVersionUID = 1006;
   
   private int cNo;
   private Date cDuration;
   private Date cDate;
   private String cContent;
   private String cTitle;
   private String cStatus;
   private int mNo;
   
   public Coupon() {}
=======
	
	private static final long serialVersionUID = 1006;
	
	private int cNo;
	private Date cDuration;
	private Date cDate;
	private String cContent;
	private String cTitle;
	private String cStatus;
	private int mNo;
	
	public Coupon() {}
>>>>>>> refs/remotes/origin/gayul

<<<<<<< HEAD
   public Coupon(int cNo, Date cDuration, Date cDate, String cContent, String cTitle, String cStatus, int mNo) {
      super();
      this.cNo = cNo;
      this.cDuration = cDuration;
      this.cDate = cDate;
      this.cContent = cContent;
      this.cTitle = cTitle;
      this.cStatus = cStatus;
      this.mNo = mNo;
   }
=======
	public Coupon(int cNo, Date cDuration, Date cDate, String cContent, String cTitle, String cStatus, int mNo) {
		super();
		this.cNo = cNo;
		this.cDuration = cDuration;
		this.cDate = cDate;
		this.cContent = cContent;
		this.cTitle = cTitle;
		this.cStatus = cStatus;
		this.mNo = mNo;
	}
>>>>>>> refs/remotes/origin/gayul

   @Override
   public String toString() {
      return "Coupon [cNo=" + cNo + ", cDuration=" + cDuration + ", cDate=" + cDate + ", cContent=" + cContent
            + ", cTitle=" + cTitle + ", cStatus=" + cStatus + ", mNo=" + mNo + "]";
   }

   public int getcNo() {
      return cNo;
   }

   public void setcNo(int cNo) {
      this.cNo = cNo;
   }

<<<<<<< HEAD
   public Date getcDuration() {
      return cDuration;
   }
=======
	public Date getcDuration() {
		return cDuration;
	}
>>>>>>> refs/remotes/origin/gayul

<<<<<<< HEAD
   public void setcDuration(Date cDuration) {
      this.cDuration = cDuration;
   }
=======
	public void setcDuration(Date cDuration) {
		this.cDuration = cDuration;
	}
>>>>>>> refs/remotes/origin/gayul

   public Date getcDate() {
      return cDate;
   }

   public void setcDate(Date cDate) {
      this.cDate = cDate;
   }

<<<<<<< HEAD
   public String getcContent() {
      return cContent;
   }
=======
	public String getcContent() {
		return cContent;
	}
>>>>>>> refs/remotes/origin/gayul

<<<<<<< HEAD
   public void setcContent(String cContent) {
      this.cContent = cContent;
   }
=======
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}
>>>>>>> refs/remotes/origin/gayul

   public String getcTitle() {
      return cTitle;
   }

   public void setcTitle(String cTitle) {
      this.cTitle = cTitle;
   }

   public String getcStatus() {
      return cStatus;
   }

   public void setcStatus(String cStatus) {
      this.cStatus = cStatus;
   }

<<<<<<< HEAD
   public int getmNo() {
      return mNo;
   }
=======
	public int getmNo() {
		return mNo;
	}
>>>>>>> refs/remotes/origin/gayul

<<<<<<< HEAD
   public void setmNo(int mNo) {
      this.mNo = mNo;
   }
=======
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
>>>>>>> refs/remotes/origin/gayul

<<<<<<< HEAD
=======
	
>>>>>>> refs/remotes/origin/gayul
}