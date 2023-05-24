import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import commonMethodPackage.Utility_Common_Functions;

public class DriverClass {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//POST_TC_1.execute();
		
		ArrayList<String> testCaseRun = Utility_Common_Functions.readDataExcel("PostRunner", "TCExecute");
		
		int count = testCaseRun.size();
		System.out.println(count);
		
		for(int i=1; i<count; i++) {
			
			String testcasename=testCaseRun.get(i);
			System.out.println(testcasename);
			
			// call the testcaseclass on runtime by using java.lang.reflect package
			Class<?> testClassName=Class.forName("testClassPackage."+testcasename);
			
			// call the execute method belonging to test class captured in variable testclassname by using java.lang.reflect.method class
			Method executemethod=testClassName.getDeclaredMethod("execute");
			
			// set the accessibility of method true 
			executemethod.setAccessible(true);
			
			// create the instance of testclass captured in variable name testclassname
			Object instanceoftestclass=testClassName.getDeclaredConstructor().newInstance();
			
			// execute the testclass captured in variable name testclass name
			executemethod.invoke(instanceoftestclass);
		}
	}
}



