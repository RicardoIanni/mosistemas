package br.com.ricardoianni.mosistemas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ricardoianni.mosistemas.domain.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	
	public Veiculo findByIdVeiculo(Long idVeiculo);

}
