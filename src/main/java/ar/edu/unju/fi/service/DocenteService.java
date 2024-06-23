package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Docente;

@Service 
public interface DocenteService {
	
	public void guardarDocente(Docente docente);
	public List<Docente> mostrarDocentes();
	public void borrarDocente(String legajo);
	public void modificarDocente(Docente docente);
	public Docente buscarDocente(String legajo);

}
