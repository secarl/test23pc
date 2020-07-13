package com.mitocode.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mitocode.DemoWebApplication;

public class PersonaRepoImpl {

	private static Logger LOG = LoggerFactory.getLogger(DemoWebApplication.class);
	
	//@Override
	public void registrar(String nombre) {
		LOG.info("Hola "+ nombre);
	}
}
