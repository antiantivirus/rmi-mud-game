
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


    public String location( String loc ) {
		
		return w.locationInfo( loc );

	}
    public String create_user( String loc, String thing ) {
    
		w.addThing( loc, thing );
		return w.locationInfo( loc );
	}

    public String move( String loc, String dir, String thing ) {
		
		loc = w.moveThing( loc, dir, thing );
                return w.locationInfo( loc );

	}

}