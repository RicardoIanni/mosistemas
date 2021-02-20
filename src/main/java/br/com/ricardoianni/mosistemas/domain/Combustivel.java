package br.com.ricardoianni.mosistemas.domain;

public enum Combustivel {

	DIESEL("Diesel"),
	ETANOL("Etanol"),
	GASOLINA("Gasolina"),
	GNV("GNV");
	
	private String texto;

	private Combustivel(String texto) {
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}
	
}
