package br.com.controle.crud.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.controle.crud.entidade.Usuario;
import br.com.controle.crud.util.ConnectionFactory;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
 *
 * @author Dell
 */
public class UsuarioDAO {
    
    
      public String convertStringToMd5(String valor) {
        MessageDigest mDigest;
        try {
            //Instanciamos o nosso HASH MD5, poderíamos usar outro como
            //SHA, por exemplo, mas optamos por MD5.
            mDigest = MessageDigest.getInstance("MD5");

            //Convert a String valor para um array de bytes em MD5
            byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8"));

            //Convertemos os bytes para hexadecimal, assim podemos salvar
            //no banco para posterior comparação se senhas
            StringBuffer sb = new StringBuffer();
            for (byte b : valorMD5) {
                sb.append(Integer.toHexString((b & 0xFF)
                        | 0x100).substring(1, 3));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
 
     public Usuario validaUsuario(String login, String senha)
     {
         EntityManager em = new ConnectionFactory().getConnection(); 
        String qry = "from Usuario as u where u.login=:login and u.senha=:senha";
        String senha2 = convertStringToMd5(senha);
        Usuario usuario = null;
        try {
          
            Query query = em.createQuery(qry);
            query.setParameter("login", login);
            query.setParameter("senha", senha2);
            usuario = (Usuario) query.getSingleResult();
        } catch (Exception e) {
            System.err.println("Erro ao fazer a busca");
            e.printStackTrace();
            return null;
        }
        return usuario;
}
    // SALVAR
    public Usuario save(Usuario usuario) {

        EntityManager em = new ConnectionFactory().getConnection();
       
        try {

            em.getTransaction().begin();
            
            // Editar registro
            if (usuario.isEdicao()) {
                em.persist(usuario);
            }

            // modificar registro
            if (usuario.isInclusao()) {
                em.merge(usuario);
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            System.err.println("ERRO AO SALVAR O REGISTRO:  " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return usuario;

    }
    
// SELECIONAR TODOS OS REGISTROS  
    public List<Usuario> findAll() {

        EntityManager em = new ConnectionFactory().getConnection();
        
        List<Usuario> usuario = null;

        try {
            usuario = em.createQuery("from Usuario c").getResultList();
        } catch (Exception e) {

            System.err.println("ERRO AO SELECIONAR OS REGISTROS: " + e);
        } finally {
            em.close();
        }

        return usuario;
    }

    public Usuario remove(Integer id) {
        
        EntityManager em = new ConnectionFactory().getConnection();

        Usuario usuario = null;
        try {

            usuario = em.find(Usuario.class, id);
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.err.println("ERRO AO EXCLUIR O REGISTRO : " + e);
            em.getTransaction().rollback();
        } finally {

            em.close();
        }

        return usuario;
    }
    
  
    public Usuario porId(Long id) {
        
        EntityManager em = new ConnectionFactory().getConnection();
        
		return em.find(Usuario.class, id);
	}

}
