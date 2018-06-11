package com.vode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.vode.entity.PozivInspekcije;

@Component
public class PozivInspekcijeService {
	
	private JdbcTemplate jdbc;
	
	private VodniResursService vodniResursService;
	
	@Autowired
	public PozivInspekcijeService(JdbcTemplate jdbc, VodniResursService vodniResursService) {
		this.jdbc = jdbc;
		this.vodniResursService = vodniResursService;
	}
	
	public boolean posaljiPoziv(PozivInspekcije poziv) {
		if(poziv.getRazlog() == null || poziv.getRazlog().isEmpty()) {
			return false;
		}
		
		if(!vodniResursService.vodniResursExists(poziv.getIdVodnogResursa())) {
			return false;
		}
		
		String imePrijavljivaca = null;
		
		String sql = "INSERT INTO prijava_za_inspekcijski_pregled"
				+ " (razlog_prijave_za_inspekciju, id_vodnog_resursa, ime_prijavljivaca, datum_prijave_za_inspekciju)"
				+ " VALUES (?, ?, ?, now())";
		
		try {
			return jdbc.update(sql, poziv.getRazlog(), poziv.getIdVodnogResursa(), imePrijavljivaca) == 1;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
}
