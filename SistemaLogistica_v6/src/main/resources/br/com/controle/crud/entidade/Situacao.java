package br.com.controle.crud.entidade;


public enum Situacao {
    
 
     TRANSF("Tranferido"),   
    AMANDAMENTO("Em andamento"),
     CONCLUIDO("Concluído"),
    PERIGOSA("Carga Perigosa");
    
      private String descricao;
    
    Situacao(String descricao) {
		this.descricao = descricao;
	}
    
    	public String getDescricao() {
		return descricao;
	}
}
