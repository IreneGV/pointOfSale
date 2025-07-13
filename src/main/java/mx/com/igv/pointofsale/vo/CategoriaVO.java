package mx.com.igv.pointofsale.vo;

import java.io.Serializable;
import java.util.List;

public class CategoriaVO implements Serializable {
	
	private static final long serialVersionUID = 3702038187521470545L;
	
	private Integer idCategoria;
	private String descripcion;
	private List<ProductoVO> productos;
	/**
	 * @return the idCategoria
	 */
	public Integer getIdCategoria() {
		return idCategoria;
	}
	/**
	 * @param idCategoria the idCategoria to set
	 */
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
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
