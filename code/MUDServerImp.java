
/*******************************************************************
 * cs3515.examples.rmishout.ShoutServerImpl                        *
 *******************************************************************/

package code;

import java.rmi.RemoteException;

/**
 * Playing that fun game called MUD.
 * @author John Murray Brown, University of Aberdeen
 */

class MudServerImp
    implements MudServerInterface
	
	
{
    MUD w = new MUD("mymud.edg", "mymud.msg", "mymud.thg");


    public void MudSeverImp()
	throws RemoteException
    {
    }

    //Method for getting current location
    public String location( String loc ) {
		
		return w.locationInfo( loc );

	}

    //Method for creating user
    public String create_user( String loc, String thing ) {
    
		w.addThing( loc, thing );
		return w.locationInfo( loc );
	}

    //Method for moving through the mud
    public String move( String loc, String dir, String thing ) {
		
		loc = w.moveThing( loc, dir, thing );
                return w.locationInfo( loc );

	}

    //Method for adding object to the mud
    public String add( String obloc, String object ) {
		w.createThing ( obloc, object );
		return object;
	}

    //Method for picking up objects at your current location
    public String pick( String loc, String thing ) {
		w.delThing ( loc, thing );
		return thing;
	}
}