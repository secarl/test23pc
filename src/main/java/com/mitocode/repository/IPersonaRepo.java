package com.mitocode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.mitocode.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer>{

	
	
	//void registrar(String nombre);

}
