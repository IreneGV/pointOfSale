package mx.com.igv.pointofsale.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventarios")
public class InventariosEntity implements Serializable{
	
	private static final long serialVersionUID = 2248476258627873382L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_inventario")
	private Integer idInventario;
	
	@Column(name = "existencia")
	private Integer existencia;
	
	@Column(name = "existencia_minima")
	private Integer existenciaMinima;
	
	@Column(name = "precio_inventario")
	private Double precioInventario;
	
	@Column(name = "id_proveedor")
	private Integer idProveedor;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto")
	private ProductosEntity productos;
	
	@OneToMany(mappedBy = "inventarios")
	private List<MovimientosInventariosEntity> movimientos;

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
	 * @return the productos
	 */
	public ProductosEntity getProductos() {
		return productos;
	}

	/**
	 * @param productos the productos to set
	 */
	public void setProductos(ProductosEntity productos) {
		this.productos = productos;
	}

	/**
	 * @return the movimientos
	 */
	public List<MovimientosInventariosEntity> getMovimientos() {
		return movimientos;
	}

	/**
	 * @param movimientos the movimientos to set
	 */
	public void setMovimientos(List<MovimientosInventariosEntity> movimientos) {
		this.movimientos = movimientos;
	}
}