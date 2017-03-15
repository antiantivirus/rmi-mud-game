package code;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;


/**

Server Interface for MUD game.

*/

public interface MudServerInterface extends Remote
{

	public String location( String s) throws RemoteException;
}