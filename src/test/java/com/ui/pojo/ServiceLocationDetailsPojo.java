package com.ui.pojo;

public class ServiceLocationDetailsPojo {
	private String serviceLocation;
	private String repairStartDate;
	private String repairEndDate;
	public ServiceLocationDetailsPojo(String serviceLocation, String repairStartDate, String repairEndDate) {
		super();
		this.serviceLocation = serviceLocation;
		this.repairStartDate = repairStartDate;
		this.repairEndDate = repairEndDate;
	}
	public String getServiceLocation() {
		return serviceLocation;
	}
	public void setServiceLocation(String serviceLocation) {
		this.serviceLocation = serviceLocation;
	}
	public String getRepairStartDate() {
		return repairStartDate;
	}
	public void setRepairStartDate(String repairStartDate) {
		this.repairStartDate = repairStartDate;
	}
	public String getRepairEndDate() {
		return repairEndDate;
	}
	public void setRepairEndDate(String repairEndDate) {
		this.repairEndDate = repairEndDate;
	}
	@Override
	public String toString() {
		return "ServiceLocationDetails [serviceLocation= " + serviceLocation + ", repairStartDate= " + repairStartDate
				+ ", repairEndDate= " + repairEndDate + "]";
	}
	
	

}
