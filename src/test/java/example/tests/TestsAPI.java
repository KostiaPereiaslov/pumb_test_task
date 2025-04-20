package example.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.json.JSONObject;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.*;

public class TestsAPI {

    @Test
    public void testGet() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response response =
                given()
                        .when()
                        .get("/posts/1")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        String body = response.getBody().asString();
        int userId = response.jsonPath().getInt("userId");

        System.out.println("Response code: " + response.statusCode());
        System.out.println("📦 Response body: " + body);
        System.out.println("👤 userId: " + userId);

        assertNotNull(body, "Response body should not be null");
        assertFalse(body.isEmpty(), "Response body should not be empty");
        assertEquals(1, userId, "userId should be 1");

        System.out.println("🟢 Test passed.");
    }

    @Test
    public void testPost() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Create body
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "qa task");
        requestBody.put("body", "this is a test post");
        requestBody.put("userId", 99);

        System.out.println("POST + Body: " + requestBody);

        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(requestBody.toString())
                        .when()
                        .post("/posts")
                        .then()
                        .statusCode(201)
                        .extract()
                        .response();

        System.out.println("ResponseCode: " + response.statusCode());
        System.out.println("Response: " + response.getBody().asString());

        String title = response.jsonPath().getString("title");
        String body = response.jsonPath().getString("body");
        int userId = response.jsonPath().getInt("userId");

        System.out.println("Check values:");
        System.out.println("title = " + title);
        System.out.println("body = " + body);
        System.out.println("userId = " + userId);

        // Checks
        assertEquals("qa task", title, "Title does not mach");
        assertEquals("this is a test post", body, "Body does not mach");
        assertEquals(99, userId, "userId does not mach");

        System.out.println("🟢 POST-test passed.");

    }

    @Test
    public void testGetNonExistentPost() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        System.out.println("Send unexpected request");

        Response response =
                given()
                        .when()
                        .get("/posts/9999")  // пост с ID 9999 отсутствует
                        .then()
                        .extract()
                        .response();

        int statusCode = response.statusCode();
        String responseBody = response.getBody().asString();

        System.out.println("Response code: " + statusCode);
        System.out.println("Response: " + responseBody);

        // Проверка: статус должен быть 404
        assertEquals(404, statusCode, "Expected 404 but got " + statusCode);

        // Проверка: тело может быть пустым или содержать '{}'
        assertTrue(responseBody.isEmpty() || responseBody.equals("{}"), "Empty response body");

        System.out.println("Negative test passed.");
    }
}
