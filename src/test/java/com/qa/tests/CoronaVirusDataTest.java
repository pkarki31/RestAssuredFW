package com.qa.tests;

import com.google.gson.Gson;
import com.qa.model.DataModel;
import com.qa.model.data;
import com.qa.util.TestBase;
import com.qa.util.TestUtil;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CoronaVirusDataTest extends TestBase {



    private RequestSpecification httpRequest;

    private Response response;

    private data  dataObj;

    private  List<DataModel> dataModelObj=new ArrayList<DataModel>();

    @BeforeMethod
    public void setUp(){


        TestBase.init();

        //1. define the base url

        RestAssured.baseURI = prop.getProperty("serviceurl");

        //2. define the http request:
        httpRequest = given();

        //3. make a request/execute the request:
        response = httpRequest.request(Method.GET);
    }


    @Test
    public void validateStatusCodeTest(){



        //4. get the response code:
        int responseCode = response.getStatusCode();
        //System.out.println("Response Body is: "+ responseBody);

        System.out.println("Response Code is: "+ responseCode);
        //validate Response Code is 200
        Assert.assertEquals(responseCode== TestUtil.RESPONSE_CODE_200, true);


    }

    @Test(dependsOnMethods = "validateStatusCodeTest")
    public void dayWiseDataCoronaVirus(){

        int  totalRecords = response.path("totalRecords");

        System.out.println("totalRecords : "+totalRecords);

        dataObj  = response.getBody().as(data.class);

        for (int i=0;i<dataObj.getData().size();i++){


            dataModelObj.add(dataObj.getData().get(i));

            System.out.println(" Date : "+dataModelObj.get(i).getDate()+" , Total Cases as of Today : "+dataModelObj.get(i).getLatestBy());


        }








    }




}
