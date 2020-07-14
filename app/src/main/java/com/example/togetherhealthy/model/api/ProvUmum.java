package com.example.togetherhealthy.model.api;

import com.google.gson.annotations.SerializedName;

public class ProvUmum{

	@SerializedName("nmProvider")
	private String nmProvider;

	@SerializedName("kdProvider")
	private String kdProvider;

	public void setNmProvider(String nmProvider){
		this.nmProvider = nmProvider;
	}

	public String getNmProvider(){
		return nmProvider;
	}

	public void setKdProvider(String kdProvider){
		this.kdProvider = kdProvider;
	}

	public String getKdProvider(){
		return kdProvider;
	}
}