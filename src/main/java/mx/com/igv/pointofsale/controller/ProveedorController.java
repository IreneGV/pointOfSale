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
import mx.com.igv.pointofsale.service.ProveedorService;
import mx.com.igv.pointofsale.vo.ProveedorVO;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {
	
	public final ProveedorService proveedorService;
	
	public ProveedorController(ProveedorService proveedorService) {
		this.proveedorService = proveedorService;
	}
	
	@GetMapping
	public String proveedores(Model model) throws NegocioException {
		List<ProveedorVO> proveedores = proveedorService.proveedores();
		model.addAttribute("proveedores", proveedores);
		return "proveedor";
	}
	
	@PostMapping
	public void crear(@RequestBody ProveedorVO proveedorVO) {
		proveedorService.crearActualizar(proveedorVO);
	}
	
	@PutMapping
	public ResponseEntity<String> actualizar(@RequestBody ProveedorVO proveedorVO) throws NegocioException {
		proveedorService.crearActualizar(proveedorVO);
		return ResponseEntity.ok("Datos recibidos correctamente");
	}
	
	@GetMapping("/eliminar/{idProveedor}")
	public String eliminar(@PathVariable Integer idProveedor) throws NegocioException {
		proveedorService.eliminar(idProveedor);
		return "redirect:/proveedores";
	}
}