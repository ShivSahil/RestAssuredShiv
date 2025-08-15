package com.bookapi.testcases;

import org.testng.annotations.Test;

import com.bookapi.assertions.WrappedAssert;
import com.bookapi.logs.WrappedReportLogger;
import com.bookapi.pojo.response.GetHealth;
import com.bookapi.specBuilder.ApiClient;
import com.bookapi.specBuilder.RequestBuilder;
import com.bookapi.test.constants.EndPoints;

import io.restassured.response.Response;

public class HealthCheckTest {

	// converted this to before test
	
	@Test(priority=1, description = "PreRequiste- Validating if Server is up and running.")
	   public void validatingServiceHealth() {
		WrappedReportLogger.trace("PreRequiste- Validating if Server is up and Running...");
		
		Response response= ApiClient.get(RequestBuilder.defaultSpec(), EndPoints.HEALTH, 200,"GetHealth.json") 	;
		GetHealth getHealthResponse= response.as(GetHealth.class);
		WrappedAssert.assertEquals( getHealthResponse.getStatus(), "up", "Validating status value");
        
		WrappedAssert.assertEquals(response.getHeader("server"), "uvicorn", "Validating Server header");
	    WrappedAssert.assertEquals(response.getHeader("content-type"), "application/json", "Validating Content-Type header");

		
		WrappedReportLogger.trace("PreRequiste-  Validated Server is up and Running!!!");
 	    }
	

}
