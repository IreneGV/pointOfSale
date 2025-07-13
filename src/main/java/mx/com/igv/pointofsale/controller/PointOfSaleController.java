package mx.com.igv.pointofsale.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PointOfSaleController {
	
	private static final Logger logger = LogManager.getLogger(PointOfSaleController.class);
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("pageTitle", "Inicio");
		return "home";
	}
}
