package atm.lucas.roney;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;

import atm.lucas.roney.model.EntityClass;
import atm.lucas.roney.model.MyFirstClass;

public class RMIImpl implements IRMII {

	public RMIImpl() throws RemoteException {
		UnicastRemoteObject.exportObject(this,1099);
	}   
	public void remover(MyFirstClass obj) throws RemoteException {
		EntityManager em = new EntityClass().getEntityManager();

		em.getTransaction().begin();
		em.remove(obj.getId());
		em.getTransaction().commit();

		em.close();
	}

	public void salvar(MyFirstClass obj) throws RemoteException {
		EntityManager em = new EntityClass().getEntityManager();

		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();

		em.close();
	}

	public void atualizar(MyFirstClass obj) throws RemoteException {
		EntityManager em = new EntityClass().getEntityManager();

		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();

		em.close();
	}

	public MyFirstClass consultar(String texto) throws RemoteException {
		EntityManager em = new EntityClass().getEntityManager();
		List<MyFirstClass> lista = em.createQuery("FROM EntityClass", MyFirstClass.class).getResultList();

		for (MyFirstClass selected : lista) {
			if (selected.getWhatEver().equals(texto))
				return selected;
		}
		return null;
	}

}
