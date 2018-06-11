package com.vode.entity;

import java.sql.Date;

public class Inspekcija {
	
	private String imeVodnogResursa;
	
	private String razlogPrijave;
	
	private Date datumPrijave;
	
	private Date datumOdobravanja;
	
	private Date DatumPregleda;
	
	private String imeInspektora;
	
	private String izvestaj;
	
	public Inspekcija() {
		
	}

	public String getImeVodnogResursa() {
		return imeVodnogResursa;
	}

	public void setImeVodnogResursa(String imeVodnogResursa) {
		this.imeVodnogResursa = imeVodnogResursa;
	}

	public String getRazlogPrijave() {
		return razlogPrijave;
	}

	public void setRazlogPrijave(String razlogPrijave) {
		this.razlogPrijave = razlogPrijave;
	}

	public Date getDatumPrijave() {
		return datumPrijave;
	}

	public void setDatumPrijave(Date datumPrijave) {
		this.datumPrijave = datumPrijave;
	}

	public Date getDatumOdobravanja() {
		return datumOdobravanja;
	}

	public void setDatumOdobravanja(Date datumOdobravanja) {
		this.datumOdobravanja = datumOdobravanja;
	}

	public Date getDatumPregleda() {
		return DatumPregleda;
	}

	public void setDatumPregleda(Date datumPregleda) {
		DatumPregleda = datumPregleda;
	}

	public String getImeInspektora() {
		return imeInspektora;
	}

	public void setImeInspektora(String imeInspektora) {
		this.imeInspektora = imeInspektora;
	}

	public String getIzvestaj() {
		return izvestaj;
	}

	public void setIzvestaj(String izvestaj) {
		this.izvestaj = izvestaj;
	}
	
}
