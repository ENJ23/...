package ar.edu.unju.fi.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Alumno;


@Controller
public class AlumnoController {
	
	@Autowired
	Alumno nuevoAlumno; 
	@GetMapping ("/formularioAlumno")
	public ModelAndView getFormAlumno() {
		//vista formCarrera.html
		ModelAndView modelView = new ModelAndView("formAlumno");
		//Agrega el Objeto
		modelView.addObject("nuevoAlumno", nuevoAlumno);
		modelView.addObject("flag", false);
		return modelView;
	}
	
	
	@PostMapping("/guardarAlumno")
	public ModelAndView saveAlumno(@ModelAttribute("nuevoAlumno") Alumno alumnoParaGuardar) {
		
		//guardar el alumno en la lista
		
		//ListadoAlumnos.agregarAlumno(alumnoParaGuardar);
		//Mostrar Listado
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		//modelView.addObject("listadoAlumnos" , ListadoAlumnos.listarAlumnos());
		return modelView;
	}
	
	/*
	 * @GetMapping("/eliminarAlumno/{lu}") public ModelAndView
	 * borrarAlumnoDelListado (@PathVariable (name="lu") String lu) {
	 * 
	 * ListadoAlumnos.eliminarAlumno(lu);
	 * 
	 * ModelAndView modelView = new ModelAndView("listaDeAlumnos");
	 * modelView.addObject("listadoDeAlumnos", ListadoAlumnos.listarAlumnos());
	 * 
	 * return modelView; }
	 * 
	 * @GetMapping("/modificarAlumno/{lu}") public ModelAndView
	 * getFormModificarAlumno(@PathVariable(name="lu") String lu) { Alumno
	 * nuevoAlumno = ListadoAlumnos.buscarAlumnoPorLu(lu); ModelAndView
	 * modelView = new ModelAndView("formAlumno");
	 * modelView.addObject("nuevoAlumno", nuevoAlumno);
	 * modelView.addObject("flag", true); return modelView; }
	 * 
	 * @PostMapping("/modificarAlumno") public ModelAndView
	 * modificarAlumno(@ModelAttribute("nuevoAlumno") Alumno alumnoModificado) {
	 * ListadoAlumnos.modificarAlumno(alumnoModificado);
	 * alumnoModificado.setEstado(true); ModelAndView modelView = new
	 * ModelAndView("listaDeAlumnos"); modelView.addObject("listadoAlumnos",
	 * ListadoAlumnos.listarAlumnos()); return modelView; }
	 * 
	 */
}