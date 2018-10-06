package br.com.controle.crud.util;

import br.com.correios.webservice.postagem.SQLException_Exception;
import br.com.correios.webservice.postagem.SigepClienteException;
import br.com.correios.ws.ConsultarCEP;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dell
 */
public final class PesquisarCEP {

    private ConsultarCEP cepEJB;

    private String cep;
    private String bairro;
    private String estado;
    private String cidade;
    private String end;

    public String getCep() {
        return cep;
    }

    public String getBairro() {
        return bairro;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEnd() {
        return end;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

   
    public void pesquisarCEP() {
        
        if (this.cep != null) {

            try {
                cepEJB = new ConsultarCEP(cep);
            } catch (SQLException_Exception | SigepClienteException ex) {
                Logger.getLogger(PesquisarCEP.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public PesquisarCEP(String cep) 
    
    {
        this.cep = cep;
        
        pesquisarCEP();

    }

}
