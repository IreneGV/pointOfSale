package mx.com.igv.pointofsale.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.igv.pointofsale.exception.NegocioException;
import mx.com.igv.pointofsale.service.CategoriaService;
import mx.com.igv.pointofsale.vo.CategoriaVO;

@RestController
@RequestMapping("/categorias")
public class CategoriaOprController {
	
	private final CategoriaService categoriaService;
	
	public CategoriaOprController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	
	@GetMapping("/{idCategoria}")
	public ResponseEntity<CategoriaVO> byId(@PathVariable Integer idCategoria) throws NegocioException{
		return ResponseEntity.ok(categoriaService.byId(idCategoria));
	}
	
	@GetMapping("/all")
	public List<CategoriaVO> findAll() throws NegocioException {
		return categoriaService.categorias();
	}
}