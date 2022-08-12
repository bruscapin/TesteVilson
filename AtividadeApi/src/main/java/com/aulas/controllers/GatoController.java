package com.aulas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulas.entidades.Gato;
import com.aulas.repository.GatoRepository;

@RestController
@RequestMapping("/")
public class GatoController {
	@Autowired
	GatoRepository repo;
	
	@GetMapping("/gatos")
	public ResponseEntity<Iterable<Gato>> getGatos() {
		Iterable<Gato> gatos = repo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(gatos);
	}
	
	@GetMapping("/gatos/{idgato}")
	public ResponseEntity<Gato> getGatosById(@PathVariable("idgato") Long idgato) {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findById(idgato).get());
	}
	
	@PostMapping("/gatos")
	public ResponseEntity <Gato> saveGato(@RequestBody Gato gato) {
		Gato gt = repo.save(gato);
		return ResponseEntity.status(HttpStatus.CREATED).body(gt);
	}

	@DeleteMapping("/gatos/{idgato}")
	public ResponseEntity<Void> deleteGato(@PathVariable("idgato") Long idgato) {
		repo.deleteById(idgato);
		return ResponseEntity.noContent().build();
	}
	@PutMapping("/gatos/{idgato}")
	public ResponseEntity<Gato> alteraGato(@PathVariable("idgato") Long idgato,
			@RequestBody Gato gato) {
		
		return ResponseEntity.ok(repo.save(gato));
	}
	
	
	

		
		
		
		
		
		
		
		
		
		
		
}
