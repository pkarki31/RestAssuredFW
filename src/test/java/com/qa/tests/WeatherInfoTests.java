package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.util.TestBase;
import com.qa.util.TestUtil;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;



public class WeatherInfoTests extends TestBase{


	@BeforeMethod
	public void setUp(){


		TestBase.init();
	}





	@Test
	public void getWeatherDetailsWithCorrectCityNameTest(){

		//1. define the base url

		RestAssured.baseURI = prop.getProperty("serviceurl");

		//2. define the http request:
		RequestSpecification httpRequest = given();

		//3. make a request/execute the request:
		Response response = httpRequest.request(Method.GET);

		//4. get the response body:
		String responseBody = response.getBody().asString();

		response.andReturn();
		int responseCode = response.getStatusCode();
		//System.out.println("Response Body is: "+ responseBody);

		System.out.println("Response Code is: "+ responseCode);
		//validate Response Code is 200
		Assert.assertEquals(responseCode==TestUtil.RESPONSE_CODE_200, true);


//		String value = response.path("totalRecords").toString();
//
//		System.out.println("totalRecords : "+value);
//
//		String datalatestBy = response.path("data.latestBy").toString();
//
//		System.out.println("datalatestBy : "+datalatestBy);


	}








}
