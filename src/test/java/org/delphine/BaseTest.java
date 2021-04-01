package org.delphine;

import io.restassured.RestAssured;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
  public static Validator validator;

  @BeforeAll
  void setUp() {
    RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  @AfterAll
  void tearDown() {
    RestAssured.reset();
  }
}
