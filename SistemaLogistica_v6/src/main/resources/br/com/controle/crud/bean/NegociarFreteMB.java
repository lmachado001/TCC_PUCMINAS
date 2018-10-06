package br.com.controle.crud.bean;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;



@ManagedBean(name = "negociarBean") 
@SessionScoped
public class NegociarFreteMB implements Serializable {
     
      public Long w;
       public String viewNegociarFrete() {
    
     
           
               FacesMessage message =  
                       new FacesMessage(FacesMessage.SEVERITY_WARN, "Solicitação de Negociação", 
                                                                     "Solicitação enviada com sucesso!");
         
        PrimeFaces.current().dialog().showMessageDynamic(message);

            return "";
        
    }
}
