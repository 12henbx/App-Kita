package com.example.togetherhealthy.model.api;

import com.google.gson.annotations.SerializedName;

public class Mr{

	@SerializedName("noTelepon")
	private String noTelepon;

	@SerializedName("noMR")
	private String noMR;

	public void setNoTelepon(String noTelepon){
		this.noTelepon = noTelepon;
	}

	public String getNoTelepon(){
		return noTelepon;
	}

	public void setNoMR(String noMR){
		this.noMR = noMR;
	}

	public String getNoMR(){
		return noMR;
	}
}