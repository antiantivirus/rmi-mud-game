
/*******************************************************************
 * cs3515.examples.rmishout.ShoutServerImpl                        *
 *******************************************************************/

package code;

import java.rmi.RemoteException;

/**
 * Playing that fun game called MUD.
 * @author John Murray Brown, University of Aberdeen
 * @version 999999.0
 */

class MudServerImp
    implements MudServerInterface
	
	
{
    public MUD w = new MUD("mymud.edg", "mymud.msg", "mymud.thg");


    public void MudSeverImp()
	throws RemoteException
    {
    }

    public String move(String loc, String dir, String thing) {
		
		return w.moveThing(loc,dir,thing);

	}

    public String create_user( String loc, String thing ) {
    
		return w.createThing(loc,thing);

	}

    public String location(String loc) {
		
		return w.locationInfo(loc);

	}
}