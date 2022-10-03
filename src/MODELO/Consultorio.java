/**
 * 
 */
package MODELO;

import java.util.ArrayList;

/**
 * @author Rui Sergio Mané
 *
 */
public class Consultorio {
	private int numero;
	private String nombPoliclin;
	private String nombDirector;
	private ArrayList<Medico>listamedicos;
	private ArrayList<Enfermera> listaenfermeras;
	
	public Consultorio(int numero, String nombPoliclin, String nombDirector) {
		super();
		setNumero(numero);
		setNombPoliclin(nombPoliclin);
		setNombDirector(nombDirector);
		listamedicos = new ArrayList<Medico>();
		listaenfermeras = new ArrayList<Enfermera>();
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNombPoliclin() {
		return nombPoliclin;
	}
	public void setNombPoliclin(String nombPoliclin) {
		this.nombPoliclin = nombPoliclin;
	}
	public String getNombDirector() {
		return nombDirector;
	}
	public void setNombDirector(String nombDirector) {
		this.nombDirector = nombDirector;
	}
	
	// for doctor
	public void addMedico(Medico m) {
		listamedicos.add(m);
	}
	public Medico getMedico(int pos) {
		return listamedicos.get(pos);
	}
	public int cantMed() {
		return listamedicos.size();
	}
	public ArrayList<Medico> listMedico(){
		return listamedicos;
	}
	
	// for the nurse
	public void addEnfermera(Enfermera e) {
		this.listaenfermeras.add(e);
	}
	public Enfermera getMujer(int index) {
		return listaenfermeras.get(index);
	}
	public int cantMujeres() {
		return listaenfermeras.size();
	}
	
	
	
}
