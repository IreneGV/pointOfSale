package mx.com.igv.pointofsale.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos_ventas")
public class ProductosVentasEntity implements Serializable{
	
	private static final long serialVersionUID = -2776361433832434904L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_producto_venta")
	private Integer idProductoVenta;
	
	@Column(name = "id_venta")
	private Integer idVenta;
	
	@Column(name = "id_producto")
	private Integer idProducto;
	
	@Column(name = "cantidad_producto")
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