package com.vode.entity;

import java.sql.Date;

public class Licensa {
	
	private Boolean licensaIzdata;
	
	private String tipLicense;
	
	private Date datumZahteva;
	
	private Date datumIsticanja;
	
	private Date datumUkidanja;
	
	private String razlogUkidanja;
	
	private String mestoIzdavanja;
	
	private Date datumOdluke;
	
	private String imeVodnogResursa;
	
	private Boolean licensaPovucena;

	public Licensa() {
		
	}

	public Date getDatumZahteva() {
		return datumZahteva;
	}

	public void setDatumZahteva(Date datumZahteva) {
		this.datumZahteva = datumZahteva;
	}

	public Date getDatumIsticanja() {
		return datumIsticanja;
	}

	public void setDatumIsticanja(Date datumIsticanja) {
		this.datumIsticanja = datumIsticanja;
	}

	public Date getDatumUkidanja() {
		return datumUkidanja;
	}

	public void setDatumUkidanja(Date datumUkidanja) {
		this.datumUkidanja = datumUkidanja;
	}

	public String getRazlogUkidanja() {
		return razlogUkidanja;
	}

	public void setRazlogUkidanja(String razlogUkidanja) {
		this.razlogUkidanja = razlogUkidanja;
	}
	
	public String getMestoIzdavanja() {
		return mestoIzdavanja;
	}

	public void setMestoIzdavanja(String mestoIzdavanja) {
		this.mestoIzdavanja = mestoIzdavanja;
	}

	public Date getDatumOdluke() {
		return datumOdluke;
	}

	public void setDatumOdluke(Date datumOdluke) {
		this.datumOdluke = datumOdluke;
	}

	public Boolean getLicensaIzdata() {
		return licensaIzdata;
	}

	public void setLicensaIzdata(Boolean licensaIzdata) {
		this.licensaIzdata = licensaIzdata;
	}

	public String getTipLicense() {
		return tipLicense;
	}

	public void setTipLicense(String tipLicense) {
		this.tipLicense = tipLicense;
	}

	public String getImeVodnogResursa() {
		return imeVodnogResursa;
	}

	public void setImeVodnogResursa(String imeVodnogResursa) {
		this.imeVodnogResursa = imeVodnogResursa;
	}

	public Boolean getLicensaPovucena() {
		return licensaPovucena;
	}

	public void setLicensaPovucena(Boolean licensaPovucena) {
		this.licensaPovucena = licensaPovucena;
	}
	
}
