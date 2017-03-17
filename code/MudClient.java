package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

/**
 * Playing that fun game called MUD.
 * @author John Murray Brown, University of Aberdeen
 * Client File. All output and input from client side here. 
 * Calling methods that are implemented in MudServer.
 */

class MudClient
{
    public static void main(String args[])
	throws RemoteException
    {
	if (args.length < 2) {
	    System.err.println( "Usage:\njava MudClient <host> <port>" ) ;
	    return;
	}
	String hostname = args[0];
	int port = Integer.parseInt( args[1] );

	// Specify the security policy and set the security manager.
	System.setProperty( "java.security.policy", "rmimud.policy" ) ;
	System.setSecurityManager( new SecurityManager() ) ;

        try {
	    // Obtain the server handle from the RMI registry
	    // listening at hostname:port.
	    String regURL = "rmi://" + hostname + ":" + port + "/MudServer";
	    System.out.println( "Looking up " + regURL );
            MudServerInterface serv = (MudServerInterface)Naming.lookup( regURL );

	    //declaring input variable
            String thing = "";
	    String loc = "";
	    String dir = "";
            

            BufferedReader in = new BufferedReader(
                new InputStreamReader( System.in ));
            System.out.println( "Welcome to MUD Game" );
	    System.out.println( "All the fun is about to happen" );
            System.out.println( "Creating the world...." );
            thing = System.console().readLine("What is your name: ");
	    System.out.println( "Welcome " + thing );
            loc = System.console().readLine("Where would you like to start in the world? A, B, C or D: ");
            System.out.println( "Adding you to the world...." );
	    System.out.println(serv.create_user( loc, thing));
	    System.out.println( "If you want to leave the game at any time, just type leave" );
            while(!dir.equals("leave")) {
		    System.out.println( "You can now move about the world in 4 directions" );
		    System.out.println( "North, East, South, West" );
		    dir = System.console().readLine("In which direction would you like to move?: ");
		    System.out.println(serv.move( loc, dir, thing));
                    System.out.println( "Location: " + loc );
	    }
            
        }
	catch (java.io.IOException e) {
            System.err.println( "I/O error." );
	    System.err.println( e.getMessage() );
        }
	catch (java.rmi.NotBoundException e) {
            System.err.println( "Server not bound." );
	    System.err.println( e.getMessage() );
        }
    }
}