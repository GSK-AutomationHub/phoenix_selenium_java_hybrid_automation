package com.ui.pojo;

public class CustomerReportedProblemsPojo {
	private String problem;
	private String remark;
	public CustomerReportedProblemsPojo(String problem, String remark) {
		super();
		this.problem = problem;
		this.remark = remark;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "CustomerReportedProblems [problem= " + problem + ", remark= " + remark + "]";
	}
	

}
