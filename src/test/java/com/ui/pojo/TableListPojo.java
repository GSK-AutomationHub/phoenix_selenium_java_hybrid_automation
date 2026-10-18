package com.ui.pojo;

public class TableListPojo {
	private String oem;
	private String job_number;
	private String imei_num;
	private String product;
	private String model;
	private String warranty_status;
	private String action_status;

	public TableListPojo(String oem, String job_number, String imei_num, String product, String model,
			String warranty_status, String action_status) {
		super();
		this.oem = oem;
		this.job_number = job_number;
		this.imei_num = imei_num;
		this.product = product;
		this.model = model;
		this.warranty_status = warranty_status;
		this.action_status = action_status;
	}

	public String getOem() {
		return oem;
	}

	public void setOem(String oem) {
		this.oem = oem;
	}

	public String getJob_number() {
		return job_number;
	}

	public void setJob_number(String job_number) {
		this.job_number = job_number;
	}

	public String getImei_num() {
		return imei_num;
	}

	public void setImei_num(String imei_num) {
		this.imei_num = imei_num;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getWarranty_status() {
		return warranty_status;
	}

	public void setWarranty_status(String warranty_status) {
		this.warranty_status = warranty_status;
	}

	public String getAction_status() {
		return action_status;
	}

	public void setAction_status(String action_status) {
		this.action_status = action_status;
	}

	@Override
	public String toString() {
		return "JobList [oem= " + oem +   ", job_number= " + job_number +    ", imei_num= " + imei_num
				+     ", product= " + product +     ", model= " + model +     ", warranty_status= " + warranty_status
				+     ", action_status= " + action_status +     "]";
	}

}
