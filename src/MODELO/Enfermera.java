/**
 * 
 */
package MODELO;

import java.util.ArrayList;

/**
 * @author Rui Sergio Mané
 *
 */

public class Enfermera {
	private String nombre;
	private String numId;
	private boolean tieneLicenciatur;
	private int aniosExperiencia;
	private String fechComienzo;
	private ArrayList<Consultorio> consultorios;
	
	public Enfermera(String nombre, String numId,boolean tieneLicenciatur, 
			int aniosExperiencia, String fechComienzo) {
		
		setNombre(nombre);
		setNumId(numId);
		setFechComienzo(fechComienzo);
		setTieneLicenciatur(tieneLicenciatur);
		setAniosExperiencia(aniosExperiencia);
		
		consultorios = new ArrayList<>();
		
	}
	
	// Los metodos de acceso
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumId() {
		return numId;
	}
	public void setNumId(String numId) {
		this.numId = numId;
	}
	public String isTieneLicenciatur() {
		String tiene = "";
		
		if(tieneLicenciatur) {
			tiene = "SI";
		}
		else {
			tiene = "NO";
		}
		return tiene;
	}
	public void setTieneLicenciatur(boolean tieneLicenciatur) {
		this.tieneLicenciatur = tieneLicenciatur;
	}
	public int getAniosExperiencia() {
		return aniosExperiencia;
	}
	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}
	public String getFechComienzo() {
		return fechComienzo;
	}
	public void setFechComienzo(String fechComienzo) {
		this.fechComienzo = fechComienzo;
	}
	public void asigConsultorio(Consultorio c) {
		consultorios.add(c);
	}
	public ArrayList<Consultorio>getConsultAsig(){
		return consultorios;
	}
	
}
