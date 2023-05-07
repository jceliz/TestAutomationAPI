package com.test.automation.api.stepdefinitions;

import com.test.automation.api.response.Promotions;
import com.test.automation.api.response.ResponseContainer;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ApiSteps extends BaseStepDefs {


    @When("API Call has been made {string}")
    public void apiCallHasBeenMade(String url) {
        httpHeaders.set("Accept", "*/*");
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        restTemplate = new RestTemplate();
        response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

    @Then("Verify Response")
    public void verifyResponse(DataTable dataTable) throws Exception {
        responseContainer = gson.fromJson(response.getBody(), ResponseContainer.class);
        promotions = gson.fromJson(response.getBody(), Promotions.class);
        keyVal = dataTable.asMap(String.class, String.class);
        listOfDt = dataTable.asLists(String.class);


        for (List<String> item : listOfDt) {
            List<String> list = getListOfString(item.toString().replace("[", ""));
            switch (list.get(0)) {
                case "Name":
                    assertExpectedAndActualResponse(responseContainer.getName(), (keyVal.get(list.get(0))));
                    break;
                case "CanRelist":
                    assertExpectedAndActualResponse(responseContainer.getCanRelist(), (keyVal.get(list.get(0))));
                    break;
                default:
                    throw new Exception("Unable to find response: " + list.get(0));
            }
        }

    }

    @And("Name {string} has description {string}")
    public void nameHasDescription(String name, String value) throws Exception {
//        promotions = gson.fromJson(response.getBody(), Promotions.class);
//        assertExpectedAndActualResponse(arg1,promotions.getDescription());

        boolean found = false;
        for (Promotions prom : responseContainer.getPromotions()) {
            if (prom.getName().equalsIgnoreCase(name)) {
                assertExpectedAndActualResponse(value, prom.getDescription());
                found = true;
            }
        }
        if (!found){
            throw new Exception("Unable to find response: " + name);
        }
    }
}