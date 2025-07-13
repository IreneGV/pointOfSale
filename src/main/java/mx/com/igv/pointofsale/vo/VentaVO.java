package mx.com.igv.pointofsale.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class VentaVO implements Serializable{
	
	private static final long serialVersionUID = -5905336563593790258L;
	
	private Integer idVenta;
	private LocalDateTime fechaHora;
	private Double total;
	private List<ProductoVO> productos;
	
	/**
	 * @return the idVenta
	 */
	public Integer getIdVenta() {
		return idVenta;
	}
	/**
	 * @param idVenta the idVenta to set
	 */
	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
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
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}
	/**
	 * @return the productos
	 */
	public List<ProductoVO> getProductos() {
		return productos;
	}
	/**
	 * @param productos the productos to set
	 */
	public void setProductos(List<ProductoVO> productos) {
		this.productos = productos;
	}
}
