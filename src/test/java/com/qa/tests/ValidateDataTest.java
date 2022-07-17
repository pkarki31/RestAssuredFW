package com.qa.tests;

import com.qa.model.DataModel;
import com.qa.model.data;
import com.qa.util.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class ValidateDataTest extends  TestBase {

    private RequestSpecification httpRequest;

    private Response response;

    private data dataObj;

    private List<DataModel> dataModelObj = new ArrayList<DataModel>();

    @BeforeMethod
    public void setUp() {


        TestBase.init();

        //1. define the base url

        RestAssured.baseURI = prop.getProperty("serviceurl");

        //2. define the http request:
        httpRequest = given();

        //3. make a request/execute the request:
        response = httpRequest.request(Method.GET);
    }

    @Test
    public void validateAttributeType() {

        dataObj  = response.getBody().as(data.class);
        JsonPath jsonPathEvaluator = response.body().jsonPath();

        List<String> areaNameList = new ArrayList<String>();

        System.out.println(dataObj.getData().size());

        for (int i=1;i<=dataObj.getData().size();i++){

           // System.out.println("ji");

          //  areaNameList.set(i,jsonPathEvaluator.get("data.areaName").toString());

            System.out.println(i+"..."+jsonPathEvaluator.prettyPrint().equals(dataObj.getData()));

          //  System.out.println("areaName : "+areaNameList.get(i));

        }

    }

    @Test
    public void JSONSchemaValidation(){

        File schema = new File(prop.getProperty("path")+"testdata/ExpectedSchema.json");

        response.then().body(matchesJsonSchema(schema));

    }
}
