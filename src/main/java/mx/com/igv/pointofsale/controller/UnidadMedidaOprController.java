package mx.com.igv.pointofsale.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.igv.pointofsale.exception.NegocioException;
import mx.com.igv.pointofsale.service.UnidadMedidaService;
import mx.com.igv.pointofsale.vo.UnidadMedidaVO;

@RestController
@RequestMapping("/unidadesmedidas")
public class UnidadMedidaOprController {
	
	private final UnidadMedidaService unidadMedidaService;
	
	public UnidadMedidaOprController(UnidadMedidaService unidadMedidaService) {
		this.unidadMedidaService = unidadMedidaService;
	}
	
	@GetMapping("/{idUnidadMedida}")
	public ResponseEntity<UnidadMedidaVO> byId(@PathVariable Integer idUnidadMedida) throws NegocioException{
		return ResponseEntity.ok(unidadMedidaService.byId(idUnidadMedida));
	}
	
	@GetMapping("/all")
	public List<UnidadMedidaVO> findAll() throws NegocioException {
		return unidadMedidaService.unidadesMedida();
	}
}