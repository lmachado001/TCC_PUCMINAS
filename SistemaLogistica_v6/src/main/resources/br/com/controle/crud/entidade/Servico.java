
package br.com.controle.crud.entidade;

public enum Servico {
    
 
   COLETA("Coleta"),   
    TRANSP("Transporte");
    
    
      private final String descricao;
    
    Servico(String descricao) {
		this.descricao = descricao;
	}
    
    	public String getDescricao() {
		return descricao;
	}
}

