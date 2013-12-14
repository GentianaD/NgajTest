package hig.herd.ngaj.test;

import hig.herd.ngaj.LevelUp;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.TextView;

public class LevelUpTest extends ActivityInstrumentationTestCase2<LevelUp> {

	public LevelUpTest() {
		super("hig.herd.ngaj",LevelUp.class);
		// TODO Auto-generated constructor stub
	}
	Activity objActivity;
	protected void setUp() throws Exception
	{
		super.setUp();
		objActivity=getActivity();
	}
	
	public void testCalculateText()
	{
				
		final TextView tv=(TextView)objActivity.findViewById(hig.herd.ngaj.R.id.txtLevelUp);
		objActivity.runOnUiThread(new Runnable()
				{
					public void run()
					{
						LevelUp.Level=5;
						((LevelUp)objActivity).calculateText();
						String text=(String) tv.getText();
						assertEquals("Well Done! \nYou have reached maximum level!\nYour current level is : 5 (Elite)",text);
					}
				});
		
	}
	
	public void testScreenshot()
	{
		objActivity.runOnUiThread(new Runnable()
		{
			public void run()
			{
				final View v=(View)objActivity.findViewById(hig.herd.ngaj.R.id.Layout3);
				Bitmap B=((LevelUp)objActivity).screenShot(v);
				String Filename=Environment.getExternalStorageDirectory()+ "/NgajLastScreenShot"+".png";
				Bitmap bm = BitmapFactory.decodeFile(Filename);
				assertEquals(B,bm);
			}
		});
	}

}
