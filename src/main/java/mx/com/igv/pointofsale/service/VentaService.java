package mx.com.igv.pointofsale.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import mx.com.igv.pointofsale.entity.VentasEntity;
import mx.com.igv.pointofsale.exception.MyNotFoundException;
import mx.com.igv.pointofsale.exception.NegocioException;
import mx.com.igv.pointofsale.repository.VentasRepository;
import mx.com.igv.pointofsale.utils.Constantes;
import mx.com.igv.pointofsale.utils.Utileria;
import mx.com.igv.pointofsale.vo.VentaVO;

@Service
public class VentaService {
	
	private final VentasRepository ventasRepository;
	
	public VentaService(VentasRepository ventasRepository) {
		this.ventasRepository = ventasRepository;
	}
	
	public List<VentaVO> ventas() throws NegocioException {
		List<VentasEntity> ventasEntityList = ventasRepository.findAll();
		return entityToVoList(ventasEntityList);
	}
	
	public List<VentaVO> byFecha(String fechaInicio, String fechaFin) throws NegocioException {
		if(fechaInicio == null || fechaInicio.isBlank()) {
			throw new NegocioException("Se debe ingresar una fecha de inicio");
		}
		if(fechaFin == null || fechaFin.isBlank()) {
			throw new NegocioException("Se debe ingresar una fecha de fin");
		}
		LocalDateTime fechaInicioD = Utileria.Fechas.castDate(fechaInicio, Constantes.formatoFecha);
		LocalDateTime fechaFinD = Utileria.Fechas.castDate(fechaFin, Constantes.formatoFecha);
		List<VentasEntity> ventasEntityList = ventasRepository.findByFechaHoraBetween(fechaInicioD, fechaFinD);
		return entityToVoList(ventasEntityList);
	}
	
//	public void actualizar(ProductoVO productoVO) throws NegocioException {
//		Optional<ProductosEntity> productosOptional = productosRepository.findById(productoVO.getIdProducto());
//		if(!productosOptional.isPresent()) {
//			throw new NegocioException("No existe el producto que se desea actualizar");
//		}
//		ProductosEntity productosEntity = productosOptional.get();
//		BeanUtils.copyProperties(productoVO, productosEntity);
//		productosRepository.save(productosEntity);
//	}
//	
//	public void crear(ProductoVO productoVO) {
//		ProductosEntity productosEntity = new ProductosEntity();
//		BeanUtils.copyProperties(productoVO, productosEntity);
//		productosRepository.save(productosEntity);
//	}
//	
//	public void eliminar(Integer idProducto) throws NegocioException {
//		Optional<ProductosEntity> productosOptional = productosRepository.findById(idProducto);
//		if(!productosOptional.isPresent()) {
//			throw new NegocioException("No existe el producto que se desea actualizar");
//		}
//		ProductosEntity productosEntity = productosOptional.get();
//		productosRepository.delete(productosEntity);
//	}
	
	private List<VentaVO> entityToVoList(List<VentasEntity> ventasEntityList) throws NegocioException{
		if(ventasEntityList == null || ventasEntityList.isEmpty()) {
			throw new MyNotFoundException("No hay ventas registradas");
		}
		List<VentaVO> ventasVOList = new ArrayList<>();
		VentaVO ventaVO;
		for (VentasEntity ventasEntity : ventasEntityList) {
			ventaVO = new VentaVO();
			BeanUtils.copyProperties(ventasEntity, ventaVO);
			ventasVOList.add(ventaVO);
		}
		return ventasVOList;
	}
}