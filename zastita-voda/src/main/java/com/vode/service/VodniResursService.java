package com.vode.service;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.vode.entity.VodniResurs;

@Component
public class VodniResursService {
	
	private JdbcTemplate jdbc;
	
	public VodniResursService(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	public boolean vodniResursExists(Long id) {
		String query = "SELECT 1 FROM vodni_resurs WHERE id_vodnog_resursa = ?";
		
		try {
			SqlRowSet result = jdbc.queryForRowSet(query, id);
			return result.next();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public String getVodniResursName(long vodniResursId) {
		String query = "SELECT ime_vodnog_resursa FROM vodni_resurs WHERE id_vodnog_resursa = ?";
		
		try {
			SqlRowSet result = jdbc.queryForRowSet(query, vodniResursId);
			if(result.next()) {
				return result.getString(1);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<VodniResurs> sviVodniResursi() {
		String query = "SELECT id_vodnog_resursa, naziv_vodnog_resursa, lokacija_vodnog_resursa"
					+ " FROM vodni_resurs";
		
		SqlRowSet result = jdbc.queryForRowSet(query);
		
		ArrayList<VodniResurs> ret = new ArrayList<>();
		
		while(result.next()) {
			Long idVodnogResursa = result.getLong(result.findColumn("id_vodnog_resursa"));
			String nazivVodnogResursa = result.getString(result.findColumn("naziv_vodnog_resursa"));
			String lokacijaVodnogResursa = result.getString(result.findColumn("lokacija_vodnog_resursa"));
			
			VodniResurs resurs = new VodniResurs();
			resurs.setId(idVodnogResursa);
			resurs.setNaziv(nazivVodnogResursa);
			resurs.setLokacija(lokacijaVodnogResursa);
			
			ret.add(resurs);
		}
		
		return ret;
	}
}
