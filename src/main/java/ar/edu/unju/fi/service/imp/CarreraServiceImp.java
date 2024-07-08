package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.map.CarreraMapDTO;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.service.CarreraService;

@Service
public class CarreraServiceImp implements CarreraService{

	
    private static final Logger LOGGER = LoggerFactory.getLogger(CarreraServiceImp.class);

	@Autowired
	CarreraRepository carreraRepository;
	
	
	@Autowired
	CarreraMapDTO carreraMapDTO;
	
	@Override
	public void guardarCarrera(Carrera carrera) {
		 
		LOGGER.info("Iniciando método guardarCarrera");
	        carrera.setEstado(true);
	        carreraRepository.save(carrera);
	        LOGGER.info("Carrera guardada exitosamente");
	}

	@Override
	public List<Carrera> mostrarCarreras() {
		// TODO Auto-generated method stub
		LOGGER.info("Mostrando todas las carreras activas");		
		return carreraRepository.findCarreraByEstado(true);
	}

	@Override
	public void borrarCarrera(String codigo) {
		LOGGER.info("Iniciando método borrarCarrera con código: " + codigo);
		List<Carrera> todasLasCarreras = carreraRepository.findAll();
		for (int i = 0; i < todasLasCarreras.size(); i++) {
		      Carrera carrera = todasLasCarreras.get(i);
		      if (carrera.getCodigo().equals(codigo)) {
		        carrera.setEstado(false);
		        carreraRepository.save(carrera);
                LOGGER.info("Carrera borrada exitosamente");
		        break;
		        
		      }
		    }
	}

	@Override
	public void modificarCarrera(Carrera carreraModificada) {
		LOGGER.info("Iniciando método modificarCarrera");
	    Carrera carreraBuscada = buscarCarrera(carreraModificada.getCodigo());
	    if (carreraBuscada != null) {
	    	
	    		carreraRepository.save(carreraModificada);
	    	}
	   
    	else {
    		LOGGER.warn("La carrera no se ha encontrado");	  
		  }
    }


	@Override
	public Carrera buscarCarrera(String codigo) {
		 LOGGER.info("Buscando carrera con código: " + codigo);
		List<Carrera> todasLasCarreras = carreraRepository.findAll();
		
		for (Carrera carrera : todasLasCarreras){
			if (carrera.getCodigo().equals(codigo)){
                LOGGER.info("Carrera encontrada");
				return carrera;
			}
		}
		return null;
	}

	@Override
	public Carrera GetCarreraByCodigo(String codigo) {
		// TODO Auto-generated method stub
        LOGGER.info("Obteniendo carrera por código: " + codigo);

		for (Carrera c : mostrarCarreras()) {
			if (c.getCodigo().equals(codigo)) {
				return c;
			}
		}
        LOGGER.warn("Carrera no encontrada por código");

		return null;
	}
	
	@Override
	public void borrarRelaciones(Carrera carrera) {
		carrera.getAlumnos().forEach(a -> a.setCarrera(null));
		carrera.getMaterias().forEach(m -> m.setCarrera(null));
		carrera.getAlumnos().clear();
		carrera.getMaterias().clear();
		carreraRepository.save(carrera);
	}
	
}