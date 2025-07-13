package mx.com.igv.pointofsale.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedores")
public class ProveedoresEntity implements Serializable{
	
	private static final long serialVersionUID = 465353059635857263L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_proveedor")
	private Integer idProveedor;
	
	@Column(name = "marca")
	private Integer marca;
	
	@Column(name = "nombre_contacto")
	private String nombreContacto;
	
	@Column(name = "telefono_contacto")
	private String telefonoContacto;
	
	@Column(name = "dias_pedido")
	private String diasPedido;
	
	@Column(name = "periodicidad_pedido")
	private String periodicidadPedido;
	
	@Column(name = "dias_entrega")
	private String diasEntrega;
	
	@Column(name = "periodicidad_entrega")
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
	public Integer getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(Integer marca) {
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