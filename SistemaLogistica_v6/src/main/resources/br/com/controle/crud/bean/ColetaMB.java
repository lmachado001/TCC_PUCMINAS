package br.com.controle.crud.bean;

import br.com.controle.crud.dao.ColetaDAO;
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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

@ManagedBean
@SessionScoped
public class ColetaMB {

    private CalcularValorEixos valorEixo = new CalcularValorEixos();
    private Coleta coleta = new Coleta();
    private List<Coleta> coletas = new ArrayList<>();
    private ColetaDAO coletaDAO = new ColetaDAO();
    private List<Coleta> coletasSelecionados = new ArrayList<>();
    private ConsultarCEP cepEJB;

    private Long idColeta;

    public ColetaMB() {

    }

    public List<Coleta> getColetasSelecionados() {
        return coletasSelecionados;
    }

    public void setColetasSelecionados(List<Coleta> coletasSelecionados) {
        this.coletasSelecionados = coletasSelecionados;
    }

    public void listar() {

        System.out.println("Tentativa seleção de coletas!!!");
        coletas = coletaDAO.findAll();
        System.out.println("COLETAS SELECIONADO COM SUCESSO!!!");

    }

    public Long getIdColeta() {
        return idColeta;
    }

    public void setIdColeta(Long idColeta) {
        this.idColeta = idColeta;
    }

    public void inicializar() {

        if (idColeta != null) {
            coleta = coletaDAO.porId(idColeta);

        }
    }

    public String novoColeta() {
        coleta = new Coleta();
        return "/cadastro-coleta.xhtml?faces-redirect=true";
    }

    public String pesquisarCEP(String local) {

        System.out.println("Teste pesquisa de CEP");

        String cep;

        if (Objects.equals(local, "O")) {

            cep = coleta.getCep_ori();

            System.out.println("CEP origem " + cep);

            try {
                this.cepEJB = new ConsultarCEP(cep);
                coleta.setEndereco_ori(cepEJB.getEnd());
                coleta.setEstado_ori(cepEJB.getEstado());
                coleta.setCidade_ori(cepEJB.getCidade());

                System.out.println("Endereço: " + cepEJB.getEnd());
            } catch (SQLException_Exception | SigepClienteException ex) {
                Logger.getLogger(Fat_IntegraMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            cep = coleta.getCep_dest();
            try {

                this.cepEJB = new ConsultarCEP(cep);
                coleta.setEndereco_dest(cepEJB.getEnd());
                coleta.setEstado_des(cepEJB.getEstado());
                coleta.setCidade_dest(cepEJB.getCidade());
            } catch (SQLException_Exception | SigepClienteException ex) {
                Logger.getLogger(Fat_IntegraMB.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
          FacesContext context = FacesContext.getCurrentInstance();
    return context.getViewRoot().getViewId() + "/cadastro-coleta.xhtml?faces-redirect=true";
        
    //    return "/cadastro-coleta.xhtml?faces-redirect=true";

    }
    
           public String excluirSel( )
    {
    
        System.out.println("Coleta teste exclusão ");
        System.out.println("Coleta ID " + coleta.getId());
        coletaDAO.remove(coleta.getId());
        
        this.listar();
        System.out.println("COLETA EXCLUÍDO COM SUCESSO!!!");
        return "/listar-coleta.xhtml?faces-redirect=true";
     
    }

    public String Salvar() {

        System.out.println("TESTE EVENTO!!!");
        this.pesquisarCEP("O");
        this.pesquisarCEP("");
        coletaDAO.save(coleta);
        coleta = new Coleta();
        System.out.println("COLETA SALVO COM SUCESSO!!!");

              FacesMessage message =  
                       new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro de Coleta", 
                                                                     "Coleta cadastrada com sucesso!");
      
         
        PrimeFaces.current().dialog().showMessageDynamic(message);
        return "";
        //  return "/listar-coleta?faces-redirect=true";
    }

    public String editar(Coleta c) {
        coleta = c;
        return "cadastro-coleta.xhtml?faces-redirect=true";
    }

    public Coleta getColeta() {
        return coleta;
    }

    public void setColeta(Coleta coleta) {
        this.coleta = coleta;
    }

    public List<Coleta> getColetas() {
        return coletas;
    }

    public void setColetas(List<Coleta> coletas) {
        this.coletas = coletas;
    }

}
