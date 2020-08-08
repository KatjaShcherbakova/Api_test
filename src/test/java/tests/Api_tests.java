package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.AttachmentsHelper;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Epic("QA.GURU QA automation course")
@Feature("REST API")
@Story("Testing Rest API")
@Tag("api")
public class Api_tests {
    private String baseUrl = "https://reqres.in";


//    @Before
//    public void initSelenideListener() {
//        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true));
//    }

    @Test
    @DisplayName("Get server response")
    void getUsersList () {
        step ("get list of users", () -> {
            RestAssured.baseURI = baseUrl;
            String listUsers = given()
                    .when()
                    .get("/api/users?page=2")
                    .asString();
            AttachmentsHelper.attachAsText("List of Users", listUsers);
            System.out.println(listUsers);

        });
    }



}
