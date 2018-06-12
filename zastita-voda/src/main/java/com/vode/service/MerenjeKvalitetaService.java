package com.vode.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.vode.entity.MerenjeKvaliteta;
import com.vode.entity.ParametarMerenja;

@Component
public class MerenjeKvalitetaService {
	
	private JdbcTemplate jdbc;
	
	public MerenjeKvalitetaService(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	public ArrayList<MerenjeKvaliteta> najnovijihN(int n) {
		String query = "SELECT merenje.id_merenja, merenje.datum_merenja, resurs.naziv_vodnog_resursa, param.vrednost_parametra_merenja, tip.naziv_tipa_parametra, tip.sifra_parametra, tip.minimalna_standardna_vrednost_parametra, tip.maksimalna_standardna_vrednost_parametra"
					+ " FROM merenje_kvaliteta merenje"
					+ "   LEFT JOIN parametar_merenja param ON merenje.id_merenja = param.id_merenja"
					+ "   LEFT JOIN tip_parametra tip ON param.sifra_parametra = tip.sifra_parametra"
					+ "   LEFT JOIN vodni_resurs resurs ON merenje.id_vodnog_resursa = resurs.id_vodnog_resursa"
					+ " ORDER BY merenje.datum_merenja"
					+ " LIMIT " + n;
		
		SqlRowSet result = jdbc.queryForRowSet(query);
		
		ArrayList<MerenjeKvaliteta> ret = new ArrayList<>();
		
		HashMap<Integer, MerenjeKvaliteta> merenja = new HashMap<>();
		
		while(result.next()) {
			Integer idMerenja = result.getInt(result.findColumn("id_merenja"));
			Date datumMerenja = result.getDate(result.findColumn("datum_merenja"));
			String imeVodnogResursa = result.getString(result.findColumn("naziv_vodnog_resursa"));
			Double vrednostMerenja = result.getDouble(result.findColumn("vrednost_parametra_merenja"));
			String nazivTipaParametra = result.getString(result.findColumn("naziv_tipa_parametra"));
			String sifraTipaParametra = result.getString(result.findColumn("sifra_parametra"));
			Double minimalnaVrednost = result.getDouble(result.findColumn("minimalna_standardna_vrednost_parametra"));
			Double maksimalnaVrednost = result.getDouble(result.findColumn("maksimalna_standardna_vrednost_parametra"));
			
			MerenjeKvaliteta merenje = null;
			
			if(merenja.get(idMerenja) != null) {
				merenje = merenja.get(idMerenja);
			}
			else {
				merenje = new MerenjeKvaliteta();
				merenje.setDatumMerenja(datumMerenja);
				merenje.setImeVodnogResursa(imeVodnogResursa);
				merenja.put(idMerenja, merenje);
			}
			
			ParametarMerenja param = new ParametarMerenja();
			param.setSifraParametra(sifraTipaParametra);
			param.setMinimalnaStandardnaVrednostParametra(minimalnaVrednost);
			param.setMaksimalnaStandardnaVrednostParametra(maksimalnaVrednost);
			param.setNazivTipaParameta(nazivTipaParametra);
			param.setVrednost(vrednostMerenja);
			
			merenje.addParametarMerenja(param);
		}
		
		for(Entry<Integer, MerenjeKvaliteta> entry : merenja.entrySet()) {
			ret.add(entry.getValue());
		}
		
		return ret;
	}
	
}
