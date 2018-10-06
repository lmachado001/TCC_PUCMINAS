/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.crud.bean;


import br.com.controle.crud.dao.UsuarioDAO;
import br.com.controle.crud.entidade.TipoPerfil;
import br.com.controle.crud.entidade.Usuario;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

@ManagedBean
@SessionScoped
public class LoginMB implements Serializable {

    private static final long serialVersionUID = 1L;

    final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private Usuario usuario = new Usuario();
    private String login, senha;
    private TipoPerfil perfil;

    // cadastrar usuário

public void addNewUser()
{
    
    System.out.println("Usuário: " + login);
    System.out.println("Senha:   " + senha);
    System.out.println("Perfil:   " + perfil);
    
   usuario.setLogin(login);
   usuario.setIdPerfil(perfil);
   usuario.setSenha(senha);
   
  usuario.setSenha(usuarioDAO.convertStringToMd5(senha));  
  
  System.out.println("Senha:   " + usuario.getSenha());
  
   usuarioDAO.save(usuario);
   
            FacesMessage message =  
                       new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro de usuário", 
                                                                     "Usuário criado com sucesso!");
         
        PrimeFaces.current().dialog().showMessageDynamic(message);
    
}

    public TipoPerfil getPerfil() {
        return perfil;
    }

    public void setPerfil(TipoPerfil perfil) {
        this.perfil = perfil;
    }
    
    
//Realiza o login caso de tudo certo
    public String doLogin() {

       TipoPerfil perfil;
        usuario = usuarioDAO.validaUsuario(login, senha);

        
      if (usuario == null) {
                 
               FacesMessage message =  
                       new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no Login", 
                                                                     "Usuário não encontrado!");
         
        PrimeFaces.current().dialog().showMessageDynamic(message);
            
         //   return "/login.xhtml?faces-redirect=true";
        } else {

         
          
                 switch (usuario.getIdPerfil()) {
                case ADM:

                    return "/principalAdmin.xhtml?faces-redirect=true";

                case FUNC:

                    return "/index.xhtml?faces-redirect=true";

                case CLI:

                    return "/Professor/principalProfessor.xhtml?faces-redirect=true";

                case PARC:

                    return "/Aluno/principalAluno.xhtml?faces-redirect=true";
            }
        }
        
      
      
      
      System.out.println("perfil usuário: " + usuario.getIdPerfil());
 
       return null;     
        
    }

    //Realiza o logout do usuário logado
    public String doLogout() {

     
        return "/login.xhtml?faces-redirect=true";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
