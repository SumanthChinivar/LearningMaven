package learningMavenWithDependency;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseClass.BaseClass;

public class TestCaseWithDependency extends BaseClass{
	@Test
	public void demo()
	{
		Reporter.log("Maven With dependency",true);
		test.log(Status.INFO,"Demo from testcase with dependency");
	}
}
