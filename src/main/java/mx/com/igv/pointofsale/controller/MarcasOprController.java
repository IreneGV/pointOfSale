package mx.com.igv.pointofsale.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.igv.pointofsale.exception.NegocioException;
import mx.com.igv.pointofsale.service.MarcasService;
import mx.com.igv.pointofsale.vo.MarcaVO;

@RestController
@RequestMapping("/marcas")
public class MarcasOprController {
	
	private final MarcasService marcasService;
	
	public MarcasOprController(MarcasService marcasService) {
		this.marcasService = marcasService;
	}
	
	@GetMapping("/all")
	public List<MarcaVO> findAll() throws NegocioException {
		return marcasService.marcas();
	}
}