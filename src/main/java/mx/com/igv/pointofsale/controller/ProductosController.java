package mx.com.igv.pointofsale.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import mx.com.igv.pointofsale.exception.NegocioException;
import mx.com.igv.pointofsale.service.ProductoService;
import mx.com.igv.pointofsale.vo.ProductoVO;

@Controller
@RequestMapping("/productos")
public class ProductosController {
	
	private final ProductoService productoService;
	
	public ProductosController(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@GetMapping
	public String productos(Model model) throws NegocioException{
		List<ProductoVO> productos = productoService.productos();
		model.addAttribute("productos", productos);
		return "productos";
	}
	
	@PostMapping
	public ResponseEntity<String> crearActualizar(
			@RequestPart("producto") ProductoVO productoVO,
		    @RequestPart(value = "imagen", required = false) MultipartFile imagen
		    ) throws NegocioException {
		if(imagen != null && !imagen.isEmpty()) {
			String nombreImagen = "/img/productos/".concat(imagen.getOriginalFilename());
		    try {
		    	Path path = Paths.get("src/main/resources/static", nombreImagen);
			    Files.createDirectories(path.getParent());
			    Files.write(path, imagen.getBytes());
		    }catch(Exception e) {
		    	throw new NegocioException("No se pudo guardar la imagen seleccionada");
		    }
		    productoVO.setRutaImagen(nombreImagen);
		}
	    
		productoService.crearActualizar(productoVO);
		return ResponseEntity.ok("Datos recibidos correctamente");
	}
	
	@GetMapping("/eliminar/{idProducto}")
	public String eliminar(@PathVariable Integer idProducto) throws NegocioException {
		productoService.eliminar(idProducto);
		return "redirect:/productos";
	}
}