import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
/**********************************************************************************************
HelLo, I'm Ahmed Sayed Mohamed

 All Data Performed on a Mock API Which is Created by me to explain The Rest Assured Test

 https://663fd790e3a7c3218a4e1c34.mockapi.io/Students

 This Mock API LINK ^^

******************************************************************************************* */
public class RESTAssuredTest {
    @Test(priority = 0)
    /*Smoke Test To Validate Response Code */
    public void ValidateResponse2()
    {
        Response Resp = RestAssured.get("https://663fd790e3a7c3218a4e1c34.mockapi.io/Students");
        Assert.assertEquals(Resp.statusCode(),200);
    }
    // Validating Positive Scenarios by Validating Response Data
    @Test (priority = 1)
    public void ValidDateResponse_Name()
    {
        given().get("https://663fd790e3a7c3218a4e1c34.mockapi.io/Students/14").then().assertThat().body("id",equalTo("14"))
                .and().body("FirstName",equalTo("Mahmoud")).and().body("Title",equalTo("Site Engineer"));
    }
    //Validating Negative Scenarios By Get a Response while validating data
    @Test (priority = 2)
    public void Valid_Return_Data()
    {
        String Returned_Data = RestAssured.get("https://663fd790e3a7c3218a4e1c34.mockapi.io/Students/77").asString();
        Assert.assertEquals(Returned_Data,"\"Not found\"");
    }

}
