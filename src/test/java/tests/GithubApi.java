package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


@Epic("QA.GURU Automation course")
@Feature("Work with REST API ")
@Story("Testing Github API")
@Tag("Github")
@Tag("api")
public class GithubApi {
   private static String token = "7b8ce7432ac45fb485ea6df3d91a17c8ca5160dc";
   private static String baseUrl = "https://api.github.com";
   private static String usernameGithub = "KatjaTest";
   private static String passwordGithub = "qwertyqaz1!";

   @DisplayName("Authorization on Githab by REST API using Username&Password")
   @Test
   void authGithubByUsernamePassword () {
      given().
              auth().basic(usernameGithub, passwordGithub).
              when().
              baseUri(baseUrl).
              get("/user").
              then().
              statusCode(401);
   }


   @DisplayName("Authorization on Githab by REST API using token")
   @Test
   void authGithubByToken () {
      String response =
        given().
              auth().oauth2(token).
              when().
              baseUri(baseUrl).
              get("/user").
              asString();

      System.out.println(response);
   }

   @DisplayName("Print response by authorization using token")
   @Test
   void responseByAuthGithubByToken() {
      String response =
        given().
                auth().oauth2(token).
                when().
                baseUri(baseUrl).
                get("/user").
                asString();

      System.out.println(response);
   }
}

