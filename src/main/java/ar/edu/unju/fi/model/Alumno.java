package ar.edu.unju.fi.model;

import lombok.Data;
import java.util.Calendar;

@Data
public class Alumno {
	private String dni;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private Calendar fechadenacimiento;
	private String domicilio;
	private String lu;
}
