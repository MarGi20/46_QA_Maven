package demoqa.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 2;

    @Override
      public boolean retry(ITestResult result) {
    //        retryCount++;
    //       System.out.println("Retrying test [+result.getName() + "] within ["+ retryCount"]);
    //      return true;
    //  }
      return false;
     }
}
