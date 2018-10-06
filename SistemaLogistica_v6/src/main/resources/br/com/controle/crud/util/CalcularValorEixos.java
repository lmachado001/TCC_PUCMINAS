/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.crud.util;

import java.math.BigDecimal;

public class CalcularValorEixos {
    
    
    public BigDecimal getValorEixo(Integer Eixo, BigDecimal Valor)
            
    {
        BigDecimal valor = new BigDecimal(Eixo);
        BigDecimal valor_final = Valor.multiply(valor);
              
        System.out.println("Valor " + valor_final.toString() +  " Eixos = " + Eixo.toString() );
               
           return valor_final;
           
    }
}
