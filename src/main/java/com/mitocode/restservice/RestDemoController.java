package com.mitocode.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.Persona;
import com.mitocode.repository.IPersonaRepo;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class RestDemoController {

	@Autowired
	private IPersonaRepo repo;
	
	@GetMapping
	public List<Persona> listar(){
		return repo.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Persona buscar(@PathVariable("id") Integer id){
		return repo.getOne(id);
	}
	
	//@PostMapping
	//public void insertar(@RequestBody Persona per) {
	//	repo.save(per);
//	}

@PostMapping
public void insertar(@RequestBody Persona per) throws Exception {
	if (per.getNombre() == null || per.getNombre().isEmpty()) {
		throw new Exception("Error en el nombre");
	}
	repo.save(per);
}

	@PutMapping
	public void actualizar(@RequestBody Persona per) {
		repo.save(per);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
	
	
}
