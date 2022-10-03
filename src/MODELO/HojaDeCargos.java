/**
 * 
 */
package MODELO;

/**
 * @author Rui Sergio Mané
 *
 */

public class HojaDeCargos {
	private String nombre;
	private int edad;
	private String direccion;
	private String diagnostico;
	
	public HojaDeCargos(String nombre, int edad, String direccion, 
			String diagnostico) {
		
		this.nombre = nombre;
		this.edad = edad;
		this.direccion = direccion;
		this.diagnostico = diagnostico;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	
	
	
}
