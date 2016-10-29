package atm.lucas.roney;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class RMIServer {
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		
		LocateRegistry.createRegistry(1099);
	    RMIImpl lr = new RMIImpl();
	    Naming.rebind("lr", lr);
	    System.err.println("Servidor RUNNING ");
	     
	}
}
