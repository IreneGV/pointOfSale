package mx.com.igv.pointofsale.vo;

import java.io.Serializable;
import java.util.List;

public class UnidadMedidaVO implements Serializable{
	
	private static final long serialVersionUID = -2144791921563963746L;
	
	private Integer idUnidadMedida;
	private String codigo;
	private String nombreUnidad;
	private List<ProductoVO> productos;
	
	/**
	 * @return the idUnidadMedida
	 */
	public Integer getIdUnidadMedida() {
		return idUnidadMedida;
	}
	/**
	 * @param idUnidadMedida the idUnidadMedida to set
	 */
	public void setIdUnidadMedida(Integer idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the nombreUnidad
	 */
	public String getNombreUnidad() {
		return nombreUnidad;
	}
	/**
	 * @param nombreUnidad the nombreUnidad to set
	 */
	public void setNombreUnidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
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