package mx.com.igv.pointofsale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import mx.com.igv.pointofsale.entity.CategoriasEntity;
import mx.com.igv.pointofsale.exception.MyNotFoundException;
import mx.com.igv.pointofsale.exception.NegocioException;
import mx.com.igv.pointofsale.repository.CategoriasRepository;
import mx.com.igv.pointofsale.vo.CategoriaVO;

@Service
public class CategoriaService {
	
	private final CategoriasRepository categoriasRepository;
	
	public CategoriaService(CategoriasRepository categoriasRepository) {
		this.categoriasRepository = categoriasRepository;
	}
	
	public List<CategoriaVO> categorias() throws NegocioException {
		List<CategoriasEntity> categoriasEntityList = categoriasRepository.findAll();
		return entityToVoList(categoriasEntityList);
	}
	
	public CategoriaVO byId(Integer idCategoria) throws NegocioException {
		Optional<CategoriasEntity> categoriasOptional = categoriasRepository.findById(idCategoria);
		if(!categoriasOptional.isPresent()) {
			throw new MyNotFoundException("No existe la categoria que se desea actualizar");
		}
		CategoriasEntity categoriasEntity = categoriasOptional.get();
		CategoriaVO categoriaVO = new CategoriaVO();
		BeanUtils.copyProperties(categoriasEntity, categoriaVO);
		return categoriaVO;
	}
	
	public void crearActualizar(CategoriaVO categoriaVO) {
		CategoriasEntity categoriasEntity = new CategoriasEntity();
		BeanUtils.copyProperties(categoriaVO, categoriasEntity);
		categoriasRepository.save(categoriasEntity);
	}
	
	public void eliminar(Integer idCategoria) throws NegocioException {
		Optional<CategoriasEntity> categoriasOptional = categoriasRepository.findById(idCategoria);
		if(!categoriasOptional.isPresent()) {
			throw new MyNotFoundException("No existe la categoria que se desea eliminar");
		}
		CategoriasEntity categoriasEntity = categoriasOptional.get();
		categoriasRepository.delete(categoriasEntity);
	}
	
	private List<CategoriaVO> entityToVoList(List<CategoriasEntity> categoriasEntityList) {
		List<CategoriaVO> categoriaVOList = new ArrayList<>();
		CategoriaVO categoriaVO;
		for (CategoriasEntity categoriasEntity : categoriasEntityList) {
			categoriaVO = new CategoriaVO();
			BeanUtils.copyProperties(categoriasEntity, categoriaVO);
			categoriaVOList.add(categoriaVO);
		}
		return categoriaVOList;
	}
}