package com.vode.service;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.vode.entity.Licensa;

@Component
public class LicensaService {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public LicensaService(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	public ArrayList<Licensa> licensePravnogLica(String nazivPravnogLica, boolean samoUkinute) throws Exception {
		String query = "SELECT tl.naziv_tipa_license, zl.zahtev_prihvacen, zl.datum_zahteva, l.datum_isticanja_license, l.mesto_izdavanja_license, pl.datum_povlacenja_license, pl.razlog_povlacenja_license, zl.datum_odluke_za_izdavanje_license, vr.naziv_vodnog_resursa"
					+ " FROM zahtev_za_licensu zl"
					+ "   LEFT JOIN licensa l ON zl.id_zahteva = l.id_license"
					+ "   LEFT JOIN tip_license tl ON zl.sifra_tipa_license = tl.sifra_tipa_license"
					+ "   LEFT JOIN povlacenje_license pl ON l.id_license = pl.id_license"
					+ "   LEFT JOIN vodni_resurs vr ON zl.id_vodnog_resursa = vr.id_vodnog_resursa"
					+ "   LEFT JOIN pravno_lice prav_l ON zl.pib_pravnog_lica = prav_l.pib_pravnog_lica AND zl.maticni_broj_preduzeca = prav_l.maticni_broj_preduzeca"
					+ " WHERE prav_l.naziv_pravnog_lica = ?"
					+ (samoUkinute? " AND pl.id_license IS NOT NULL" : "");
		
		SqlRowSet result = jdbc.queryForRowSet(query, nazivPravnogLica);
		
		ArrayList<Licensa> ret = new ArrayList<>();
		
		while(result.next()) {
			String nazivTipaLicense = result.getString(result.findColumn("naziv_tipa_license"));
			Boolean zahtevPrihvacen = result.getBoolean(result.findColumn("zahtev_prihvacen"));
			Date datumZahteva = result.getDate(result.findColumn("datum_zahteva"));
			Date datumIsticanja = result.getDate(result.findColumn("datum_isticanja_license"));
			Date datumUkidanja = result.getDate(result.findColumn("datum_povlacenja_license"));
			String razlogUkidanja = result.getString(result.findColumn("razlog_povlacenja_license"));
			String mestoIzdavanja = result.getString(result.findColumn("mesto_izdavanja_license"));
			String nazivVodnogResursa = result.getString(result.findColumn("naziv_vodnog_resursa"));
			
			Licensa licensa = new Licensa();
			licensa.setTipLicense(nazivTipaLicense);
			licensa.setLicensaIzdata(zahtevPrihvacen);
			licensa.setDatumZahteva(datumZahteva);
			licensa.setDatumIsticanja(datumIsticanja);
			licensa.setDatumUkidanja(datumUkidanja);
			licensa.setRazlogUkidanja(razlogUkidanja);
			licensa.setMestoIzdavanja(mestoIzdavanja);
			licensa.setImeVodnogResursa(nazivVodnogResursa);
			
			if(razlogUkidanja != null) {
				licensa.setLicensaPovucena(true);
			}
			
			ret.add(licensa);
		}
		
		return ret;
	}
	
}
