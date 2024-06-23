package ar.edu.unju.fi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.service.MateriaService;


@Controller
public class MateriaController {
	
	@Autowired
	Materia nuevaMateria;
	
	@Autowired
	MateriaService materiaService;
	
	@GetMapping("/formularioMateria")
	public ModelAndView getFormMateria() {
		ModelAndView modelView = new ModelAndView("formMateria");
		modelView.addObject("nuevaMateria", nuevaMateria);	
		modelView.addObject("band", false);
		return modelView;
	}
	
	//@GetMapping("/formularioMateria")
    //public ModelAndView getFormMateria() {
        //ModelAndView modelView = new ModelAndView("formMateria");
       // modelView.addObject(new Materia());

        //return modelView;
    //}
    @PostMapping("/guardarMateria")
	public ModelAndView saveMateria(@ModelAttribute("nuevaMateria") Materia materiaParaGuardar) {

		materiaService.guardarMateria(materiaParaGuardar);

		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMaterias", materiaService.mostrarMaterias());

		return modelView;		
	}
    
}