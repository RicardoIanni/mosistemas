package br.com.ricardoianni.mosistemas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.ricardoianni.mosistemas.domain.Veiculo;
import br.com.ricardoianni.mosistemas.repository.VeiculoRepository;

@Controller
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository veiculoRepository;

	@GetMapping(path = "/")
	public String inicio(Model model) {
		List<Veiculo> veiculos = veiculoRepository.findAll();
		
		model.addAttribute("veiculos", veiculos);
		
		return "index";
	}	
 }
