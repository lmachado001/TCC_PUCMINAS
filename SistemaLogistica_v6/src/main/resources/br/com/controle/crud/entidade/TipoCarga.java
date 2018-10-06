/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.crud.entidade;

/**
 *
 * @author Dell
 */
public enum TipoCarga {
    
    GERAL("Carga Geral"),
    GRANEL("Carga Granel"),
    GRANEL_NEO("Carga Neo Granel"),
    GRANEL_FRI("Carga Frigorifica"),
    PERIGOSA("Carga Perigosa");       
    
    private String descricao;
    
    TipoCarga(String descricao) {
		this.descricao = descricao;
	}
    
    	public String getDescricao() {
		return descricao;
	}

    
}
