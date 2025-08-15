package com.bookapi.testcases;

import org.testng.annotations.Test;

import com.bookapi.logs.WrappedAssert;
import com.bookapi.logs.WrappedReportLogger;
import com.bookapi.pojo.response.GetHealth;
import com.bookapi.specBuilder.ApiClient;
import com.bookapi.specBuilder.RequestBuilder;
import com.bookapi.test.constants.EndPoints;

public class HealthCheckTest {

	// converted this to before test
	
	@Test(priority=1, description = "PreRequiste- Validating if Server is up and running.")
	   public void validatingServiceHealth() {
		WrappedReportLogger.trace("PreRequiste- Validating if Server is up and Running...");
		GetHealth getHealthResponse= ApiClient.get(RequestBuilder.defaultSpec(), EndPoints.HEALTH, 200,"GetHealth.json").as(GetHealth.class);
		WrappedAssert.assertEquals( getHealthResponse.getStatus(), "up", "Validating status value");
        WrappedReportLogger.trace("PreRequiste-  Validated Server is up and Running!!!");
 	   
		WrappedReportLogger.debug("Response:"+getHealthResponse);
        
          }
	

}
