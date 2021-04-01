package org.delphine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

class HelloWorldTest extends BaseTest {

  @Test
  void helloWorld() {
    Response response = RestAssured.get("/users");
    assertEquals(200, response.statusCode());
  }
}
