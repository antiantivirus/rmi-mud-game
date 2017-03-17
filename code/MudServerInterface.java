package code;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Playing that fun game called MUD.
 * @author John Murray Brown, University of Aberdeen
 */

/**

Server Interface for MUD game.

*/

public interface MudServerInterface extends Remote
{
	public String create_user( String loc, String thing ) throws RemoteException; 
	public String move( String loc, String dir, String thing ) throws RemoteException;
	public String location( String loc ) throws RemoteException;


}