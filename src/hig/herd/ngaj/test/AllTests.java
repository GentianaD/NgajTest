package hig.herd.ngaj.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		
		suite.addTestSuite(LevelUpTest.class);
		suite.addTestSuite(ResultsTest.class);
		//suite.addTestSuite(StatsTest.class);
		suite.addTestSuite(TracksTest.class);
		//suite.addTestSuite(GPSserviceTest.class);
		suite.addTestSuite(MainActivityTest.class);
		//$JUnit-END$
		return suite;
	}

}
