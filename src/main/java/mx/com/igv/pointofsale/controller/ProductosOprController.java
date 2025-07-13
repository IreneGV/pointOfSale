package mx.com.igv.pointofsale.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.igv.pointofsale.exception.NegocioException;
import mx.com.igv.pointofsale.service.ProductoService;
import mx.com.igv.pointofsale.vo.ProductoVO;

@RestController
@RequestMapping("/productos")
public class ProductosOprController {
	
private final ProductoService productoService;
	
	public ProductosOprController(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@GetMapping("/{idProducto}")
	public ResponseEntity<ProductoVO> byId(@PathVariable Integer idProducto) throws NegocioException {
		return ResponseEntity.ok(productoService.productobyId(idProducto));
	}
}
