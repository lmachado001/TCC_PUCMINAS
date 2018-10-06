package br.com.controle.crud.dao;

import br.com.controle.crud.entidade.Fat_Integra;
import br.com.controle.crud.util.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;


public class Fat_IntegraDAO {
 
  // SALVAR
    public Fat_Integra save(Fat_Integra fat_integra) {

        EntityManager em = new ConnectionFactory().getConnection();
       
        try {

            em.getTransaction().begin();
            
            // Editar registro
            if (fat_integra.isEdicao()) {
                em.persist(fat_integra);
            }

            // modificar registro
            if (fat_integra.isInclusao()) {
                em.merge(fat_integra);
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            System.err.println("ERRO AO SALVAR O REGISTRO:  " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        System.out.println("REGISTRO SALVO COM SUCESSO:  " );
        return fat_integra;

    }
      
     
    
// SELECIONAR TODOS OS REGISTROS  
    public List<Fat_Integra> findAll() {

        EntityManager em = new ConnectionFactory().getConnection();
        
        List<Fat_Integra> fat_integra = null;

        try {
            fat_integra = em.createQuery("from Fat_Integra c").getResultList();
        } catch (Exception e) {

            System.err.println("ERRO AO SELECIONAR OS REGISTROS: " + e);
        } finally {
            em.close();
        }

        return fat_integra;
    }

    public Fat_Integra remove(Integer id) {
        
        EntityManager em = new ConnectionFactory().getConnection();

        Fat_Integra fat_integra = null;
        try {

            fat_integra = em.find(Fat_Integra.class, id);
            em.getTransaction().begin();
            em.remove(fat_integra);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.err.println("ERRO AO EXCLUIR O REGISTRO : " + e);
            em.getTransaction().rollback();
        } finally {

            em.close();
        }

        return fat_integra;
    }
    
  
    public Fat_Integra porId(Long id) {
        
        EntityManager em = new ConnectionFactory().getConnection();
        
		return em.find(Fat_Integra.class, id);
	}

}
