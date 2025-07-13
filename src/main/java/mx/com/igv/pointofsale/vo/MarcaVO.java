package mx.com.igv.pointofsale.vo;

import java.io.Serializable;

public class MarcaVO implements Serializable {
	
	private static final long serialVersionUID = 2887589969428135601L;
	
	private Integer idMarca;
	private String nombre;
	
	/**
	 * @return the idMarca
	 */
	public Integer getIdMarca() {
		return idMarca;
	}
	/**
	 * @param idMarca the idMarca to set
	 */
	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}