package mx.com.igv.pointofsale.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.com.igv.pointofsale.exception.NegocioException;
import mx.com.igv.pointofsale.service.UnidadMedidaService;
import mx.com.igv.pointofsale.vo.UnidadMedidaVO;

@Controller
@RequestMapping("/unidadesmedidas")
public class UnidadMedidaController {
	
	private final UnidadMedidaService unidadMedidaService;
	
	public UnidadMedidaController(UnidadMedidaService unidadMedidaService) {
		this.unidadMedidaService = unidadMedidaService;
	}
	
	@GetMapping
	public String unidadesMedidas(Model model) throws NegocioException{
		List<UnidadMedidaVO> unidadesMedida = unidadMedidaService.unidadesMedida();
		model.addAttribute("unidadesmedida", unidadesMedida);
		return "unidadesmedida";
	}
	
	@PostMapping
	public void crear(@RequestBody UnidadMedidaVO unidadMedidaVO) {
		unidadMedidaService.crearActualizar(unidadMedidaVO);
	}
	
	@PutMapping
	public ResponseEntity<String> actualizar(@RequestBody UnidadMedidaVO unidadMedidaVO) throws NegocioException {
		unidadMedidaService.crearActualizar(unidadMedidaVO);
		return ResponseEntity.ok("Datos recibidos correctamente");
	}
	
	@GetMapping("/eliminar/{idUnidadMedida}")
	public String eliminar(@PathVariable Integer idUnidadMedida) throws NegocioException {
		unidadMedidaService.eliminar(idUnidadMedida);
		return "redirect:/unidadesmedidas";
	}
}