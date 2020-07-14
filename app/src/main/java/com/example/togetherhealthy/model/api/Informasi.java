package com.example.togetherhealthy.model.api;

import com.google.gson.annotations.SerializedName;

public class Informasi{

	@SerializedName("prolanisPRB")
	private String prolanisPRB;

	@SerializedName("noSKTM")
	private Object noSKTM;

	@SerializedName("dinsos")
	private Object dinsos;

	public void setProlanisPRB(String prolanisPRB){
		this.prolanisPRB = prolanisPRB;
	}

	public String getProlanisPRB(){
		return prolanisPRB;
	}

	public void setNoSKTM(Object noSKTM){
		this.noSKTM = noSKTM;
	}

	public Object getNoSKTM(){
		return noSKTM;
	}

	public void setDinsos(Object dinsos){
		this.dinsos = dinsos;
	}

	public Object getDinsos(){
		return dinsos;
	}
}