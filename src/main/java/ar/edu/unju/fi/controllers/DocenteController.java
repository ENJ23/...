package ar.edu.unju.fi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.service.*;


@Controller
public class DocenteController {
	
	@Autowired
	Docente nuevoDocente;
	
	@Autowired
	DocenteService docenteService;
	
	@GetMapping ("/formularioDocente")
	public ModelAndView getFormDocente() {
		//vista formCarrera.html
		ModelAndView modelView = new ModelAndView("formDocente");
		//Agrega el Objeto
		modelView.addObject("nuevoDocente", nuevoDocente);
		modelView.addObject("band", false);
		return modelView;
	}
	
	@PostMapping("/guardarDocente")
	public ModelAndView saveDocente(@ModelAttribute("nuevoDocente") Docente docenteParaGuardar) {
		
		//guardar el docente en la lista
		
		//ListadoDocentes.agregarDocente(docenteParaGuardar);
		docenteService.guardarDocente(docenteParaGuardar);
		//Mostrar Listado
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		//modelView.addObject("listadoDocentes" , ListadoDocentes.listarDocentes());
		modelView.addObject("listadoDocentes", docenteService.mostrarDocentes());
		
		return modelView;
	}
	
	/*
	@GetMapping("/borrarDocente/{legajo}")
	public ModelAndView deleteDocenteDelListado(@PathVariable(name="legajo") String legajo) {
		//borrar
		//ListadoCarreras.eliminarCarrera(codigo);
		System.out.println("este es el legajo: "+legajo);
		docenteService.borrarDocente(legajo);
		
		//mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", docenteService.mostrarDocentes());	
		
		return modelView;		
		}
	*/
	
}