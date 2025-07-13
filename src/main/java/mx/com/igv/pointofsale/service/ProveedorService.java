package mx.com.igv.pointofsale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import mx.com.igv.pointofsale.entity.ProveedoresEntity;
import mx.com.igv.pointofsale.exception.MyNotFoundException;
import mx.com.igv.pointofsale.exception.NegocioException;
import mx.com.igv.pointofsale.repository.ProveedoresRepository;
import mx.com.igv.pointofsale.vo.MarcaVO;
import mx.com.igv.pointofsale.vo.ProveedorVO;

@Service
public class ProveedorService {
	
	private final ProveedoresRepository proveedoresRepository;
	private final MarcasService marcasService;
	
	public ProveedorService(ProveedoresRepository proveedoresRepository, MarcasService marcasService) {
		this.proveedoresRepository = proveedoresRepository;
		this.marcasService = marcasService;
	}
	
	public List<ProveedorVO> proveedores() throws NegocioException {
		List<ProveedoresEntity> proveedoresEntityList = proveedoresRepository.findAll();
		return entityToVoList(proveedoresEntityList);
	}
	
	public ProveedorVO byId(Integer idProveedor) throws NegocioException {
		Optional<ProveedoresEntity> proveedoresOptional = proveedoresRepository.findById(idProveedor);
		if(!proveedoresOptional.isPresent()) {
			throw new MyNotFoundException("No existe el proveedor que se desea actualizar");
		}
		ProveedoresEntity proveedoresEntity = proveedoresOptional.get();
		ProveedorVO proveedorVO = new ProveedorVO();
		BeanUtils.copyProperties(proveedoresEntity, proveedorVO);
		
		MarcaVO marcaVO = Optional.ofNullable(proveedoresEntity.getMarca())
				.map(marcasService :: byId)
				.orElse(null);
		proveedorVO.setMarca(marcaVO);
		
		return proveedorVO;
	}
	
	public void crearActualizar(ProveedorVO proveedorVO) {
		ProveedoresEntity proveedorEntity = new ProveedoresEntity();
		BeanUtils.copyProperties(proveedorVO, proveedorEntity);
		
		proveedorEntity.setMarca(proveedorVO.getMarca().getIdMarca());
		
		proveedoresRepository.save(proveedorEntity);
	}
	
	public void eliminar(Integer idProveedor) throws NegocioException {
		Optional<ProveedoresEntity> proveedoresOptional = proveedoresRepository.findById(idProveedor);
		if(!proveedoresOptional.isPresent()) {
			throw new MyNotFoundException("No existe el proveedor que se desea eliminar");
		}
		ProveedoresEntity proveedoresEntity = proveedoresOptional.get();
		proveedoresRepository.delete(proveedoresEntity);
	}
	
	private List<ProveedorVO> entityToVoList(List<ProveedoresEntity> proveedoresEntityList) {
		List<ProveedorVO> proveedoresVOList = new ArrayList<>();
		ProveedorVO proveedorVO;
		MarcaVO marcaVO;
		for (ProveedoresEntity proveedoresEntity : proveedoresEntityList) {
			proveedorVO = new ProveedorVO();
			BeanUtils.copyProperties(proveedoresEntity, proveedorVO);
			
			marcaVO = Optional.ofNullable(proveedoresEntity.getMarca())
					.map(marcasService :: byId)
					.orElse(null);
			proveedorVO.setMarca(marcaVO);
			
			proveedoresVOList.add(proveedorVO);
		}
		return proveedoresVOList;
	}
}