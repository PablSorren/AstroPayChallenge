package com.dominio.astropay.services;

import com.dominio.astropay.domain.Comment;
import com.dominio.astropay.domain.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ApiService {

  @GET("/posts")
  public Call<List<Post>> getPostsBlog();

  @GET("/posts/{postId}/comments")
  public Call<List<Comment>> getPostComments(@Path("postId") Long postId);

}
