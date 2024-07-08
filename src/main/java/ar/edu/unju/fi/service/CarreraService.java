package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Carrera;

@Service
public interface CarreraService {
	
	public void guardarCarrera(Carrera carrera);
	public List<Carrera> mostrarCarreras();
	public void borrarCarrera(String codigo);
	public void modificarCarrera(Carrera carreraModificada);
	public Carrera buscarCarrera(String codigo);
	public Carrera GetCarreraByCodigo(String codigo);
	void borrarRelaciones(Carrera carrera);

}