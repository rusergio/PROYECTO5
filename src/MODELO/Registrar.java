/**
 * 
 */
package MODELO;

import java.util.ArrayList;

import AUXILIAR.Datos;

/**
 * @author Rui Sergio Mané
 *
 */


public class Registrar {
	
	private static Registrar instancia;
	
	public static Registrar getInstancia() {
		
		if(instancia == null)
			instancia = new Registrar();
		
		return instancia;
	}
	
	public Registrar() {
		
	}
	
	public  void registrarEmbarazada(int index, ArrayList<Embarazada> list) {
		
		for(int i = index; i < list.size(); i++) {
			Object[] fila = {
					Datos.getInstancia().obtenerEmbarazadas().get(i).getNumHist(),
					Datos.getInstancia().obtenerEmbarazadas().get(i).getNombre(),
					Datos.getInstancia().obtenerEmbarazadas().get(i).getEdad(),
					Datos.getInstancia().obtenerEmbarazadas().get(i).getSexo(),
					Datos.getInstancia().obtenerEmbarazadas().get(i).getEnfermedad(),
					Datos.getInstancia().obtenerEmbarazadas().get(i).getVacunacion(),
					Datos.getInstancia().obtenerEmbarazadas().get(i).getFechCitolog()
			};
			VISTA.RegistroEmbarazada.model.addRow(fila);
		}
	}
	
	public static void registrarPaciente(int index, ArrayList<Paciente> list) {
		
		
		for(int i = index; i < list.size(); i++) {
			
			Object[] fila = {
					Datos.getInstancia().obtenerPacientes().get(i).getNumHist(),
					Datos.getInstancia().obtenerPacientes().get(i).getNombre(),
					Datos.getInstancia().obtenerPacientes().get(i).getEdad(),
					Datos.getInstancia().obtenerPacientes().get(i).getSexo(),
					Datos.getInstancia().obtenerPacientes().get(i).getEnfermedad(),
					Datos.getInstancia().obtenerPacientes().get(i).getVacunacion(),
			};
			VISTA.RegistroPaciente.model.addRow(fila);
		}
		
	}
	
	public void registrarConsultorio(int index, ArrayList<Consultorio> list) {
		
		for(int i = index; i < list.size(); i++) {
			
			Object[] fila = {
					Datos.getInstancia().obtenerConsultorios().get(i).getNumero(),
					Datos.getInstancia().obtenerConsultorios().get(i).getNombPoliclin(),
					Datos.getInstancia().obtenerConsultorios().get(i).getNombDirector()
			};
			
			VISTA.RegistroConsultorio.model.addRow(fila);
		}
	}
	
	public void registrarEnfermera(int index, ArrayList<Enfermera> list) {
		
		  for(int i = index; i < list.size(); i++) {
				
			  Object[] fila = {
					  Datos.getInstancia().obtenerEnfermera().get(i).getNumId(),
					  Datos.getInstancia().obtenerEnfermera().get(i).getNombre(),
					  Datos.getInstancia().obtenerEnfermera().get(i).isTieneLicenciatur(),
					  Datos.getInstancia().obtenerEnfermera().get(i).getAniosExperiencia(),
					  Datos.getInstancia().obtenerEnfermera().get(i).getFechComienzo()
				};
				VISTA.RegistroEnfermera.model.addRow(fila); 
			}
		
	}
	
	public void registrarMedico(int index, ArrayList<Medico> list) {
		
		
		  for(int i = index; i < list.size(); i++) {
				
			  Object[] fila = {
						Datos.getInstancia().obtenerMedicos().get(i).getNumRegistro(),
						Datos.getInstancia().obtenerMedicos().get(i).getNomComplet(),
						Datos.getInstancia().obtenerMedicos().get(i).getIdMedico(),
						Datos.getInstancia().obtenerMedicos().get(i).getFechaAlta()
				};
				VISTA.RegistroMedico.model.addRow(fila); 
			}
		
	}
	
}
