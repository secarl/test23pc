package com.mitocode.controller;


import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mitocode.model.Persona;
import com.mitocode.repository.IPersonaRepo;

@Controller
public class DemoController {
	
	@Autowired
	private IPersonaRepo repo;
	
	private final AtomicInteger contador = new AtomicInteger();

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	
		
		//logica
		Persona p = new Persona();
		p.setIdPersona(contador.incrementAndGet());
		p.setNombre(name);
		repo.save(p);
		
		
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@GetMapping("/listar")
	public String greeting(Model model) {
		
		model.addAttribute("personas", repo.findAll());
		return "greeting";
	}
	
	@GetMapping("/buscar")
	public String greeting(@RequestParam(name="id", required=true) Integer id, Model model) {
		
		model.addAttribute("persona", repo.getOne(id));
		return "greeting";
	}
	
}
