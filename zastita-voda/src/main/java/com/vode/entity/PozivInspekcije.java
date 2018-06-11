package com.vode.entity;

public class PozivInspekcije {
	
	private String razlog;
	
	private Long idKorisnika;
	
	private long idVodnogResursa;
	
	public PozivInspekcije() {
		
	}

	public String getRazlog() {
		return razlog;
	}

	public void setRazlog(String razlog) {
		this.razlog = razlog;
	}

	public Long getIdKorisnika() {
		return idKorisnika;
	}

	public void setIdKorisnika(Long idKorisnika) {
		this.idKorisnika = idKorisnika;
	}

	public long getIdVodnogResursa() {
		return idVodnogResursa;
	}

	public void setIdVodnogResursa(long idVodnogResursa) {
		this.idVodnogResursa = idVodnogResursa;
	}
}
