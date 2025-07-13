package mx.com.igv.pointofsale.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "unidades_medidas")
public class UnidadesMedidasEntity implements Serializable{
	
	private static final long serialVersionUID = 8406644114101565337L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_unidad_medida")
	private Integer idUnidadMedida;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "nombre_unidad")
	private String nombreUnidad;
	
	@OneToMany(mappedBy = "unidadMedida", cascade = CascadeType.ALL)
	private List<ProductosEntity> productos;

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
	public List<ProductosEntity> getProductos() {
		return productos;
	}

	/**
	 * @param productos the productos to set
	 */
	public void setProductos(List<ProductosEntity> productos) {
		this.productos = productos;
	}
}