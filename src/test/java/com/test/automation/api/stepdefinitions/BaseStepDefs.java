package com.test.automation.api.stepdefinitions;

import com.google.gson.Gson;
import com.test.automation.api.response.Promotions;
import com.test.automation.api.response.ResponseContainer;
import org.junit.Assert;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.asserts.SoftAssert;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseStepDefs {

    public static HttpHeaders httpHeaders = new HttpHeaders();
    public ResponseEntity<String> response;
    public RestTemplate restTemplate;
    public ResponseContainer responseContainer;
    public Promotions promotions;
    Gson gson = new Gson();
    Map<String, String> keyVal;
    List<List<String>> listOfDt;
    SoftAssert softAssert = new SoftAssert();


    public void assertExpectedAndActualResponse(String fieldName, String expectedResponse, String actualResponse){
        softAssert.assertEquals(expectedResponse.equalsIgnoreCase(actualResponse), fieldName + " should be matched.");
    }
    public void assertExpectedAndActualResponse(String expectedResponse, String actualResponse){
        Assert.assertEquals(expectedResponse,actualResponse);
    }

    public void assertActualContainsExpectedValue(String expectedResponse, String actualResponse){
        Assert.assertTrue(actualResponse.contains(expectedResponse));

    }

    public List<String> getListOfString(String text){
        List<String> newListOfString = new ArrayList<>();

        for (String item: text.split(",")
        ){
            newListOfString.add(item.trim());
        }
        return newListOfString;
    }

}
