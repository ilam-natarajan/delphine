package org.delphine;

import static io.restassured.RestAssured.given;
import static org.delphine.Resources.COMMENTS;
import static org.delphine.Resources.POSTS;
import static org.delphine.Resources.QueryParams.POST_ID;
import static org.delphine.Resources.QueryParams.USER_ID;
import static org.delphine.Resources.QueryParams.USER_NAME;
import static org.delphine.Resources.USERS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import jakarta.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import org.delphine.domain.Comment;
import org.delphine.domain.Post;
import org.delphine.domain.User;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CommentsTest extends BaseTest {
  Set<ConstraintViolation<Comment>> constraintViolations;

  @ParameterizedTest
  @CsvSource({"Delphine", "Antonette"})
  void testEmailFormatInComments(String username) {

    List<Post> posts = getPostsOfAUser(username);

    posts.forEach(
        p -> {
          List<Comment> comments =
              given()
                  .queryParam(POST_ID, p.getId())
                  .accept(ContentType.JSON)
                  .when()
                  .get(COMMENTS)
                  .as(new TypeRef<>() {});
          assertFalse(comments.isEmpty());
          comments.forEach(
              c -> {
                constraintViolations = validator.validate(c);
                assertTrue(constraintViolations.isEmpty());
              });
        });
  }

  private List<Post> getPostsOfAUser(String username) {
    List<User> users =
        given()
            .queryParam(USER_NAME, username)
            .accept(ContentType.JSON)
            .when()
            .get(USERS)
            .as(new TypeRef<>() {});
    assertEquals(1, users.size());

    int userId = users.get(0).getId();
    List<Post> posts =
        given()
            .queryParam(USER_ID, userId)
            .accept(ContentType.JSON)
            .when()
            .get(POSTS)
            .as(new TypeRef<>() {});
    assertFalse(posts.isEmpty());
    return posts;
  }
}
