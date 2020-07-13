package com.mitocode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer>{
	
	//void registrar(String nombre);

}
