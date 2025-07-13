package mx.com.igv.pointofsale.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.igv.pointofsale.exception.NegocioException;
import mx.com.igv.pointofsale.service.ProveedorService;
import mx.com.igv.pointofsale.vo.ProveedorVO;

@RestController
@RequestMapping("/proveedores")
public class ProveedorOprController {
	
	public final ProveedorService proveedorService;
	
	public ProveedorOprController(ProveedorService proveedorService) {
		this.proveedorService = proveedorService;
	}
	
	@GetMapping("/{idProveedor}")
	public ResponseEntity<ProveedorVO> byId(@PathVariable Integer idProveedor) throws NegocioException {
		return ResponseEntity.ok(proveedorService.byId(idProveedor));
	}
	
	@GetMapping("/all")
	public List<ProveedorVO> findAll() throws NegocioException {
		return proveedorService.proveedores();
	}
}