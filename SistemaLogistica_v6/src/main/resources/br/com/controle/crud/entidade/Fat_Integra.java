package br.com.controle.crud.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fat_Integra implements Serializable {
  
        private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    private String cep_ori;
    private String cep_dest;
    private String endereco_ori;
    private String endereco_dest;
    private String num_ori;
    private String num_dest;
    private String cidade_ori;
    private String cidade_dest;
    private String estado_ori;
    private String estado_des;
    private Integer km;
    
     @Column(precision = 12, scale = 3)
    private BigDecimal valor; 

         public boolean isInclusao() {
        return getId() == null ? true : false;
    }

    public boolean isEdicao() {
        return !isInclusao();
    }
    public String getCidade_des() {
        return cidade_dest;
    }

    public void setCidade_des(String cidade_des) {
        this.cidade_dest = cidade_des;
    }

    public String getEstado_ori() {
        return estado_ori;
    }

    public void setEstado_ori(String estado_ori) {
        this.estado_ori = estado_ori;
    }

    public String getEstado_des() {
        return estado_des;
    }

    public void setEstado_des(String estado_des) {
        this.estado_des = estado_des;
    }

     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep_ori() {
        return cep_ori;
    }

    public void setCep_ori(String cep_ori) {
        this.cep_ori = cep_ori;
    }

    public String getCep_dest() {
        return cep_dest;
    }

    public void setCep_dest(String cep_dest) {
        this.cep_dest = cep_dest;
    }

    public String getEndereco_ori() {
        return endereco_ori;
    }

    public void setEndereco_ori(String endereco_ori) {
        this.endereco_ori = endereco_ori;
    }

    public String getEndereco_dest() {
        return endereco_dest;
    }

    public void setEndereco_dest(String endereco_dest) {
        this.endereco_dest = endereco_dest;
    }

    public String getCidade_ori() {
        return cidade_ori;
    }

    public void setCidade_ori(String cidade_ori) {
        this.cidade_ori = cidade_ori;
    }

    public String getCidade_dest() {
        return cidade_dest;
    }

    public void setCidade_dest(String cidade_dest) {
        this.cidade_dest = cidade_dest;
    }

    public String getNum_ori() {
        return num_ori;
    }

    public void setNum_ori(String num_ori) {
        this.num_ori = num_ori;
    }

    public String getNum_dest() {
        return num_dest;
    }

    public void setNum_dest(String num_dest) {
        this.num_dest = num_dest;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
     
     
     
    
}
