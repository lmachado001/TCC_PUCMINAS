package br.com.controle.crud.entidade;


public enum Faturado {
    
 
     SIM("Sim"),   
    NAO("Não");
    
      private String descricao;
    
    Faturado(String descricao) {
		this.descricao = descricao;
	}
    
    	public String getDescricao() {
		return descricao;
	}
}
