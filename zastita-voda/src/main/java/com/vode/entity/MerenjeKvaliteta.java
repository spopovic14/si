package com.vode.entity;

import java.sql.Date;
import java.util.ArrayList;

public class MerenjeKvaliteta {
	
	private String imeVodnogResursa;
	
	private Date datumMerenja;
	
	private ArrayList<ParametarMerenja> rezultatiMerenja;
	
	public MerenjeKvaliteta() {
		rezultatiMerenja = new ArrayList<>();
	}

	public String getImeVodnogResursa() {
		return imeVodnogResursa;
	}

	public void setImeVodnogResursa(String imeVodnogResursa) {
		this.imeVodnogResursa = imeVodnogResursa;
	}

	public Date getDatumMerenja() {
		return datumMerenja;
	}

	public void setDatumMerenja(Date datumMerenja) {
		this.datumMerenja = datumMerenja;
	}

	public ArrayList<ParametarMerenja> getRezultatiMerenja() {
		return rezultatiMerenja;
	}

	public void setRezultatiMerenja(ArrayList<ParametarMerenja> rezultatiMerenja) {
		this.rezultatiMerenja = rezultatiMerenja;
	}
	
	public void addParametarMerenja(ParametarMerenja param) {
		rezultatiMerenja.add(param);
	}
}
