package mx.com.igv.pointofsale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import mx.com.igv.pointofsale.entity.InventariosEntity;
import mx.com.igv.pointofsale.entity.ProductosEntity;
import mx.com.igv.pointofsale.exception.MyNotFoundException;
import mx.com.igv.pointofsale.exception.NegocioException;
import mx.com.igv.pointofsale.repository.InventariosRepository;
import mx.com.igv.pointofsale.vo.InventarioVO;
import mx.com.igv.pointofsale.vo.ProductoVO;

@Service
public class InventarioService {

	private final InventariosRepository inventariosRepository;
	private final ProductoService productoService;
	private final ModelMapper modelMapper;

	public InventarioService(InventariosRepository inventariosRepository, ProductoService productoService,
			ModelMapper modelMapper) {
		this.inventariosRepository = inventariosRepository;
		this.productoService = productoService;
		this.modelMapper = modelMapper;
	}

	public List<InventarioVO> inventarios() throws NegocioException {
		List<InventariosEntity> inventariosEntityList = inventariosRepository.findAll();
		return entityToVoList(inventariosEntityList);
	}

	public List<InventarioVO> byProducto(Integer idProducto) throws NegocioException {
		if (idProducto == null || idProducto.equals(0)) {
			throw new MyNotFoundException("Se debe ingresar un producto");
		}
		ProductoVO productoVO = productoService.productobyId(idProducto);
		ProductosEntity productosEntity = modelMapper.map(productoVO, ProductosEntity.class);
		List<InventariosEntity> inventariosEntityList = inventariosRepository.findByProductos(productosEntity);
		return entityToVoList(inventariosEntityList);
	}

	public void actualizar(InventarioVO inventarioVO) throws NegocioException {
		Optional<InventariosEntity> inventariosOptional = inventariosRepository
				.findById(inventarioVO.getIdInventario());
		if (!inventariosOptional.isPresent()) {
			throw new MyNotFoundException("No existe inventario del prodcuto que se desea actualizar");
		}
		InventariosEntity inventariosEntity = inventariosOptional.get();
		BeanUtils.copyProperties(inventarioVO, inventariosEntity);
		inventariosRepository.save(inventariosEntity);
	}

	public void crear(InventarioVO inventarioVO) {
		InventariosEntity inventariosEntity = new InventariosEntity();
		BeanUtils.copyProperties(inventarioVO, inventariosEntity);
		inventariosRepository.save(inventariosEntity);
	}

	public void eliminar(Integer idInventario) throws NegocioException {
		Optional<InventariosEntity> inventariosOptional = inventariosRepository.findById(idInventario);
		if (!inventariosOptional.isPresent()) {
			throw new MyNotFoundException("No existe inventario del prodcuto que se desea actualizar");
		}
		InventariosEntity inventariosEntity = inventariosOptional.get();
		inventariosRepository.delete(inventariosEntity);
	}

	private List<InventarioVO> entityToVoList(List<InventariosEntity> inventariosEntityList) throws NegocioException {
		if (inventariosEntityList == null || inventariosEntityList.isEmpty()) {
			throw new MyNotFoundException("No hay inventario del producto solicitado");
		}
		List<InventarioVO> inventarioVOList = new ArrayList<>();
		InventarioVO inventarioVO;
		for (InventariosEntity inventariosEntity : inventariosEntityList) {
			inventarioVO = new InventarioVO();
			BeanUtils.copyProperties(inventariosEntity, inventarioVO);
			inventarioVOList.add(inventarioVO);
		}
		return inventarioVOList;
	}
}