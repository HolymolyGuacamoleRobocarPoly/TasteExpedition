package com.mj.mEvaluation.model.vo;

import java.io.Serializable;

public class Evaluation implements Serializable {
	
	private static final long serialVersionUID = 1005;
	
	private int EvaluationList;
	private int EvaluationCount;
	private int mNo;
	
	public Evaluation() {}

	public Evaluation(int evaluationList, int evaluationCount, int mNo) {
		super();
		EvaluationList = evaluationList;
		EvaluationCount = evaluationCount;
		this.mNo = mNo;
	}

	@Override
	public String toString() {
		return "Evaluation [EvaluationList=" + EvaluationList + ", EvaluationCount=" + EvaluationCount + ", mNo=" + mNo
				+ "]";
	}

	public int getEvaluationList() {
		return EvaluationList;
	}

	public void setEvaluationList(int evaluationList) {
		EvaluationList = evaluationList;
	}

	public int getEvaluationCount() {
		return EvaluationCount;
	}

	public void setEvaluationCount(int evaluationCount) {
		EvaluationCount = evaluationCount;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	
	

}