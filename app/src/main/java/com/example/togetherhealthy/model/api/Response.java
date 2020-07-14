package com.example.togetherhealthy.model.api;

import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("response")
	private Response response;

	@SerializedName("peserta")
	private Peserta peserta;

	public void setResponse(Response response){
		this.response = response;
	}

	public Response getResponse(){
		return response;
	}

	public void setPeserta(Peserta peserta){
		this.peserta = peserta;
	}

	public Peserta getPeserta(){
		return peserta;
	}
}