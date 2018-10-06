package br.com.controle.crud.dao;

import br.com.controle.crud.entidade.Coleta;
import br.com.controle.crud.util.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;


public class ColetaDAO {
 
  // SALVAR
    public Coleta save(Coleta coleta) {

        EntityManager em = new ConnectionFactory().getConnection();
       
        try {

            em.getTransaction().begin();
            
            // Editar registro
            if (coleta.isEdicao()) {
                em.persist(coleta);
            }

            // modificar registro
            if (coleta.isInclusao()) {
                em.merge(coleta);
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            System.err.println("ERRO AO SALVAR O REGISTRO:  " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        System.out.println("REGISTRO SALVO COM SUCESSO:  " );
        return coleta;

    }
      
     
    
// SELECIONAR TODOS OS REGISTROS  
    public List<Coleta> findAll() {

        EntityManager em = new ConnectionFactory().getConnection();
        
        List<Coleta> coleta = null;

        try {
            coleta = em.createQuery("from Coleta c").getResultList();
        } catch (Exception e) {

            System.err.println("ERRO AO SELECIONAR OS REGISTROS: " + e);
        } finally {
            em.close();
        }

        return coleta;
    }

    public Coleta remove(Long id) {
        
        EntityManager em = new ConnectionFactory().getConnection();

        Coleta coleta = null;
        try {

            coleta = em.find(Coleta.class, id);
            em.getTransaction().begin();
            em.remove(coleta);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.err.println("ERRO AO EXCLUIR O REGISTRO : " + e);
            em.getTransaction().rollback();
        } finally {

            em.close();
        }

        return coleta;
    }
    
  
    public Coleta porId(Long id) {
        
        EntityManager em = new ConnectionFactory().getConnection();
        
		return em.find(Coleta.class, id);
	}

}
