package mx.com.igv.pointofsale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import mx.com.igv.pointofsale.entity.UnidadesMedidasEntity;
import mx.com.igv.pointofsale.exception.MyNotFoundException;
import mx.com.igv.pointofsale.exception.NegocioException;
import mx.com.igv.pointofsale.repository.UnidadesMedidasRepository;
import mx.com.igv.pointofsale.vo.UnidadMedidaVO;

@Service
public class UnidadMedidaService {
	
	private final UnidadesMedidasRepository unidadesMedidasRepository;
	
	public UnidadMedidaService(UnidadesMedidasRepository unidadesMedidasRepository) {
		this.unidadesMedidasRepository = unidadesMedidasRepository;
	}
	
	public List<UnidadMedidaVO> unidadesMedida() throws NegocioException {
		List<UnidadesMedidasEntity> unidadesEntityList = unidadesMedidasRepository.findAll();
		return entityToVoList(unidadesEntityList);
	}
	
	public UnidadMedidaVO byId(Integer idUnidadMedida) throws NegocioException {
		Optional<UnidadesMedidasEntity> unidadMedidaOptional = unidadesMedidasRepository.findById(idUnidadMedida);
		if(!unidadMedidaOptional.isPresent()) {
			throw new MyNotFoundException("No existe la unidad de medida que se desea actualizar");
		}
		UnidadesMedidasEntity unidadesMedidasEntity = unidadMedidaOptional.get();
		UnidadMedidaVO unidadMedidaVO = new UnidadMedidaVO();
		BeanUtils.copyProperties(unidadesMedidasEntity, unidadMedidaVO);
		return unidadMedidaVO;
	}
		
	public void crearActualizar(UnidadMedidaVO unidadMedidaVO) {
		UnidadesMedidasEntity unidadesMedidasEntity = new UnidadesMedidasEntity();
		BeanUtils.copyProperties(unidadMedidaVO, unidadesMedidasEntity);
		unidadesMedidasRepository.save(unidadesMedidasEntity);
	}
	
	public void eliminar(Integer idUnidadMedida) throws NegocioException {
		Optional<UnidadesMedidasEntity> unidadMedidaOptional = unidadesMedidasRepository.findById(idUnidadMedida);
		if(!unidadMedidaOptional.isPresent()) {
			throw new MyNotFoundException("No existe la unidad de medida que se desea actualizar");
		}
		UnidadesMedidasEntity unidadesMedidasEntity = unidadMedidaOptional.get();
		unidadesMedidasRepository.delete(unidadesMedidasEntity);
	}
	
	private List<UnidadMedidaVO> entityToVoList(List<UnidadesMedidasEntity> unidadesEntityList) {
		List<UnidadMedidaVO> unidadMedidaVOList = new ArrayList<>();
		UnidadMedidaVO unidadMedidaVO;
		for (UnidadesMedidasEntity unidadesMedidasEntity : unidadesEntityList) {
			unidadMedidaVO = new UnidadMedidaVO();
			BeanUtils.copyProperties(unidadesMedidasEntity, unidadMedidaVO);
			unidadMedidaVOList.add(unidadMedidaVO);
		}
		return unidadMedidaVOList;
	}
}
