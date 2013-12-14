package hig.herd.ngaj.test;

import hig.herd.ngaj.MainActivity;
import hig.herd.ngaj.Results;
import hig.herd.ngaj.Stats;
import hig.herd.ngaj.Tracks;
import android.R.bool;
import android.app.Activity;
import android.app.Instrumentation.ActivityMonitor;
import android.hardware.Camera;
import android.provider.MediaStore;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;

public class MainActivityTest extends
		ActivityInstrumentationTestCase2<MainActivity> {
	Activity objActivity;

	public MainActivityTest() {
		super("hig.herd.ngaj", MainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		objActivity = getActivity();

	}

	public void teststartResults() {
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(
				Stats.class.getName(), null, false);
		final Button button = (Button) objActivity
				.findViewById(hig.herd.ngaj.R.id.btnStats);
		objActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.
				button.performClick();
			}
		});

		Activity stats = getInstrumentation().waitForMonitorWithTimeout(
				activityMonitor, 500);
		// next activity is opened and captured.
		assertNotNull(stats);
		stats.finish();
	}

	public void testshowtracks() {
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(
				Tracks.class.getName(), null, false);
		final Button button = (Button) objActivity
				.findViewById(hig.herd.ngaj.R.id.btnTracks);
		objActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.
				button.performClick();
			}
		});

		Activity tracks = getInstrumentation().waitForMonitorWithTimeout(
				activityMonitor, 500);
		// next activity is opened and captured.
		assertNotNull(tracks);
		tracks.finish();
	}

	public void testzcamera() {
		final Button button = (Button) objActivity
				.findViewById(hig.herd.ngaj.R.id.btnCamera);

		objActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.
				button.performClick();

			}
		});

		boolean test = false;

		if (Camera.open() == null)
			test = true;
		else
			test = false;

		assertEquals(true, test);
	}

}
