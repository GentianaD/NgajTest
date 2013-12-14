package hig.herd.ngaj.test;

import hig.herd.ngaj.Results;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class ResultsTest extends ActivityInstrumentationTestCase2<Results> {

	public ResultsTest() {
		super("hig.herd.ngaj",Results.class);
		// TODO Auto-generated constructor stub
	}
	Activity objActivity;
	protected void setUp() throws Exception {
		super.setUp();
		objActivity = getActivity();
	}
	
	public void testLevelCalculation()
	{
		final int ExpectedResult=5;
		
		objActivity.runOnUiThread(new Runnable() 
        {          
                public void run() 
                {              
                	final int ActualResult=((Results)objActivity).calculateLevel(15000);  
                	assertEquals(ExpectedResult,ActualResult);    
                }      
        });
			
	}
	//have to check it again!!!
	public void testMedalCalculation()
	{
		
		objActivity.runOnUiThread(new Runnable(){
			public void run()
			{
				final int result=500;
				final TextView speed=(TextView)objActivity.findViewById(hig.herd.ngaj.R.id.rspeed3);
				final TextView distance=(TextView)objActivity.findViewById(hig.herd.ngaj.R.id.rdistance2);
				distance.setText(13);
				speed.setText(12);
				final int _Result=((Results)objActivity).calculateMedal();
				assertEquals(500,_Result);
				
			}
		});
		
		
	}
}
