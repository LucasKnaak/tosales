package br.com.tt.model;

public enum Sexo {
	M("Masculino"),F("Feminino");
	
	private String descricao;
	
	private Sexo(String sexo){
		this.descricao = sexo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
