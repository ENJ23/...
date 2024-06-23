package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.service.DocenteService;

@Service
public class DocenteServiceImp implements DocenteService{

	@Autowired
	DocenteRepository docenteRepository;
	
	@Override
	public void guardarDocente (Docente docente) {
		// TODO Auto-generated method stub
		//carrera.setEstado(true);
		docenteRepository.save(docente);
	}

	@Override
	public List<Docente> mostrarDocentes() {
		// TODO Auto-generated method stub
		//return carreraRepository.findAll();
		return docenteRepository.findDocenteByEstado(true);
	}

	@Override
	public void borrarDocente(String legajo) {
		System.out.println("este es el legajo: "+legajo);
		// TODO Auto-generated method stub
		List<Docente> todosLosDocentes = docenteRepository.findAll();
		for (int i = 0; i < todosLosDocentes.size(); i++) {
		      Docente docente = todosLosDocentes.get(i);
		      if (docente.getLegajo().equals(legajo)) {
		        docente.setEstado(false);
		        docenteRepository.save(docente);
		        break;
		      }
		    }
	}

	@Override
	public void modificarDocente(Docente docente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Docente buscarDocente(String legajo) {
		// TODO Auto-generated method stub
		return null;
	}

}