package hig.herd.ngaj.test;

import java.util.Calendar;

import hig.herd.ngaj.Stats;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.LinearLayout;

public class StatsTest extends ActivityInstrumentationTestCase2<Stats> {

	public StatsTest() {
		super("hig.herd.ngaj",Stats.class);
		// TODO Auto-generated constructor stub
	}
	Activity objActivity;
	
    protected void setUp() throws Exception {
            super.setUp();
            objActivity=getActivity();
    }
    
    public void testDate()
    {
    	objActivity.runOnUiThread(new Runnable()
    	{
    		public void run()
    		{
    			((Stats)objActivity).decreaseDate();
    		}
    		
    	});
    	Calendar calendar=Calendar.getInstance();
    	String Month=Integer.toString(calendar.get(Calendar.MONTH)+1);
    	if(Integer.parseInt(Month)<=9)
    		Month="0"+Month;
    	if(Integer.parseInt(Month)<0)
    		Month="12";
    	String _Month=((Stats)objActivity).month;
    	assertEquals(Month,_Month);
    	
    	
    	
    }
    
    public void testAddingGraphs()
    {
    	
      	LinearLayout l1=(LinearLayout)objActivity.findViewById(hig.herd.ngaj.R.id.graph1);
      	LinearLayout l2=(LinearLayout)objActivity.findViewById(hig.herd.ngaj.R.id.graph2);
      	assertNotNull(l1);
    	assertNotNull(l2);
      	
    	
    }

}
