package mx.com.igv.pointofsale.vo;

import java.io.Serializable;
import java.util.List;

public class InventarioVO implements Serializable{
	
	private static final long serialVersionUID = -5120903416858065031L;
	
	private Integer idInventario;
	private Integer existencia;
	private Integer existenciaMinima;
	private Double precioInventario;
	private Integer idProveedor;
	private Integer idProducto;
	private List<MovimientoInventarioVO> movimientos;
	
	/**
	 * @return the idInventario
	 */
	public Integer getIdInventario() {
		return idInventario;
	}
	/**
	 * @param idInventario the idInventario to set
	 */
	public void setIdInventario(Integer idInventario) {
		this.idInventario = idInventario;
	}
	/**
	 * @return the existencia
	 */
	public Integer getExistencia() {
		return existencia;
	}
	/**
	 * @param existencia the existencia to set
	 */
	public void setExistencia(Integer existencia) {
		this.existencia = existencia;
	}
	/**
	 * @return the existenciaMinima
	 */
	public Integer getExistenciaMinima() {
		return existenciaMinima;
	}
	/**
	 * @param existenciaMinima the existenciaMinima to set
	 */
	public void setExistenciaMinima(Integer existenciaMinima) {
		this.existenciaMinima = existenciaMinima;
	}
	/**
	 * @return the precioInventario
	 */
	public Double getPrecioInventario() {
		return precioInventario;
	}
	/**
	 * @param precioInventario the precioInventario to set
	 */
	public void setPrecioInventario(Double precioInventario) {
		this.precioInventario = precioInventario;
	}
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
	 * @return the idProducto
	 */
	public Integer getIdProducto() {
		return idProducto;
	}
	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	/**
	 * @return the movimientos
	 */
	public List<MovimientoInventarioVO> getMovimientos() {
		return movimientos;
	}
	/**
	 * @param movimientos the movimientos to set
	 */
	public void setMovimientos(List<MovimientoInventarioVO> movimientos) {
		this.movimientos = movimientos;
	}
}