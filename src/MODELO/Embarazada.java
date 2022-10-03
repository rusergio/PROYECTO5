      package MODELO;

import java.util.ArrayList;

public class Embarazada extends Paciente{
	
	private String fechaCitologica ;
	private ArrayList<Consultorio> consultorios;
	private ArrayList<Medico> medicos;
	private ArrayList<Enfermera> enfermeras;
	
	public Embarazada(String numHist, String nombre,
			int edad,String sexo, String enfermedad, 
			String vacunacion, String fecha) {
		
		super(numHist, nombre, edad, sexo, enfermedad, vacunacion);
		// TODO Auto-generated constructor stub
		
		setFechCitolog(fecha);
		consultorios = new ArrayList<>();
		medicos = new ArrayList<>();
		enfermeras = new ArrayList<>();
	}
	
	public String getFechCitolog() {
		return fechaCitologica;
	}
	
	public void setFechCitolog(String fecha) {
		this.fechaCitologica = fecha;
	}
	
	public void asigConsultorio(Consultorio c) {
		consultorios.add(c);
	}
	public ArrayList<Consultorio> getConsultorioAsig(){
		return consultorios;
	}
	
	public void asigMedico(Medico m) {
		medicos.add(m);
	}
	public ArrayList<Medico> getMedicoAsig(){
		return medicos;
	}
	
	public void asigEnfermera(Enfermera e) {
		enfermeras.add(e);
	}
	public ArrayList<Enfermera> getEnfermeraAsig(){
		return enfermeras;
	}
	
}
