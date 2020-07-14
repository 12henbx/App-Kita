package com.example.togetherhealthy.model.api;

import com.google.gson.annotations.SerializedName;

public class Peserta{

	@SerializedName("statusPeserta")
	private StatusPeserta statusPeserta;

	@SerializedName("tglTAT")
	private String tglTAT;

	@SerializedName("provUmum")
	private ProvUmum provUmum;

	@SerializedName("umur")
	private Umur umur;

	@SerializedName("mr")
	private Mr mr;

	@SerializedName("sex")
	private String sex;

	@SerializedName("tglCetakKartu")
	private String tglCetakKartu;

	@SerializedName("tglTMT")
	private String tglTMT;

	@SerializedName("hakKelas")
	private HakKelas hakKelas;

	@SerializedName("nik")
	private String nik;

	@SerializedName("tglLahir")
	private String tglLahir;

	@SerializedName("pisa")
	private String pisa;

	@SerializedName("nama")
	private String nama;

	@SerializedName("cob")
	private Cob cob;

	@SerializedName("noKartu")
	private String noKartu;

	@SerializedName("jenisPeserta")
	private JenisPeserta jenisPeserta;

	@SerializedName("informasi")
	private Informasi informasi;

	public void setStatusPeserta(StatusPeserta statusPeserta){
		this.statusPeserta = statusPeserta;
	}

	public StatusPeserta getStatusPeserta(){
		return statusPeserta;
	}

	public void setTglTAT(String tglTAT){
		this.tglTAT = tglTAT;
	}

	public String getTglTAT(){
		return tglTAT;
	}

	public void setProvUmum(ProvUmum provUmum){
		this.provUmum = provUmum;
	}

	public ProvUmum getProvUmum(){
		return provUmum;
	}

	public void setUmur(Umur umur){
		this.umur = umur;
	}

	public Umur getUmur(){
		return umur;
	}

	public void setMr(Mr mr){
		this.mr = mr;
	}

	public Mr getMr(){
		return mr;
	}

	public void setSex(String sex){
		this.sex = sex;
	}

	public String getSex(){
		return sex;
	}

	public void setTglCetakKartu(String tglCetakKartu){
		this.tglCetakKartu = tglCetakKartu;
	}

	public String getTglCetakKartu(){
		return tglCetakKartu;
	}

	public void setTglTMT(String tglTMT){
		this.tglTMT = tglTMT;
	}

	public String getTglTMT(){
		return tglTMT;
	}

	public void setHakKelas(HakKelas hakKelas){
		this.hakKelas = hakKelas;
	}

	public HakKelas getHakKelas(){
		return hakKelas;
	}

	public void setNik(String nik){
		this.nik = nik;
	}

	public String getNik(){
		return nik;
	}

	public void setTglLahir(String tglLahir){
		this.tglLahir = tglLahir;
	}

	public String getTglLahir(){
		return tglLahir;
	}

	public void setPisa(String pisa){
		this.pisa = pisa;
	}

	public String getPisa(){
		return pisa;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setCob(Cob cob){
		this.cob = cob;
	}

	public Cob getCob(){
		return cob;
	}

	public void setNoKartu(String noKartu){
		this.noKartu = noKartu;
	}

	public String getNoKartu(){
		return noKartu;
	}

	public void setJenisPeserta(JenisPeserta jenisPeserta){
		this.jenisPeserta = jenisPeserta;
	}

	public JenisPeserta getJenisPeserta(){
		return jenisPeserta;
	}

	public void setInformasi(Informasi informasi){
		this.informasi = informasi;
	}

	public Informasi getInformasi(){
		return informasi;
	}
}