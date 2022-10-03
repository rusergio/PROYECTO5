/**
 * 
 */
package MODELO;

import java.util.ArrayList;

/**
 * @author Rui Sergio Mané
 *
 */
public class Paciente {
	private String numHist;
	private String nombre;
	private int edad;
	private String sexo;
	private String enfermedad;
	private String vacunacion;
	private ArrayList<Consultorio> consultorios;
	private ArrayList<Medico> medicos;
	private ArrayList<Enfermera> enfermeras;
	
	
	public Paciente(String numHist, String nombre, int edad, String sexo,
			String enfermedad, String vacunacion) {
		
		setNumPaciente(numHist);
		setNombre(nombre);
		setEdad(edad);
		setSexo(sexo);
		setEnfermedad(enfermedad);
		setVacunacion(vacunacion);
		
		consultorios = new ArrayList<>();
		
	}
	
	public String getNumHist() {
		return numHist;
	}
	public void setNumPaciente(String numHist) {
		this.numHist = numHist;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}
	public String getVacunacion() {
		return vacunacion;
	}
	public void setVacunacion(String vacunacion) {
		this.vacunacion = vacunacion;
	}
	public void asigConsultorio(Consultorio c) {
		consultorios.add(c);
	}
	public ArrayList<Consultorio> getConsultAsig(){
		return consultorios;
	}
	
	public void asigMedico(Medico c) {
		medicos.add(c);
	}
	public ArrayList<Medico> getMedicosAsig(){
		return medicos;
	}
	
	public ArrayList<Enfermera> getEnfermasAsig(){
		return enfermeras;
	}
	
	
	
	
}
