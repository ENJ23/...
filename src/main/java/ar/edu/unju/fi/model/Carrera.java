package ar.edu.unju.fi.model;

import lombok.Data;

@Data
public class Carrera {
	private String codigo;
    private String nombre;
    private Integer cantidadAnios;
    private Boolean estado;
    
}
