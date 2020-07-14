package com.example.togetherhealthy.model.api;

import com.google.gson.annotations.SerializedName;

public class Umur{

	@SerializedName("umurSekarang")
	private String umurSekarang;

	@SerializedName("umurSaatPelayanan")
	private String umurSaatPelayanan;

	public void setUmurSekarang(String umurSekarang){
		this.umurSekarang = umurSekarang;
	}

	public String getUmurSekarang(){
		return umurSekarang;
	}

	public void setUmurSaatPelayanan(String umurSaatPelayanan){
		this.umurSaatPelayanan = umurSaatPelayanan;
	}

	public String getUmurSaatPelayanan(){
		return umurSaatPelayanan;
	}
}