package mx.com.igv.pointofsale.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MovimientoInventarioVO implements Serializable{
	
	private static final long serialVersionUID = -8403139148653885696L;
	
	private Integer idMovimientoInventario;
	private String tipoMovimiento;
	private Integer cantidad;
	private LocalDateTime fechaHora;
	private InventarioVO inventario;
	
	/**
	 * @return the idMovimientoInventario
	 */
	public Integer getIdMovimientoInventario() {
		return idMovimientoInventario;
	}
	/**
	 * @param idMovimientoInventario the idMovimientoInventario to set
	 */
	public void setIdMovimientoInventario(Integer idMovimientoInventario) {
		this.idMovimientoInventario = idMovimientoInventario;
	}
	/**
	 * @return the tipoMovimiento
	 */
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	/**
	 * @param tipoMovimiento the tipoMovimiento to set
	 */
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the fechaHora
	 */
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	/**
	 * @return the inventario
	 */
	public InventarioVO getInventario() {
		return inventario;
	}
	/**
	 * @param inventario the inventario to set
	 */
	public void setInventario(InventarioVO inventario) {
		this.inventario = inventario;
	}
}