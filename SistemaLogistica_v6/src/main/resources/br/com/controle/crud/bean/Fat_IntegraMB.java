package br.com.controle.crud.bean;

import br.com.controle.crud.dao.Fat_IntegraDAO;
import br.com.controle.crud.entidade.Coleta;
import br.com.controle.crud.entidade.Fat_Integra;
import br.com.controle.crud.util.CalcularValorEixos;
import br.com.correios.webservice.postagem.SQLException_Exception;
import br.com.correios.webservice.postagem.SigepClienteException;
import br.com.correios.ws.ConsultarCEP;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Fat_IntegraMB {
    
    private CalcularValorEixos valorEixo = new CalcularValorEixos();
    private Fat_Integra fat_integra = new Fat_Integra();
    private List<Fat_Integra> fat_integras = new ArrayList<>();
    private Fat_Integra integra;
    private Fat_IntegraDAO fat_integraDAO = new Fat_IntegraDAO();
    private List<Fat_Integra> fat_integrasSelecionados = new ArrayList<>();
    private ConsultarCEP cepEJB;
    
    private Long idFat_Integra;
    
    public Fat_IntegraMB() {
         fat_integrasSelecionados = fat_integraDAO.findAll();
    }
    
   
    public Fat_IntegraMB(Coleta coleta) {
        // fat_integrasSelecionados = fat_integraDAO.findAll();
    }
    
    public List<Fat_Integra> getFat_IntegrasSelecionados() {
        return fat_integrasSelecionados;
    }
    
    public void setFat_IntegrasSelecionados(List<Fat_Integra> fat_integrasSelecionados) {
        this.fat_integrasSelecionados = fat_integrasSelecionados;
    }
    
    public void listar() {
        
        fat_integras = fat_integraDAO.findAll();
        System.out.println("COLETAS SELECIONADO COM SUCESSO!!!");
        
    }
    
    public Long getIdFat_Integra() {
        return idFat_Integra;
    }    
 
    
    public void setIdFat_Integra(Long idFat_Integra) {
               
        
        this.idFat_Integra = idFat_Integra;
    }
    
    public void inicializar() {
       
            System.out.println("TESTE inicializar FAT Integra!!!" + fat_integra.getCep_ori());
        if (idFat_Integra != null) {
            fat_integra = fat_integraDAO.porId(idFat_Integra);
            
        }
    }
    
    public String Salvar() {
        
        System.out.println("TESTE EVENTO!!!");
        fat_integraDAO.save(fat_integra);
        fat_integra = new Fat_Integra();
        System.out.println("COLETA SALVO COM SUCESSO!!!");
        return "listar-fat_integra?faces-redirect=true";
    }
    
    public void Editar(Fat_Integra c) {
        fat_integra = c;
    
    }
    
        public String pesquisarCEP(String local) {
        
        System.out.println("Teste pesquisa de CEP");
    
        
        String cep;
        
        if (Objects.equals(local, "O")) {
            
            fat_integra.setCep_ori("07082530");
            cep = fat_integra.getCep_ori(); 
            
            System.out.println("CEP origem "+ cep);
            
            try {
                this.cepEJB = new ConsultarCEP(cep);
                fat_integra.setEndereco_ori(cepEJB.getEnd());
              
                System.out.println("Endereço: " + cepEJB.getEnd());
            } catch (SQLException_Exception | SigepClienteException ex) {
                Logger.getLogger(Fat_IntegraMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else 
        {
              fat_integra.setCep_dest("07082440");
               cep = fat_integra.getCep_dest();  
               try {
                       
                this.cepEJB = new ConsultarCEP(cep);
                fat_integra.setCep_dest(cep);
            } catch (SQLException_Exception | SigepClienteException ex) {
                Logger.getLogger(Fat_IntegraMB.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
           return "/cadastro-coleta.xhtml?faces-redirect=true";
    }
    
    public Fat_Integra getFat_Integra() {
        return fat_integra;
    }
    
    public void setFat_Integra(Fat_Integra fat_integra) {
        this.fat_integra = fat_integra;
    }
    
    public List<Fat_Integra> getFat_Integras() {
        return fat_integras;
    }
    
    public void setFat_Integras(List<Fat_Integra> fat_integras) {
        this.fat_integras = fat_integras;
    }
    
}
