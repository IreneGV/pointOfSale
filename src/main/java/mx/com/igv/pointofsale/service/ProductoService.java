package mx.com.igv.pointofsale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import mx.com.igv.pointofsale.entity.CategoriasEntity;
import mx.com.igv.pointofsale.entity.ProductosEntity;
import mx.com.igv.pointofsale.entity.UnidadesMedidasEntity;
import mx.com.igv.pointofsale.exception.MyNotFoundException;
import mx.com.igv.pointofsale.exception.NegocioException;
import mx.com.igv.pointofsale.repository.ProductosRepository;
import mx.com.igv.pointofsale.vo.CategoriaVO;
import mx.com.igv.pointofsale.vo.MarcaVO;
import mx.com.igv.pointofsale.vo.ProductoVO;
import mx.com.igv.pointofsale.vo.UnidadMedidaVO;

@Service
public class ProductoService{
	
	private final ProductosRepository productosRepository;
	private final MarcasService marcasService;
	
	public ProductoService(ProductosRepository productosRepository, MarcasService marcasService) {
		this.productosRepository = productosRepository;
		this.marcasService = marcasService;
	}
	
	public List<ProductoVO> productos() throws NegocioException {
		List<ProductosEntity> productosEntityList = productosRepository.findAll();
		return entityToVoList(productosEntityList);
	}
	
	public ProductoVO productobyId(Integer idProducto) throws NegocioException {
		Optional<ProductosEntity> productosOptional = productosRepository.findById(idProducto);
		if(!productosOptional.isPresent()) {
			throw new MyNotFoundException("No existe el producto que se desea actualizar");
		}
		ProductosEntity productosEntity = productosOptional.get();
		ProductoVO productoVO = new ProductoVO();
		BeanUtils.copyProperties(productosEntity, productoVO);
		
		CategoriaVO categoriaVO = new CategoriaVO();
		BeanUtils.copyProperties(productosEntity.getCategoria(), categoriaVO);
		productoVO.setCategoria(categoriaVO);
		
		UnidadMedidaVO unidadMedidaVO = new UnidadMedidaVO();
		BeanUtils.copyProperties(productosEntity.getUnidadMedida(), unidadMedidaVO);
		productoVO.setUnidadMedida(unidadMedidaVO);
		
		MarcaVO marcaVO = Optional.ofNullable(productosEntity.getMarca())
				.map(marcasService :: byId)
				.orElse(null);
		productoVO.setMarca(marcaVO);
		
		return productoVO;
	}
	
	public void crearActualizar(ProductoVO productoVO) {
		ProductosEntity productosEntity = new ProductosEntity();
		BeanUtils.copyProperties(productoVO, productosEntity);
		
		CategoriasEntity categoria = new CategoriasEntity();
		categoria.setIdCategoria(productoVO.getCategoria().getIdCategoria());
		productosEntity.setCategoria(categoria);
		
		UnidadesMedidasEntity unidadMedida = new UnidadesMedidasEntity();
		unidadMedida.setIdUnidadMedida(productoVO.getUnidadMedida().getIdUnidadMedida());
		productosEntity.setUnidadMedida(unidadMedida);
		
		productosEntity.setMarca(productoVO.getMarca().getIdMarca());
		
		productosRepository.save(productosEntity);
	}
	
	public void eliminar(Integer idProducto) throws NegocioException {
		Optional<ProductosEntity> productosOptional = productosRepository.findById(idProducto);
		if(!productosOptional.isPresent()) {
			throw new MyNotFoundException("No existe el producto que se desea actualizar");
		}
		ProductosEntity productosEntity = productosOptional.get();
		productosRepository.delete(productosEntity);
	}
	
	private List<ProductoVO> entityToVoList(List<ProductosEntity> productosEntityList) throws NegocioException{
		List<ProductoVO> productoVOList = new ArrayList<>();
		ProductoVO productoVO;
		CategoriaVO categoriaVO;
		UnidadMedidaVO unidadMedidaVO;
		MarcaVO marcaVO;
		for (ProductosEntity productosEntity : productosEntityList) {
			productoVO = new ProductoVO();
			BeanUtils.copyProperties(productosEntity, productoVO);
			
			categoriaVO = new CategoriaVO();
			BeanUtils.copyProperties(productosEntity.getCategoria(), categoriaVO);
			productoVO.setCategoria(categoriaVO);
			
			unidadMedidaVO = new UnidadMedidaVO();
			BeanUtils.copyProperties(productosEntity.getUnidadMedida(), unidadMedidaVO);
			productoVO.setUnidadMedida(unidadMedidaVO);
			
			marcaVO = Optional.ofNullable(productosEntity.getMarca())
					.map(marcasService :: byId)
					.orElse(null);
			productoVO.setMarca(marcaVO);
			
			productoVOList.add(productoVO);
		}
		return productoVOList;
	}
}