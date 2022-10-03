/**
 * 
 */
package MODELO;

import java.util.ArrayList;

/**
 * @author Rui Sergio Mané
 *
 */
public class Medico {
	private int numRegistro;
	private String numID;
	private String nomComplet;
	private String fechaAlta;
	
	private ArrayList<Consultorio> listaconsult;
	
	public Medico(int numRegistro, String nomComplet,
			String numID, String fechaAlta) {
		
		setNumRegistro(numRegistro);
		setNomComplet(nomComplet);
		setNumID(numID);
		setFechaAlta(fechaAlta);
		listaconsult = new ArrayList<Consultorio>();
		
	}

	public String getNomComplet() {
		return nomComplet;
	}
	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}
	public int getNumRegistro() {
		return numRegistro;
	}
	public void setNumRegistro(int numRegistro) {
		this.numRegistro = numRegistro;
	}
	public String getIdMedico() {
		return numID;
	}
	public void setNumID(String numID) {
		this.numID= numID;
	}
	public String getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public void asigConsultorio(Consultorio c) {
		listaconsult.add(c);
	}
	public ArrayList<Consultorio>getConsultAsig(){
		return listaconsult;
	}
	
}
