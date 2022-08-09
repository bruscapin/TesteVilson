package com.aulas.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aulas.entidades.Gato;
import com.aulas.repository.GatoRepository;

@Controller
@RequestMapping("/")

public class GatoController {
	
	
	@Autowired
	private GatoRepository repo;
	
	@GetMapping
	public String index() {
		return "index";
	}
	@GetMapping("/cadastro")
	public String formCadastro() {
		return "cadastro";

	}
	@GetMapping("/consulta")
	public String formConsulta(Model model) {
		Iterable<Gato> gatos = repo.findAll();
		model.addAttribute("gatos",gatos);
		return "consulta";

	}
	
	@GetMapping("/consulta/{idgato}")
	public String formEditar (@PathVariable("idgato")int id,Model model) {
		Gato gato = repo.findById(id).get();	
		model.addAttribute("gato",gato);
		return "edicao";
	}
	
	@PostMapping("/cadastro")
	public String salvar (Gato gato) {
		//gato.setId(gatos.size()+1);
		//gatos.add(gato);	
		repo.save(gato);
		return "redirect:/consulta";
		
	}
	
	@GetMapping("/delete/{idcontato}")
	public String delete(@PathVariable("idgato")int id) {
		repo.deleteById(id);
		return "redirect:consulta";
	}







}
