package hig.herd.ngaj.test;


import hig.herd.ngaj.Tracks;
import android.app.Activity;
import android.database.Cursor;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;

public class TracksTest extends ActivityInstrumentationTestCase2 <Tracks> {

	Activity objActivity;

	public TracksTest() {
		super("hig.herd.ngaj", Tracks.class);
		// TODO Auto-generated constructor stub

	}
	
	protected void setUp() throws Exception {
		super.setUp();
		objActivity = getActivity();
	}
	
	public void testcount()
	{
		ListView lv=(ListView)objActivity.findViewById(hig.herd.ngaj.R.id.listView1);
	     objActivity.runOnUiThread(new Runnable() 
         {          
                 public void run() 
                 {              
                         ((Tracks)objActivity).fileList();  
                         
                 }      
         });
	     String sql="Select count () as COUNT from tblTracks";
	     Cursor cr=((Tracks)objActivity).db.rawQuery(sql, null);
	     cr.moveToNext();
	     int countDB=cr.getInt(cr.getColumnIndex("COUNT"));
	     int countItems=lv.getCount();
	     assertEquals(countItems,countDB);
		
	}


}
