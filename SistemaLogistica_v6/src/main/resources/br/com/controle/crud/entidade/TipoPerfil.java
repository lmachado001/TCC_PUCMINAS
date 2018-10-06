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
public enum TipoPerfil {
    
    ADM("Administrador"),
    FUNC("Funcionário"),
    CLI("Cliente"),
    PARC("Parceiro");       
    
    private String descricao;
    
    TipoPerfil(String descricao) {
		this.descricao = descricao;
	}
    
    	public String getDescricao() {
		return descricao;
	}

    
}
