package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Docente {
	 private String legajo;
	 private String nombre;
	 private String apellido;
	 private String email;
	 private String telefono;
	 private boolean estado;
	    
}