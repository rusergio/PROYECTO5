/**
 * 
 */
package AUXILIAR;

import java.util.ArrayList;

import MODELO.Consultorio;
import MODELO.Embarazada;
import MODELO.Enfermera;
import MODELO.Medico;
import MODELO.Paciente;

/**
 * @author Rui Sergio Mané
 *
 */
public class Datos {
	
	private ArrayList<Consultorio> consultorios;
	private ArrayList<Medico> medicos;
	private ArrayList<Enfermera> enfermeras;
	private ArrayList<Paciente> pacientes;
	private ArrayList<Embarazada> embarazadas;
	
	private static Datos instancia;
	
	public static Datos getInstancia() {
		
		if(instancia == null)
			instancia = new Datos();
		
		return instancia;
	}
	
	
	public Datos() {
		consultorios = new ArrayList<Consultorio>();
		medicos = new ArrayList<Medico>();
		enfermeras = new ArrayList<Enfermera>();
		pacientes = new ArrayList<Paciente>();
		embarazadas = new ArrayList<Embarazada>();
	}
	
	/* 
	 * PARA LOS CONSULTORIOS 
	 */
	
	public void cargarConsultorios(){
		
		consultorios = new ArrayList<Consultorio>();
		
		consultorios.add(new Consultorio(10, "Policlinico Nguyén Van Troi", "Ernesto Manuel Peña"));
		consultorios.add(new Consultorio(11, "Policlinico de Blanco", "Luis Santos Perez"));
		consultorios.add(new Consultorio(12, "Policlinico Docente Reina", "Caterine Espinoza"));
		consultorios.add(new Consultorio(13, "Policlinico Girón", "Samanta Martinez"));
		consultorios.add(new Consultorio(14, "Policlinico Zulueta", "Roberto Hernandez"));
		consultorios.add(new Consultorio(15, "Policlinico Universitario Rampa", "Amanda Lopez"));
		consultorios.add(new Consultorio(16, "Policlinico 14 de Junio", "Felipe Gamboa"));
		consultorios.add(new Consultorio(17, "Policlinico Docente Tomas Romay", "Eduard Camello"));
		consultorios.add(new Consultorio(18, "Policlinico 1ro de Enero", "Isabel Ñuñes"));
		consultorios.add(new Consultorio(19, "Policlinico Cerro", "Yolanda Williams"));
		consultorios.add(new Consultorio(20, "Policlinico Moncada", "Liliani Ortiz"));
	
	}
	
	public ArrayList<Consultorio> obtenerConsultorios(){
		return consultorios;
	}
	
	public void insertarConsultorio(Consultorio c) {
		consultorios.add(c);
	}
	
	/*
	 * PARA LOS MEDICOS
	 */
	
	public void cargarMedicos(){
		
		medicos = new ArrayList<Medico>();

		medicos.add(new Medico(30, "Ana Maria Sanchez", "88021603251", "11-04-2022"));
		medicos.add(new Medico(31, "Daniel Pando", "79072630024", "26-05-2023"));
		medicos.add(new Medico(32, "Miguel Angel Nato", "91105860392", "17-02-2023"));
		medicos.add(new Medico(33, "Kasandra Bellos Montes", "93023106247", "22-03-2023"));
		medicos.add(new Medico(34, "Victor Sardiña", "91036520550", "19-09-2022"));
		
		cargarConsultorios();
		// MEDICO EN LA POSICION 0
					medicos.get(0).asigConsultorio(obtenerConsultorios().get(0));
					medicos.get(0).asigConsultorio(obtenerConsultorios().get(4));
					medicos.get(0).asigConsultorio(obtenerConsultorios().get(2));
					medicos.get(0).asigConsultorio(obtenerConsultorios().get(1));
					// MEDICO EN LA POSICION 1
					medicos.get(1).asigConsultorio(obtenerConsultorios().get(3));
					medicos.get(1).asigConsultorio(obtenerConsultorios().get(5));
					medicos.get(1).asigConsultorio(obtenerConsultorios().get(6));
					// MEDICO EN LA POSICION 2
					medicos.get(2).asigConsultorio(obtenerConsultorios().get(7));
					medicos.get(2).asigConsultorio(obtenerConsultorios().get(0));
					// MEDICO EN LA POSICION 3
					medicos.get(3).asigConsultorio(obtenerConsultorios().get(2));
					medicos.get(3).asigConsultorio(obtenerConsultorios().get(7));
					medicos.get(3).asigConsultorio(obtenerConsultorios().get(6));
					// MEDICO EN LA POSICION 4
					medicos.get(4).asigConsultorio(obtenerConsultorios().get(9));
					medicos.get(4).asigConsultorio(obtenerConsultorios().get(8));
					medicos.get(4).asigConsultorio(obtenerConsultorios().get(10));
	}
	
	
	public ArrayList<Medico> obtenerMedicos(){
		return medicos;
	}
	
