package org.delphine;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

  @BeforeAll
  void setUp() {
    RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
  }

  @AfterAll
  void tearDown() {
    RestAssured.reset();
  }
}
