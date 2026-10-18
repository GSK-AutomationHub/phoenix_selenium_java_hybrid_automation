package com.ui.pojo;

public class ActionStatusPojo {
	private String actionStatus;
	private String assignedOn;
	public ActionStatusPojo(String actionStatus, String assignedOn) {
		super();
		this.actionStatus = actionStatus;
		this.assignedOn = assignedOn;
	}
	public String getActionStatus() {
		return actionStatus;
	}
	public void setActionStatus(String actionStatus) {
		this.actionStatus = actionStatus;
	}
	public String getAssignedOn() {
		return assignedOn;
	}
	public void setAssignedOn(String assignedOn) {
		this.assignedOn = assignedOn;
	}
	@Override
	public String toString() {
		return "ActionStatus [actionStatus= " + actionStatus + ", assignedOn= " + assignedOn + "]";
	}
	
	

}
