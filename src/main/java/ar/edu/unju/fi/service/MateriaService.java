package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Materia;

public interface MateriaService {
	public void guardarMateria(Materia materia);
	public List<Materia> mostrarMaterias();
}
