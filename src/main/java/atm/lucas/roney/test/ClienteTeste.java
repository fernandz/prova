package atm.lucas.roney.test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import atm.lucas.roney.IRMII;
import atm.lucas.roney.model.MyFirstClass;


public class ClienteTeste {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		IRMII testejpa = (IRMII)Naming.lookup("rmi://127.1.1.1/lr");
		
		MyFirstClass obj = new MyFirstClass();
		obj.setNumero(123);
		obj.setTexto("Teste");
		
		testejpa.salvar(obj);
		
	}
}
