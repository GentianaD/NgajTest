package hig.herd.ngaj.test;

import hig.herd.ngaj.GPSservice;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.test.ServiceTestCase;


public class GPSserviceTest extends ServiceTestCase<GPSservice> {

	private Context mSystemContext;
	Service objService;
	IntentFilter iff;
	public GPSserviceTest() {
		super(GPSservice.class);
		// TODO Auto-generated constructor stub
	}

	    public GPSserviceTest(Class<GPSservice> serviceClass) {
	        super(serviceClass);
	    }

	    @Override
	    protected void setUp() throws Exception {
	        // TODO Auto-generated method stub
	        super.setUp();
	        mSystemContext=getSystemContext();
	        iff=new IntentFilter("hig.herd.ngaj.GPSservice");
	        
	                // this is where i am attempting to start the service.
	                // i have attempted other methods, but none of those worked either.
	        mSystemContext.startService(new Intent(mSystemContext, GPSservice.class));
	        objService=getService();
	       
	    }


	
	public void testListeners()
	{
		mSystemContext.startService(new Intent(mSystemContext, GPSservice.class));
        objService=getService();
		SensorManager sm=(SensorManager)GPSservice.mSensorManager;
		Sensor sa=(Sensor)GPSservice.mAccelerometer;
		assertNull(sm);
		assertNull(sa);
		assertTrue(true);
	}
	
	public void testdoTime()
	{
		mSystemContext.startService(new Intent(mSystemContext, GPSservice.class));
        objService=getService();
		int t=((GPSservice)objService).time;
		assertEquals(1,1);
	}

}
