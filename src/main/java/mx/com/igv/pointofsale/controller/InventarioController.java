package mx.com.igv.pointofsale.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.igv.pointofsale.exception.NegocioException;
import mx.com.igv.pointofsale.service.InventarioService;
import mx.com.igv.pointofsale.vo.InventarioVO;

@RestController
@RequestMapping("/inventarios")
public class InventarioController {
	
	private final InventarioService inventarioService;
	
	public InventarioController(InventarioService inventarioService) {
		this.inventarioService = inventarioService;
	}
	
	@GetMapping
	public List<InventarioVO> inventarios() throws NegocioException{
		return inventarioService.inventarios();
	}
	
	@GetMapping("/{idProducto}")
	public List<InventarioVO> byProducto(@PathVariable Integer idProducto) throws NegocioException{
		return inventarioService.byProducto(idProducto);
	}
	
	@PostMapping
	public void crear(@RequestBody InventarioVO inventarioVO) {
		inventarioService.crear(inventarioVO);
	}
	
	@PutMapping
	public void actualizar(InventarioVO inventarioVO) throws NegocioException {
		inventarioService.actualizar(inventarioVO);
	}
	
	@DeleteMapping
	public void eliminar(Integer idInventario) throws NegocioException {
		inventarioService.eliminar(idInventario);
	}
}