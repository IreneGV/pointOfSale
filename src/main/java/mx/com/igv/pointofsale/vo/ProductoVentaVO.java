package mx.com.igv.pointofsale.vo;

import java.io.Serializable;

public class ProductoVentaVO implements Serializable{
	
	private static final long serialVersionUID = -4246333275325903555L;
	
	private Integer idProductoVenta;
	private Integer idVenta;
	private Integer idProducto;
	private Integer cantidadProducto;
	
	/**
	 * @return the idProductoVenta
	 */
	public Integer getIdProductoVenta() {
		return idProductoVenta;
	}
	/**
	 * @param idProductoVenta the idProductoVenta to set
	 */
	public void setIdProductoVenta(Integer idProductoVenta) {
		this.idProductoVenta = idProductoVenta;
	}
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
	 * @return the cantidadProducto
	 */
	public Integer getCantidadProducto() {
		return cantidadProducto;
	}
	/**
	 * @param cantidadProducto the cantidadProducto to set
	 */
	public void setCantidadProducto(Integer cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
}