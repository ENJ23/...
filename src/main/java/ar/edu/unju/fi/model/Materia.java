package ar.edu.unju.fi.model;

import lombok.Data;

@Data
public class Materia {
    private String codigo;
    private String nombre;
    private String curso;
    private Integer cantidad;
    private Boolean modalidad;
}