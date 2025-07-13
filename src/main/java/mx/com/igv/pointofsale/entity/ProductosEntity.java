package mx.com.igv.pointofsale.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="productos")
public class ProductosEntity implements Serializable{
	
	private static final long serialVersionUID = 7943908909347088936L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Integer idProducto;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private CategoriasEntity categoria;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "contenido")
	private Double contenido;
	
	@ManyToOne
	@JoinColumn(name = "id_unidad_medida")
	private UnidadesMedidasEntity unidadMedida;
	
	@Column(name = "marca")
	private Integer marca;
	
	@Column(name = "precio_venta")
	private Double precioVenta;
	
	@Column(name = "ruta_imagen")
	private String rutaImagen;
	
	@OneToOne(mappedBy = "productos", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private InventariosEntity inventarios;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
			name = "productos_ventas",
			joinColumns = { @JoinColumn(name="id_producto")},
			inverseJoinColumns = { @JoinColumn(name="id_venta")}
	)
	private List<VentasEntity> productosVentas;

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
	 * @return the categoria
	 */
	public CategoriasEntity getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(CategoriasEntity categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the contenido
	 */
	public Double getContenido() {
		return contenido;
	}

	/**
	 * @param contenido the contenido to set
	 */
	public void setContenido(Double contenido) {
		this.contenido = contenido;
	}

	/**
	 * @return the unidadMedida
	 */
	public UnidadesMedidasEntity getUnidadMedida() {
		return unidadMedida;
	}

	/**
	 * @param unidadMedida the unidadMedida to set
	 */
	public void setUnidadMedida(UnidadesMedidasEntity unidadMedida) {
		this.unidadMedida = unidadMedida;
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
	 * @return the precioVenta
	 */
	public Double getPrecioVenta() {
		return precioVenta;
	}

	/**
	 * @param precioVenta the precioVenta to set
	 */
	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}

	/**
	 * @return the rutaImagen
	 */
	public String getRutaImagen() {
		return rutaImagen;
	}

	/**
	 * @param rutaImagen the rutaImagen to set
	 */
	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
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

	/**
	 * @return the productosVentas
	 */
	public List<VentasEntity> getProductosVentas() {
		return productosVentas;
	}

	/**
	 * @param productosVentas the productosVentas to set
	 */
	public void setProductosVentas(List<VentasEntity> productosVentas) {
		this.productosVentas = productosVentas;
	}
}