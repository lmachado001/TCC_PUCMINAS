package br.com.controle.crud.entidade;


// Generated 22/08/2017 13:55:59 by Hibernate Tools 4.3.1

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Usuario generated by hbm2java
 */
@Entity
public class Usuario implements java.io.Serializable {
    
    private static final long serialVersionUID = 1L;  

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String senha;
    private TipoPerfil idPerfil;

    public Usuario() {
    }

    public Usuario(String login, String senha, TipoPerfil idPerfil) {
        this.login = login;
        this.senha = senha;
        this.idPerfil = idPerfil;
    }

    public Usuario(Usuario login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login.trim().toLowerCase();
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoPerfil getIdPerfil() {
        return this.idPerfil;
    }

    public void setIdPerfil(TipoPerfil idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
       public boolean isInclusao() {
        return getId() == null ? true : false;
    }

    public boolean isEdicao() {
        return !isInclusao();
    }

    
    

}