package mx.com.igv.pointofsale.vo;

import java.io.Serializable;

public class ProductoVO implements Serializable{
	
	private static final long serialVersionUID = 1440374373899820203L;
	
	private Integer idProducto;
	private CategoriaVO categoria;
	private String descripcion;
	private Double contenido;
	private UnidadMedidaVO unidadMedida;
	private MarcaVO marca;
	private Double precioVenta;
	private String rutaImagen;
	
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
	public CategoriaVO getCategoria() {
		return categoria;
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(CategoriaVO categoria) {
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
	public UnidadMedidaVO getUnidadMedida() {
		return unidadMedida;
	}
	/**
	 * @param unidadMedida the unidadMedida to set
	 */
	public void setUnidadMedida(UnidadMedidaVO unidadMedida) {
		this.unidadMedida = unidadMedida;
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
}