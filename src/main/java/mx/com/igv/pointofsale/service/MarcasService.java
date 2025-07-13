package mx.com.igv.pointofsale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import mx.com.igv.pointofsale.entity.MarcasEntity;
import mx.com.igv.pointofsale.exception.MyNotFoundException;
import mx.com.igv.pointofsale.exception.NegocioException;
import mx.com.igv.pointofsale.repository.MarcasRepository;
import mx.com.igv.pointofsale.vo.MarcaVO;

@Service
public class MarcasService {
	
	private final MarcasRepository marcasRepository;
	
	public MarcasService(MarcasRepository marcasRepository) {
		this.marcasRepository = marcasRepository;
	}
	
	public List<MarcaVO> marcas() throws NegocioException {
		List<MarcasEntity> marcasEntityList = marcasRepository.findAll();
		return entityToVoList(marcasEntityList);
	}
	
	public MarcaVO byId(Integer idMarca) throws NegocioException {
		Optional<MarcasEntity> marcasOptional = marcasRepository.findById(idMarca);
		if(!marcasOptional.isPresent()) {
			throw new MyNotFoundException("No existe la marca que se desea actualizar");
		}
		MarcasEntity MarcasEntity = marcasOptional.get();
		MarcaVO marcasVO = new MarcaVO();
		BeanUtils.copyProperties(MarcasEntity, marcasVO);
		return marcasVO;
	}
	
	private List<MarcaVO> entityToVoList(List<MarcasEntity> marcasEntityList) {
		List<MarcaVO> marcaVOList = new ArrayList<>();
		MarcaVO marcaVO;
		for (MarcasEntity marcaEntity : marcasEntityList) {
			marcaVO = new MarcaVO();
			BeanUtils.copyProperties(marcaEntity, marcaVO);
			marcaVOList.add(marcaVO);
		}
		return marcaVOList;
	}
}
