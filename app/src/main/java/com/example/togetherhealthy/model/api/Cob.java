package com.example.togetherhealthy.model.api;

import com.google.gson.annotations.SerializedName;

public class Cob{

	@SerializedName("tglTAT")
	private Object tglTAT;

	@SerializedName("nmAsuransi")
	private Object nmAsuransi;

	@SerializedName("noAsuransi")
	private Object noAsuransi;

	@SerializedName("tglTMT")
	private Object tglTMT;

	public void setTglTAT(Object tglTAT){
		this.tglTAT = tglTAT;
	}

	public Object getTglTAT(){
		return tglTAT;
	}

	public void setNmAsuransi(Object nmAsuransi){
		this.nmAsuransi = nmAsuransi;
	}

	public Object getNmAsuransi(){
		return nmAsuransi;
	}

	public void setNoAsuransi(Object noAsuransi){
		this.noAsuransi = noAsuransi;
	}

	public Object getNoAsuransi(){
		return noAsuransi;
	}

	public void setTglTMT(Object tglTMT){
		this.tglTMT = tglTMT;
	}

	public Object getTglTMT(){
		return tglTMT;
	}
}