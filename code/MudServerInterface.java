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
	public String create_user( String loc, String thing ) throws RemoteException; 
	public String move( String loc, String dir, String thing ) throws RemoteException;
	public String location( String s) throws RemoteException;


}