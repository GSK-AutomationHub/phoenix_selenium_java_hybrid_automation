package com.ui.pojo;

public class ProblemsReportedPojo {
	
	private String problem;
	private String remark;
	private String addedBy;
	private String role;
	public ProblemsReportedPojo(String problem, String remark, String addedBy, String role) {
		super();
		this.problem = problem;
		this.remark = remark;
		this.addedBy = addedBy;
		this.role = role;
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
	public String getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "ProblemsReported [problem= " + problem + ", remark= " + remark + ", addedBy= " + addedBy + ", role= "
				+ role + "]";
	}
	
	

}
