/**
 * 
 */
package MODELO;

import java.util.Date;

/**
 * @author Rui Sergio Mané
 *
 */
public class HistoriaClinica {
	private Date fechaVisita;
	private String diagnostico;
	private String indicaciones;
	private String electCardiogram;
	private boolean omitExpecialid;
	
	public HistoriaClinica(Date fechaVisita, String diagnostico, 
			String indicaciones, String electCardiogram, 
			boolean omitExpecialid) {

		this.fechaVisita = fechaVisita;
		this.diagnostico = diagnostico;
		this.indicaciones = indicaciones;
		this.electCardiogram = electCardiogram;
		this.omitExpecialid = omitExpecialid;
	}
	
	public Date getFechaVisita() {
		return fechaVisita;
	}
	public void setFechaVisita(Date fechaVisita) {
		this.fechaVisita = fechaVisita;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getIndicaciones() {
		return indicaciones;
	}
	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}
	public String getElectCardiogram() {
		return electCardiogram;
	}
	public void setElectCardiogram(String electCardiogram) {
		this.electCardiogram = electCardiogram;
	}
	public boolean isOmitExpecialid() {
		return omitExpecialid;
	}
	public void setOmitExpecialid(boolean omitExpecialid) {
		this.omitExpecialid = omitExpecialid;
	}
	
	
	
}
