package br.com.controle.crud.bean;

import br.com.controle.crud.dao.FreteDAO;
import br.com.controle.crud.entidade.Frete;
import br.com.controle.crud.util.CalcularValorEixos;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.PrimeFaces;

@ManagedBean
@SessionScoped
public class FreteMB {

    private CalcularValorEixos valorEixo = new CalcularValorEixos();
    private Frete frete = new Frete();
    private Frete freteOld = new Frete();
    private List<Frete> fretes = new ArrayList<>();
    private List<Frete> freteSimu = new ArrayList<>();
    private FreteDAO freteDAO = new FreteDAO();
    private List<Frete> fretesSelecionados = new ArrayList<>();
    private Long idFrete;

    public FreteMB () {
      //  fretesSelecionados = freteDAO.findAll();
     
    }
    


    public Frete getFreteOld() {
        return freteOld;
    }

    public void setFreteOld(Frete freteOld) {
        this.freteOld = freteOld;
    }

    public List<Frete> getFreteSimu() {
        return freteSimu;
    }

    public void setFreteSimu(List<Frete> freteSimu) {
        this.freteSimu = freteSimu;
    }

    
    public String novoFrete()
    {
    frete = new Frete();
        return "/novo-frete.xhtml?faces-redirect=true";
    }
    public String freteSimular()
            
    {
        frete = freteOld;
    
        return "/simular-frete.xhtml?faces-redirect=true";
    }
    
         public String excluirSel( )
    {
    
        System.out.println("Frete teste exclusão ");
        System.out.println("Frete ID " + frete.getId());
        freteDAO.remove(frete.getId());
        
        this.listar();
        System.out.println("FRETE EXCLUÍDO COM SUCESSO!!!");
        return "/listar-frete.xhtml?faces-redirect=true";
     
    }
    
    public List<Frete> getFretesSelecionados() {
        return fretesSelecionados;
    }

    public void setFretesSelecionados(List<Frete> fretesSelecionados) {
        this.fretesSelecionados = fretesSelecionados;
    }

    public void listar() {

      fretes = new ArrayList<>();
        System.out.println("tentativa de seleção de fretes!!!");
        fretes = freteDAO.findAll();
       

    }

  
     
    public Long getIdFrete() {
        return idFrete;
    }

    public void setIdFrete(Long idFrete) {
        
        System.out.println("Frete ID: " + idFrete); 
        this.idFrete = idFrete;
    }

    public void inicializar() {
        if (idFrete != null) {
            frete = freteDAO.porId(idFrete);

        }
    }

    private void setValoresEixos(Frete frete)
    {
    
           BigDecimal valor;

        valor = valorEixo.getValorEixo(2, frete.getCusto_KM());
        frete.setCustoEX2(valor);

        valor = valorEixo.getValorEixo(3, frete.getCusto_KM());
        frete.setCustoEX3(valor);

        valor = valorEixo.getValorEixo(4, frete.getCusto_KM());
        frete.setCustoEX4(valor);

        valor = valorEixo.getValorEixo(5, frete.getCusto_KM());
        frete.setCustoEX5(valor);

        valor = valorEixo.getValorEixo(6, frete.getCusto_KM());
        frete.setCustoEX6(valor);
        
        valor = valorEixo.getValorEixo(7, frete.getCusto_KM());
        frete.setCustoEX7(valor);

        valor = valorEixo.getValorEixo(9, frete.getCusto_KM());
        frete.setCustoEX9(valor);
        
    }
   
    public String Salvar() {

        setValoresEixos(this.frete);   

        freteDAO.save(frete);
        frete = new Frete();

          FacesMessage message =  
                       new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro de Frete", 
                                                                     "Frete cadastrado com sucesso!");
      
         
        PrimeFaces.current().dialog().showMessageDynamic(message);     
      
        return "";
    }
    
        public String calcSimulacao() {

              System.out.println("FRETE teste simulação!!!"); 
        setValoresEixos(this.freteOld);   

    
        frete = new Frete();
        System.out.println("FRETE SALVO COM SUCESSO!!!");
        return "/simular-frete.xhtml?faces-redirect=true";
    }

    public String editar(Frete c) {
        frete = c;
        return "cadastro-frete.xhtml?faces-redirect=true";
    }

    public Frete getFrete() {
        return frete;
    }

    public void setFrete(Frete frete) {
        this.frete = frete;
    }

    public List<Frete> getFretes() {
        return fretes;
    }

    public void setFretes(List<Frete> fretes) {
        this.fretes = fretes;
    }
    
    

}
