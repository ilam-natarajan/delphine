package org.delphine.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
  int userId;
  int id;
  String title;
  String body;
}
