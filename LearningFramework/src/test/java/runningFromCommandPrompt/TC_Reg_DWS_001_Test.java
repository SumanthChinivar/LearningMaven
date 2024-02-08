package runningFromCommandPrompt;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseClass.BaseClass;

	public class TC_Reg_DWS_001_Test extends BaseClass{
		@Test
		public void demo() {
			Reporter.log("Hello",true);
			test.log(Status.INFO,"Demo from TC_Reg_DWS_001");
		}
}
