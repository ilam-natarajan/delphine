package org.delphine.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {
  int postId;
  int id;
  @Email String email;
}
