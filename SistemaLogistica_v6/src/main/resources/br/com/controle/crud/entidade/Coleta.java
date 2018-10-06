package br.com.controle.crud.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

@Entity
public class Coleta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date prazo;


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

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }
    
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Servico servico;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Origem origem;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Faturado faturado;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

     public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public Faturado getFaturado() {
        return faturado;
    }

    public void setFaturado(Faturado faturado) {
        this.faturado = faturado;
    }
    
      public boolean isInclusao() {
        return getId() == null ? true : false;
    }

    public boolean isEdicao() {
        return !isInclusao();
    }

}
