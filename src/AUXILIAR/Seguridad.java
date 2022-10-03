/**
 * 
 */
package AUXILIAR;

/**
 * @author Rui Sergio Mané
 *
 */
public class Seguridad {
	String usuario ="rsergio";
	String contraseña ="consulta";
	
	public Seguridad() {
		
	}
	
	public boolean comprobar(String usuario, String contraseña) {
		boolean respuesta = false;
		
		if(this.usuario.equalsIgnoreCase(usuario) && 
				this.contraseña.equalsIgnoreCase(contraseña)) {
			respuesta = true;
		}
			
		return respuesta;
	}
}
