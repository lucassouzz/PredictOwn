package packageMain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;


public class Controller {
	
	EntityManagerFactory emf;
	
	
	EntityManager em;
	
	
	public Controller () {
		
		emf = Persistence.createEntityManagerFactory("machine");
		
		em = emf.createEntityManager();
	}
	
	public void salvar (User ty) {
		
		em.getTransaction().begin();
		
		em.merge(ty);
		
		em.getTransaction().commit();
		
		emf.close();
	}
	
	public void remover (User _user) {
		
		em.getTransaction().begin();
		
		Query q = em.createNamedQuery("delete user from user where id = " + _user.getId());
		
		q.executeUpdate();
		
		em.getTransaction().commit();
		
		emf.close();
		
	}

}