	public void insertarMedico(Medico m) {
		medicos.add(m);
	}
	
	/*
	 * PARA LAS ENFERMERAS 
	 */
	
	public void cargarEnfermeras(){
		
		enfermeras = new ArrayList<Enfermera>();
		
		enfermeras.add(new Enfermera("Keyla Sofia Revost", "82120806002", true, 10, "15-07-2014"));
		enfermeras.add(new Enfermera("Talia Alfonso Guimenez", "84120806002", true, 13, "18-05-2012"));
		enfermeras.add(new Enfermera("Catia Montero", "79022800210", true, 18, "25-08-2002"));
		enfermeras.add(new Enfermera("Laura Batista", "80110705002", false, 16, "03-01-2008"));
		enfermeras.add(new Enfermera("Manuela Forbes", "90070806002", true, 7, "08-11-2013"));
		enfermeras.add(new Enfermera("Pablo Guterres", "88022506002", false, 12, "20-09-2011"));
		enfermeras.add(new Enfermera("Atonieta Montes ", "74100906002", true, 20, "10-10-1999"));
		
		cargarConsultorios();
		
		// ENFERMERA EN LA POSICION 0
		enfermeras.get(0).asigConsultorio(obtenerConsultorios().get(2));
		enfermeras.get(0).asigConsultorio(obtenerConsultorios().get(0));
		enfermeras.get(0).asigConsultorio(obtenerConsultorios().get(3));
		// ENFERMERA EN LA POSICION 1
		enfermeras.get(1).asigConsultorio(obtenerConsultorios().get(5));
		enfermeras.get(1).asigConsultorio(obtenerConsultorios().get(8));
		// ENFERMERA EN LA POSICION 2
		enfermeras.get(2).asigConsultorio(obtenerConsultorios().get(4));
		enfermeras.get(2).asigConsultorio(obtenerConsultorios().get(7));
		enfermeras.get(2).asigConsultorio(obtenerConsultorios().get(6));
		// ENFERMERA EN LA POSICION 3
		enfermeras.get(3).asigConsultorio(obtenerConsultorios().get(3));
		enfermeras.get(3).asigConsultorio(obtenerConsultorios().get(4));
		// ENFERMERA EN LA POSICION 4
		enfermeras.get(4).asigConsultorio(obtenerConsultorios().get(6));
		enfermeras.get(4).asigConsultorio(obtenerConsultorios().get(10));
		// ENFERMERA EN LA POSICION 5
		enfermeras.get(5).asigConsultorio(obtenerConsultorios().get(7));
		enfermeras.get(5).asigConsultorio(obtenerConsultorios().get(9));
		enfermeras.get(5).asigConsultorio(obtenerConsultorios().get(0));
		// ENFERMERA EN LA POSICION 6
		enfermeras.get(6).asigConsultorio(obtenerConsultorios().get(8));
		enfermeras.get(6).asigConsultorio(obtenerConsultorios().get(10));
		 
	}
	
	public ArrayList<Enfermera> obtenerEnfermera(){
		return enfermeras;
	}
	
