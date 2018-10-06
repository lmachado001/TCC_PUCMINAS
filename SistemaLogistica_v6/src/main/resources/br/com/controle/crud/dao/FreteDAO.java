package br.com.controle.crud.dao;


import br.com.controle.crud.entidade.Frete;
import br.com.controle.crud.util.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;


public class FreteDAO {

// SALVAR
    public Frete save(Frete frete) {

        EntityManager em = new ConnectionFactory().getConnection();
       
        try {

            em.getTransaction().begin();
            
            // Editar registro
            if (frete.isEdicao()) {
                em.persist(frete);
            }

            // modificar registro
            if (frete.isInclusao()) {
                em.merge(frete);
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            System.err.println("ERRO AO SALVAR O REGISTRO:  " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return frete;

    }
    
// SELECIONAR TODOS OS REGISTROS  
    public List<Frete> findAll() {

        EntityManager em = new ConnectionFactory().getConnection();
        
        List<Frete> frete = null;

        try {
            frete = em.createQuery("from Frete c").getResultList();
        } catch (Exception e) {

            System.err.println("ERRO AO SELECIONAR OS REGISTROS: " + e);
        } finally {
            em.close();
        }

        return frete;
    }

    public Frete remove(long id) {
        
        EntityManager em = new ConnectionFactory().getConnection();

        Frete frete = null;
        try {

            frete = em.find(Frete.class, id);
            em.getTransaction().begin();
            em.remove(frete);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.err.println("ERRO AO EXCLUIR O REGISTRO : " + e);
            em.getTransaction().rollback();
        } finally {

            em.close();
        }

        return frete;
    }
    
  
    public Frete porId(Long id) {
        
        EntityManager em = new ConnectionFactory().getConnection();
        
		return em.find(Frete.class, id);
	}

}
