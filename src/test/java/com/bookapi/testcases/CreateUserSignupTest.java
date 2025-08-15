package com.bookapi.testcases;

import org.testng.annotations.Test;

import com.bookapi.logs.WrappedAssert;
import com.bookapi.logs.WrappedReportLogger;
import com.bookapi.pojo.request.CreateUserSignup;
import com.bookapi.pojo.response.Detail;
import com.bookapi.pojo.response.Message;
import com.bookapi.specBuilder.ApiClient;
import com.bookapi.specBuilder.RequestBuilder;
import com.bookapi.test.constants.EndPoints;
import com.bookapi.test.utils.DataGenerator;

public class CreateUserSignupTest {
	public static String newEmail;
	public static int newId;
	public static String newPwd;
	
	
	@Test(priority=2, description = "Validating creation of new user", groups = "userCreation")
	 public void createNewUser() {
		WrappedReportLogger.trace("Creating Sign Up Request with Random Email ID and Random ID....");
		newEmail= DataGenerator.randomEmail();
		newId= DataGenerator.randomID();
		newPwd= DataGenerator.randomPwd();
		
		CreateUserSignup createUserSignupRequest = new CreateUserSignup();
		createUserSignupRequest.setId(newId);
		createUserSignupRequest.setEmail(newEmail);
		createUserSignupRequest.setPassword(newPwd);
		WrappedReportLogger.trace("Created Sign Up Request with random email as "+newEmail+" and random ID as "+newId+"!!!!");
		
		WrappedReportLogger.trace("Creating a new user....");
		Message messageResponse=ApiClient.post(RequestBuilder.withBodyAndNoAuthToken(createUserSignupRequest,null, null), EndPoints.SIGNUP, 200, "Message.json").as(Message.class);
		WrappedAssert.assertEquals( messageResponse.getMessage(), "User created successfully", "Validating message value");
		WrappedReportLogger.trace("Created a new user!!!!");
		
		
		WrappedReportLogger.debug("Request:"+createUserSignupRequest);
		WrappedReportLogger.debug("Response:"+messageResponse);
		
		}
	
	
	@Test(priority=3, description = "NEGATIVE: Validating creation of new user with existing email and id", dependsOnMethods = "createNewUser")
	 public void createExistingUser() {
		
		CreateUserSignup createUserSignupRequest = new CreateUserSignup();
		createUserSignupRequest.setId(newId);
		createUserSignupRequest.setEmail(newEmail);
		createUserSignupRequest.setPassword(newPwd);
		
		WrappedReportLogger.trace("Adding an exsting user....");
		Detail detailResponse=ApiClient.post(RequestBuilder.withBodyAndNoAuthToken(createUserSignupRequest,null, null), EndPoints.SIGNUP, 400, "Detail.json").as(Detail.class);
		WrappedAssert.assertEquals( detailResponse.getDetail(), "Email already registered", "Validating detail value");
		WrappedReportLogger.trace("Unable to add an existing user!!!!");
		
		WrappedReportLogger.debug("Request:"+createUserSignupRequest);
		WrappedReportLogger.debug("Response:"+detailResponse);
		
		
	}
	
	
	
	
	
	

}
