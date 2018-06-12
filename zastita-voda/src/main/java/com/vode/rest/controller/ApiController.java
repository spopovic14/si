package com.vode.rest.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vode.entity.Inspekcija;
import com.vode.entity.Licensa;
import com.vode.entity.MerenjeKvaliteta;
import com.vode.entity.PozivInspekcije;
import com.vode.entity.VodniResurs;
import com.vode.model.ResponseObject;
import com.vode.service.InspekcijaService;
import com.vode.service.LicensaService;
import com.vode.service.MerenjeKvalitetaService;
import com.vode.service.PozivInspekcijeService;
import com.vode.service.VodniResursService;

@RestController
@RequestMapping("/api/v1")
public class ApiController {
	
	@Autowired
	private PozivInspekcijeService pozivInspekcijeService;
	
	@Autowired
	private LicensaService licensaService;
	
	@Autowired
	private InspekcijaService inspekcijaService;
	
	@Autowired
	private VodniResursService vodniResursService;
	
	@Autowired
	private MerenjeKvalitetaService merenjeKvalitetaService;
	
	/**
	 * Pravi novi poziv inspekcije za zadati vodni resurs
	 * @param pozivInspekcije
	 * @return
	 */
	@RequestMapping(value = "/poziv-inspekcije", method = RequestMethod.POST)
	public ResponseEntity<ResponseObject> pozivInspekcije(PozivInspekcije pozivInspekcije) {
		HttpStatus status = HttpStatus.OK;
		ResponseObject responseObject = null;
		
		if(pozivInspekcijeService.posaljiPoziv(pozivInspekcije)) {
			responseObject = new ResponseObject("Zahtev uspesno poslat");
		}
		else {
			responseObject = new ResponseObject("Slanje poziva neuspesno", 400);
			status = HttpStatus.BAD_REQUEST;
		}
		
		return new ResponseEntity<ResponseObject>(responseObject, status);
	}
	
	/**
	 * Vraca sve podatke o licensama za zadato pravno lice
	 * @param pravnoLice
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/license/{pravnoLice}")
	public ResponseEntity<ResponseObject> licensePravnogLica(@PathVariable String pravnoLice) throws Exception {
		ArrayList<Licensa> license = licensaService.licensePravnogLica(pravnoLice, false);
		HttpStatus status = HttpStatus.OK;
		String message = "OK";
		
		if(license.isEmpty()) {
			message = "Nema licensi za dato ime";
		}
		
		ResponseObject obj = new ResponseObject(message, 200);
		obj.setResponse(license);
		
		return new ResponseEntity<ResponseObject>(obj, status);
	}
	
	/**
	 * Vraca sve podatke o ukinutim licensama za zadato pravno lice
	 * @param pravnoLice
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/license/{pravnoLice}/ukinute")
	public ResponseEntity<ResponseObject> ukinuteLicensePravnogLica(@PathVariable String pravnoLice) throws Exception {
		ArrayList<Licensa> license = licensaService.licensePravnogLica(pravnoLice, true);
		HttpStatus status = HttpStatus.OK;
		String message = "OK";
		
		if(license.isEmpty()) {
			message = "Nema licensi za dato ime";
		}
		
		ResponseObject obj = new ResponseObject(message, 200);
		obj.setResponse(license);
		
		return new ResponseEntity<ResponseObject>(obj, status);
	}
	
	/**
	 * Prikazuje 10 najskorijih inspekcija
	 * @return
	 */
	@RequestMapping("/inspekcije/najnovije")
	public ResponseEntity<ResponseObject> najnovijih10Inspekcija() {
		ArrayList<Inspekcija> inspekcije = inspekcijaService.najnovijihN(10);
		HttpStatus status = HttpStatus.OK;
		String message = "OK";
		
		if(inspekcije.isEmpty()) {
			message = "Nema podataka o inspekcijama";
		}
		
		ResponseObject obj = new ResponseObject(message, 200);
		obj.setResponse(inspekcije);
		
		return new ResponseEntity<ResponseObject>(obj, status);
	}
	
	/**
	 * Prikazuje sve podatke o vodnim resursima
	 * @return
	 */
	@RequestMapping("/vodni-resursi")
	public ResponseEntity<ResponseObject> vodniResursi() {
		ArrayList<VodniResurs> vodniResursi = vodniResursService.sviVodniResursi();
		HttpStatus status = HttpStatus.OK;
		String message = "OK";
		
		if(vodniResursi.isEmpty()) {
			message = "Nema podataka o vodnim resursima";
		}
		
		ResponseObject obj = new ResponseObject(message, 200);
		obj.setResponse(vodniResursi);
		
		return new ResponseEntity<ResponseObject>(obj, status);
	}
	
	/**
	 * Prikazuje najvonijih 10 merenja kvaliteta
	 * @return
	 */
	@RequestMapping("/merenja-kvaliteta")
	public ResponseEntity<ResponseObject> najnovijaMerenja() {
		ArrayList<MerenjeKvaliteta> merenja = merenjeKvalitetaService.najnovijihN(10);
		HttpStatus status = HttpStatus.OK;
		String message = "OK";
		
		if(merenja.isEmpty()) {
			message = "Nema podataka o merenjima kvaliteta";
		}
		
		ResponseObject obj = new ResponseObject(message, 200);
		obj.setResponse(merenja);
		
		return new ResponseEntity<ResponseObject>(obj, status);
	}
}
