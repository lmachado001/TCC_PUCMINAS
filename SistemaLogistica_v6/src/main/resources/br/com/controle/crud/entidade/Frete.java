package br.com.controle.crud.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Frete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer km_inicio;

    private Integer km_fim;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoCarga tipo_carga;

    @Column(precision = 12, scale = 3)
    private BigDecimal custo_KM;
    @Column(precision = 12, scale = 3)
    private BigDecimal custoEX2;
    @Column(precision = 12, scale = 3)
    private BigDecimal custoEX3;
    @Column(precision = 12, scale = 3)
    private BigDecimal custoEX4;
    @Column(precision = 12, scale = 3)
    private BigDecimal custoEX5;
    @Column(precision = 12, scale = 3)
    private BigDecimal custoEX6;
    @Column(precision = 12, scale = 3)
    private BigDecimal custoEX7;
    @Column(precision = 12, scale = 3)
    private BigDecimal custoEX9;

    /*private Date criacao;
    private Date edicao;
     */
    public TipoCarga getTipo_carga() {
        return tipo_carga;
    }

    public void setTipo_carga(TipoCarga tipo_carga) {
        this.tipo_carga = tipo_carga;
    }

    public BigDecimal getCustoEX2() {
        return custoEX2;
    }

    public void setCustoEX2(BigDecimal custoEX2) {
        this.custoEX2 = custoEX2;
    }

    public BigDecimal getCustoEX3() {
        return custoEX3;
    }

    public void setCustoEX3(BigDecimal custoEX3) {
        this.custoEX3 = custoEX3;
    }

    public BigDecimal getCustoEX4() {
        return custoEX4;
    }

    public void setCustoEX4(BigDecimal custoEX4) {
        this.custoEX4 = custoEX4;
    }

    public BigDecimal getCustoEX5() {
        return custoEX5;
    }

    public void setCustoEX5(BigDecimal custoEX5) {
        this.custoEX5 = custoEX5;
    }

    public BigDecimal getCustoEX6() {
        return custoEX6;
    }

    public void setCustoEX6(BigDecimal custoEX6) {
        this.custoEX6 = custoEX6;
    }

    public BigDecimal getCustoEX7() {
        return custoEX7;
    }

    public void setCustoEX7(BigDecimal custoEX7) {
        this.custoEX7 = custoEX7;
    }

    public BigDecimal getCustoEX9() {
        return custoEX9;
    }

    public void setCustoEX9(BigDecimal custoEX9) {
        this.custoEX9 = custoEX9;
    }

    public BigDecimal getCusto_KM() {
        return custo_KM;
    }

    public void setCusto_KM(BigDecimal custo_KM) {
        this.custo_KM = custo_KM;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getKm_inicio() {
        return km_inicio;
    }

    public void setKm_inicio(Integer km_inicio) {
        this.km_inicio = km_inicio;
    }

    public Integer getKm_fim() {
        return km_fim;
    }

    public void setKm_fim(Integer km_fim) {
        this.km_fim = km_fim;
    }

    public boolean isInclusao() {
        return getId() == null ? true : false;
    }

    public boolean isEdicao() {
        return !isInclusao();
    }

}
