package br.com.ricardoianni.mosistemas.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ricardoianni.mosistemas.domain.Combustivel;
import br.com.ricardoianni.mosistemas.domain.Veiculo;
import br.com.ricardoianni.mosistemas.domain.VeiculoDTO;
import br.com.ricardoianni.mosistemas.repository.VeiculoRepository;

@RestController
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Veiculo> listVeiculos(Model model) {
 
        List<Veiculo> veiculos = veiculoRepository.findAll(Sort.by("idVeiculo"));
        
        model.addAttribute("veiculo", new Veiculo());
        model.addAttribute("veiculos", veiculos);
        
        return veiculos;
    }
    
    @RequestMapping(value = "/combustivel", method = RequestMethod.GET, headers = "Accept=application/json")
    public Combustivel[] listCombustivel() {
    	return Combustivel.values();
    } 
    
    @RequestMapping(value = "/saveVeiculo", method = RequestMethod.POST, headers = "Accept=application/json")
    public Veiculo addVeiculo(@RequestBody VeiculoDTO veiculoDTO) {
    	Veiculo veiculo = new Veiculo();
    	
    	if ((veiculoDTO.getIdVeiculo().isBlank() || veiculoDTO.getIdVeiculo().isEmpty())) {
    		veiculo.setIdVeiculo(null);
    	} else {
    		veiculo.setIdVeiculo(Long.valueOf(veiculoDTO.getIdVeiculo()));
    	}
    	veiculo.setAno(Integer.valueOf(veiculoDTO.getAno()));
    	veiculo.setCombustivel(Combustivel.valueOf(veiculoDTO.getCombustivel()));
    	veiculo.setCor(veiculoDTO.getCor());
    	veiculo.setObservacao(veiculoDTO.getObservacao());
    	veiculo.setPlaca(veiculoDTO.getPlaca());
    	veiculo.setRenavam(Long.valueOf(veiculoDTO.getRenavam()));
    	
        return veiculoRepository.save(veiculo);
    }
 
    @RequestMapping(value = "/saveVeiculo", method = RequestMethod.PUT, headers = "Accept=application/json")
    public Veiculo updateVeiculo(@Valid @RequestBody VeiculoDTO veiculoDTO) {
    	Veiculo veiculo = veiculoRepository.findByIdVeiculo(Long.valueOf(veiculoDTO.getIdVeiculo()));
    	
    	veiculo.setAno(Integer.valueOf(veiculoDTO.getAno()));
    	veiculo.setCombustivel(Combustivel.valueOf(veiculoDTO.getCombustivel()));
    	veiculo.setCor(veiculoDTO.getCor());
    	veiculo.setObservacao(veiculoDTO.getObservacao());
    	veiculo.setPlaca(veiculoDTO.getPlaca());
    	veiculo.setRenavam(Long.valueOf(veiculoDTO.getRenavam()));
    	
        return veiculoRepository.save(veiculo); 
    }   
    
    @RequestMapping(value = "/deleteVeiculo/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deleteVeiculo(@PathVariable("id") String idVeiculo) {
    	veiculoRepository.deleteById(Long.valueOf(idVeiculo));
    }
}
