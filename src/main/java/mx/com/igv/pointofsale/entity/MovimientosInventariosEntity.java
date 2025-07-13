package mx.com.igv.pointofsale.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movimientos_inventarios")
public class MovimientosInventariosEntity implements Serializable{
	
	private static final long serialVersionUID = -2503764034026932543L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_movimiento_inventario")
	private Integer idMovimientoInventario;
	
	@Column(name = "tipo_movimiento")
	private String tipoMovimiento;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	
	@Column(name = "fecha_hora")
	private LocalDateTime fechaHora;
	
	@ManyToOne
	@JoinColumn(name = "id_inventario")
	private InventariosEntity inventarios;

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
	 * @return the inventarios
	 */
	public InventariosEntity getInventarios() {
		return inventarios;
	}

	/**
	 * @param inventarios the inventarios to set
	 */
	public void setInventarios(InventariosEntity inventarios) {
		this.inventarios = inventarios;
	}
}