	public void insertarEnfermera(Enfermera e) {
		enfermeras.add(e);
	}
	
	/*
	 * PARA LOS PACIENTES 
	 */
	
	public void cargarPacientes(){
		
		pacientes = new ArrayList<Paciente>();
		
		pacientes.add(new Paciente("0023"," Andrea Davila Antonios", 32, "F", "Enfermedades cardiovasculares", "no tiene que vacunar"));
		pacientes.add(new Paciente("0024"," Laura Quinonez Garcia", 24, "F", "Cáncer", "no tiene q vacunar"));
		pacientes.add(new Paciente("0025"," Daniel Zambrano Espino", 41, "M", "Enfermedades hepáticas", "no tiene q vacunar "));
		pacientes.add(new Paciente("0026"," Estela Huerta Espinosa", 19, "F", "Cáncer", "no tiene que vacunar"));
		pacientes.add(new Paciente("0027"," Luis Flores Sanchez", 28, "M", "Enfermedades cardiovasculares", "no tiene que vacunar"));
		pacientes.add(new Paciente("0028"," Maria Carlota SAnchez Perez", 25, "F", "Enfermedades cardiovasculares", "no tiene que vacunar"));
		pacientes.add(new Paciente("0029"," Alberto Martinez Vazquez", 33, "M", "Enfermedades cardiovasculares", "no tiene que vacunar"));
		pacientes.add(new Paciente("0030"," Jose Pedro Valle", 35, "M", "Enfermedades respiratorias", "no tiene que vacunar"));
		/*pacientes.add(new Paciente("0031"," Juan Carlos Espinoza Campos", 46, "M", "Enfermedades respiratorias", "no tiene que vacunar"));
		pacientes.add(new Paciente("0032"," Casandra Gavilan Gonzalez", 52, "F", "Enfermedades hepáticas", "no tiene que vacunar"));
		pacientes.add(new Paciente("0033"," Juan Vazquez Perez", 42, "M", "Enfermedades neurológicas", "no tiene que vacunar"));
		pacientes.add(new Paciente("0034"," Franchesco Daniel Nunez Perez", 22, "M", "Enfermedades hepáticas", "no tiene que vacunar"));
		pacientes.add(new Paciente("0035"," Abigail Andrade Beltran", 17, "F", "Enfermedades hepáticas", "no tiene que vacunar"));
		pacientes.add(new Paciente("0036"," Dionicio Espino Espinoza", 37, "M", "Enfermedades hepáticas", "no tiene que vacunar"));
		pacientes.add(new Paciente("0037"," Miguel Luis Flores Sanchez", 40, "M", "Enfermedades hepáticas", "no tiene que vacunar"));*/
		
	}
	
	public ArrayList<Paciente> obtenerPacientes(){
		return pacientes;
	}
	
	public void insertarPaciente(Paciente p) {
		pacientes.add(p);
	}
	
	/*
	 * PARA PACIENTES EMBARAZADAS 
	 */
	
	public void CargarEmbarazadas(){
		
		embarazadas = new ArrayList<Embarazada>();
		
		embarazadas.add(new Embarazada("023PE", "Sara Finea Matos", 18, "F", "", "", "02-12-2022"));
		embarazadas.add(new Embarazada("024PE", "Catia Silva Perreira", 30, "F", "", "", "15-10-2022"));
		embarazadas.add(new Embarazada("025PE", "Syntia Mogueira Pires ", 22, "F", "", "", "04-06-2022"));
		embarazadas.add(new Embarazada("026PE", "Julieta Tavares Sambu", 31, "F", "", "", "19-04-2022"));
		embarazadas.add(new Embarazada("027PE", "Eurenia Lopes Fernandes", 28, "F", "", "", "30-07-2022"));
		
	}
	
	public ArrayList<Embarazada> obtenerEmbarazadas(){
		return embarazadas;
	}
	
	public void insertarEmbarazada(Embarazada e) {
		embarazadas.add(e);
	}
	
}
