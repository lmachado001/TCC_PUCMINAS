package br.com.controle.crud.entidade;


public enum Origem {
    
 
     LOCAL("Local"),   
    CLIENTE("Cliente");
    
      private String descricao;
    
    Origem(String descricao) {
		this.descricao = descricao;
	}
    
    	public String getDescricao() {
		return descricao;
	}
}
