package com.example.togetherhealthy.model.api;

import com.google.gson.annotations.SerializedName;

public class HakKelas{

	@SerializedName("keterangan")
	private String keterangan;

	@SerializedName("kode")
	private String kode;

	public void setKeterangan(String keterangan){
		this.keterangan = keterangan;
	}

	public String getKeterangan(){
		return keterangan;
	}

	public void setKode(String kode){
		this.kode = kode;
	}

	public String getKode(){
		return kode;
	}
}