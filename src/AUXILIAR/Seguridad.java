/**
 * 
 */
package AUXILIAR;

/**
 * @author Rui Sergio Man�
 *
 */
public class Seguridad {
	String usuario ="rsergio";
	String contrase�a ="consulta";
	
	public Seguridad() {
		
	}
	
	public boolean comprobar(String usuario, String contrase�a) {
		boolean respuesta = false;
		
		if(this.usuario.equalsIgnoreCase(usuario) && 
				this.contrase�a.equalsIgnoreCase(contrase�a)) {
			respuesta = true;
		}
			
		return respuesta;
	}
}
