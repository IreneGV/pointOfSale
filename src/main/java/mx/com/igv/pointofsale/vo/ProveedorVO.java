package mx.com.igv.pointofsale.vo;

import java.io.Serializable;

public class ProveedorVO implements Serializable{
	
	private static final long serialVersionUID = -6896021576825234224L;
	
	private Integer idProveedor;
	private MarcaVO marca;
	private String nombreContacto;
	private String telefonoContacto;
	private String diasPedido;
	private String periodicidadPedido;
	private String diasEntrega;
	private String periodicidadEntrega;
	
	/**
	 * @return the idProveedor
	 */
	public Integer getIdProveedor() {
		return idProveedor;
	}
	/**
	 * @param idProveedor the idProveedor to set
	 */
	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}
	/**
	 * @return the marca
	 */
	public MarcaVO getMarca() {
		return marca;
	}
	/**
	 * @param marca the marca to set
	 */
	public void setMarca(MarcaVO marca) {
		this.marca = marca;
	}
	/**
	 * @return the nombreContacto
	 */
	public String getNombreContacto() {
		return nombreContacto;
	}
	/**
	 * @param nombreContacto the nombreContacto to set
	 */
	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}
	/**
	 * @return the telefonoContacto
	 */
	public String getTelefonoContacto() {
		return telefonoContacto;
	}
	/**
	 * @param telefonoContacto the telefonoContacto to set
	 */
	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}
	/**
	 * @return the diasPedido
	 */
	public String getDiasPedido() {
		return diasPedido;
	}
	/**
	 * @param diasPedido the diasPedido to set
	 */
	public void setDiasPedido(String diasPedido) {
		this.diasPedido = diasPedido;
	}
	/**
	 * @return the periodicidadPedido
	 */
	public String getPeriodicidadPedido() {
		return periodicidadPedido;
	}
	/**
	 * @param periodicidadPedido the periodicidadPedido to set
	 */
	public void setPeriodicidadPedido(String periodicidadPedido) {
		this.periodicidadPedido = periodicidadPedido;
	}
	/**
	 * @return the diasEntrega
	 */
	public String getDiasEntrega() {
		return diasEntrega;
	}
	/**
	 * @param diasEntrega the diasEntrega to set
	 */
	public void setDiasEntrega(String diasEntrega) {
		this.diasEntrega = diasEntrega;
	}
	/**
	 * @return the periodicidadEntrega
	 */
	public String getPeriodicidadEntrega() {
		return periodicidadEntrega;
	}
	/**
	 * @param periodicidadEntrega the periodicidadEntrega to set
	 */
	public void setPeriodicidadEntrega(String periodicidadEntrega) {
		this.periodicidadEntrega = periodicidadEntrega;
	}
}