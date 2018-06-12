package com.vode.entity;

public class ParametarMerenja {
	
	private String sifraParametra;
	
	private String nazivTipaParameta;
	
	private double minimalnaStandardnaVrednostParametra;
	
	private double maksimalnaStandardnaVrednostParametra;
	
	private double vrednost;
	
	public ParametarMerenja() {
		
	}

	public String getSifraParametra() {
		return sifraParametra;
	}

	public void setSifraParametra(String sifraParametra) {
		this.sifraParametra = sifraParametra;
	}

	public String getNazivTipaParameta() {
		return nazivTipaParameta;
	}

	public void setNazivTipaParameta(String nazivTipaParameta) {
		this.nazivTipaParameta = nazivTipaParameta;
	}

	public double getMinimalnaStandardnaVrednostParametra() {
		return minimalnaStandardnaVrednostParametra;
	}

	public void setMinimalnaStandardnaVrednostParametra(double minimalnaStandardnaVrednostParametra) {
		this.minimalnaStandardnaVrednostParametra = minimalnaStandardnaVrednostParametra;
	}

	public double getMaksimalnaStandardnaVrednostParametra() {
		return maksimalnaStandardnaVrednostParametra;
	}

	public void setMaksimalnaStandardnaVrednostParametra(double maksimalnaStandardnaVrednostParametra) {
		this.maksimalnaStandardnaVrednostParametra = maksimalnaStandardnaVrednostParametra;
	}

	public double getVrednost() {
		return vrednost;
	}

	public void setVrednost(double vrednost) {
		this.vrednost = vrednost;
	}
	
}
