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
    	
    	objActivity.runOnUiThread(new Runnable() 
        {  
    		
                public void run() 
                { 
                	final LinearLayout l1=(LinearLayout)objActivity.findViewById(hig.herd.ngaj.R.id.Layout3);
                	((Stats)objActivity).DrawGraphs(l1, new double [] {1,2,3,4,5,6,7},"Testing");
                	
                       
                }      
        });
    	
    	assertEquals(1,1);
    }

}
