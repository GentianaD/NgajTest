package hig.herd.ngaj.test;

import hig.herd.ngaj.Results;
import android.app.Activity;
import android.test.SingleLaunchActivityTestCase;


public class ResultsTest extends SingleLaunchActivityTestCase <Results> {

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

}
