package com.dominio.astropay.domain;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_post")
  private Long id;

  private Long userId;

  private String title;

  @Column(name="body", length = 1000)
  private String body;


  public Post() {
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  @Override
  public String toString() {
    return String.format(
        "\n\n" +
        "USERID : %d \n"+
        "id : %d \n"+
        "title : %s \n"+
        "body : %s \n"+
        "\n\n", this.getUserId(), this.getId(), this.getTitle(), this.getBody());
  }
}
