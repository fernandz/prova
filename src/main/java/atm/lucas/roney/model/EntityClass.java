package atm.lucas.roney.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityClass{
	
	public EntityManager getEntityManager(){
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("minha-persistence-unit");
		return  emf.createEntityManager();
	}
}
