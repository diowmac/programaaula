package entidades;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ProdutoService {
   
   
    //teste cometario
    
    private static EntityManagerFactory entityManagerFactory;
    
    static{
        try{
         entityManagerFactory = Persistence.createEntityManagerFactory("default");
        }catch(Exception e){
        }
    }
    

    public void deletarProduto(Long id){
        
        EntityManager em = entityManagerFactory.createEntityManager();
        
        try{
            
          em.getTransaction().begin();
          Produto produto = em.find(Produto.class, id);
          
          if (produto != null) {
              em.remove(produto);
          }
         em.getTransaction().commit(); 
          
        }catch(Exception e){
          em.getTransaction().rollback();
        }finally{
          em.close();
        }
        
    }
    
    public void editarProduto(Produto produto){
        
        EntityManager em = entityManagerFactory.createEntityManager();
        
        try{
          em.getTransaction().begin();
          em.merge(produto);
          em.getTransaction().commit();
        }catch(Exception e){
          em.getTransaction().rollback();
        }finally{
          em.close();
        } 
        
    }
    

    public List<Produto> listarProduto(){
        
        EntityManager em = entityManagerFactory.createEntityManager();
        try{
          TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
          query.setMaxResults(1000);
          return query.getResultList();  
        }
         finally{
          em.close();
        }
              
    }
    
    
    public void salvarProduto(Produto produto){
        
        EntityManager em = entityManagerFactory.createEntityManager();
        
        try{
          em.getTransaction().begin();
          em.persist(produto);
          em.getTransaction().commit();
        }catch(Exception e){
          em.getTransaction().rollback();
        }finally{
          em.close();
        }
              
    }
    
       
    
}
