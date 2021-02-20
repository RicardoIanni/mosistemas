package br.com.ricardoianni.mosistemas.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Veiculo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idveiculo", nullable = false)
	private Long idVeiculo;
	
	@NotBlank(message = "Campo Obrigatório")
	@Pattern(regexp = "[A-Z]{3}-[0-9]{4}", message = "Placa inválida")
	@Column(length = 8, nullable = false)
	private String placa;
	
	@Column(precision = 4, nullable = true)
	private Integer ano;
	
	@NotNull(message = "Campo Obrigatório")
	private Combustivel combustivel;
	
	@NotNull(message = "Campo Obrigatório")
	@Column(precision = 11, nullable = false)
	private Long renavam;
	
	@NotBlank(message = "Campo Obrigatório")
	@Column(length = 50, nullable = false)
	private String cor;
	
	@Column(length = 200, nullable = true)
	private String observacao;
	
}
