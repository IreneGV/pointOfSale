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
import mx.com.igv.pointofsale.service.CategoriaService;
import mx.com.igv.pointofsale.vo.CategoriaVO;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
	
	private final CategoriaService categoriaService;
	
	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	
	@GetMapping
	public String categorias(Model model) throws NegocioException{
		List<CategoriaVO> categorias = categoriaService.categorias();
		model.addAttribute("categorias", categorias);
		return "categorias";
	}
	
	@PostMapping
	public void crear(@RequestBody CategoriaVO categoriaVO) {
		categoriaService.crearActualizar(categoriaVO);
	}
		
	@PutMapping
	public ResponseEntity<String> actualizar(@RequestBody CategoriaVO categoriaVO) throws NegocioException {
		categoriaService.crearActualizar(categoriaVO);
		return ResponseEntity.ok("Datos recibidos correctamente");
	}
	
	@GetMapping("/eliminar/{idCategoria}")
	public String eliminar(@PathVariable Integer idCategoria) throws NegocioException {
		categoriaService.eliminar(idCategoria);
		return "redirect:/categorias";
	}
}