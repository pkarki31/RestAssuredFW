package com.qa.tests;

import com.qa.model.DataModel;
import com.qa.model.data;
import com.qa.util.ReadDataFromExcel;
import com.qa.util.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.*;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class ValidateDataTest extends  TestBase {

    private RequestSpecification httpRequest;

    private Response response;

    private data dataObj;

    private List<DataModel> dataModelObj = new ArrayList<DataModel>();

    private String AreadName = null;

    private String LatestByFromAPI;

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

        for (int i=0;i<dataObj.getData().size();i++){

            dataModelObj.add(dataObj.getData().get(i));

            AreadName = dataModelObj.get(i).getAreaName();

            if(!AreadName.equals(prop.getProperty("areaName"))){

                Assert.assertEquals(AreadName,prop.getProperty("areaName"));
                break;
            }

        }

        assert  true;
    }

    @Test
    public void JSONSchemaValidation(){

        File schema = new File(prop.getProperty("path")+"testdata/ExpectedSchema.json");

        response.then().body(matchesJsonSchema(schema));

    }

    @Test
    public void validateCoronaCaseForGivenDate(){

        ReadDataFromExcel dataFromExcel = new ReadDataFromExcel();

        String checkCoronaCaseforDate = "2022-05-19";

        String latestByFromExcel = dataFromExcel.getDailyCoronaUpdateByDate(checkCoronaCaseforDate);

        System.out.println("latestByFromExcel : "+latestByFromExcel);

        dataObj  = response.getBody().as(data.class);

        Map<String,String> dataModelObjMap = new HashMap();

        for (int i=0;i<dataObj.getData().size();i++){

            dataModelObj.add(dataObj.getData().get(i));

            dataModelObjMap.put(dataModelObj.get(i).getDate(),dataModelObj.get(i).getLatestBy());



        }

        LatestByFromAPI = dataModelObjMap.get(checkCoronaCaseforDate);

        System.out.println("LatestByFromAPI : "+LatestByFromAPI);

        Assert.assertEquals(LatestByFromAPI,latestByFromExcel);


    }
}
