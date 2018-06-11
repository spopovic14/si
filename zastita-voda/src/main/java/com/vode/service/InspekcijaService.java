package com.vode.service;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.vode.entity.Inspekcija;

@Component
public class InspekcijaService {
	
	public static final int MAX_RESULTS = 50;
	
	private JdbcTemplate jdbc;
	
	public InspekcijaService(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	public ArrayList<Inspekcija> najnovijihN(int n) {
		if(n <= 0) {
			n = 1;
		}
		
		if(n > MAX_RESULTS) {
			n = MAX_RESULTS;
		}
		
		String query = "SELECT resurs.naziv_vodnog_resursa, prijava.datum_prijave_za_inspekciju, prijava.razlog_prijave_za_inspekciju, prijava.datum_odluke_za_prijavu_inspekcije, inspekcija.datum_pregleda, inspekcija.ime_inspektora, inspekcija.izvestaj_pregleda"
					+ " FROM prijava_za_inspekcijski_pregled prijava"
					+ "   LEFT JOIN vodni_resurs resurs ON prijava.id_vodnog_resursa = resurs.id_vodnog_resursa"
					+ "   LEFT JOIN inspekcijski_pregled inspekcija ON prijava.id_prijave = inspekcija.id_prijave"
					+ " WHERE inspekcija.id_pregleda IS NOT NULL"
					+ " ORDER BY inspekcija.datum_pregleda DESC"
					+ " LIMIT " + n;
		
		SqlRowSet result = jdbc.queryForRowSet(query);
		
		ArrayList<Inspekcija> ret = new ArrayList<>();
		
		while(result.next()) {
			String nazivVodnogResursa = result.getString(result.findColumn("naziv_vodnog_resursa"));
			Date datumPrijave = result.getDate(result.findColumn("datum_prijave_za_inspekciju"));
			Date datumPrihvatanja = result.getDate(result.findColumn("datum_odluke_za_prijavu_inspekcije"));
			Date datumInspekcije = result.getDate(result.findColumn("datum_pregleda"));
			String razlogPrijave = result.getString(result.findColumn("razlog_prijave_za_inspekciju"));
			String imeInspektora = result.getString(result.findColumn("ime_inspektora"));
			String izvestaj = result.getString(result.findColumn("izvestaj_pregleda"));
			
			Inspekcija inspekcija = new Inspekcija();
			inspekcija.setImeVodnogResursa(nazivVodnogResursa);
			inspekcija.setDatumPrijave(datumPrijave);
			inspekcija.setDatumPregleda(datumInspekcije);
			inspekcija.setDatumOdobravanja(datumPrihvatanja);
			inspekcija.setRazlogPrijave(razlogPrijave);
			inspekcija.setImeInspektora(imeInspektora);
			inspekcija.setIzvestaj(izvestaj);
			
			ret.add(inspekcija);
		}
		
		return ret;
	}
	
}
