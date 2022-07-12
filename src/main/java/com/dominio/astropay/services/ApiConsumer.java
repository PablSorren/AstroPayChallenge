package com.dominio.astropay.services;

import com.dominio.astropay.domain.Comment;
import com.dominio.astropay.exception.ErrorAlConsumirLaApiException;
import com.dominio.astropay.domain.Post;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ApiConsumer {

  private String urlApi = "https://jsonplaceholder.typicode.com";
  private ApiService apiService;

  public ApiConsumer() {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(urlApi)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    this.apiService = retrofit.create(ApiService.class);
  }

  public List<Post> getBlogPosts(){
    Call<List<Post>> request = apiService.getPostsBlog();
    return getResponse(request).body();
  }

  public List<Comment> getBlogComments(){
    return this.getBlogPosts()
               .stream()
               .map(Post::getId)
               .map(this::getPostComments)
               .flatMap(Collection::stream)
               .collect(Collectors.toList());
  }

  public List<Comment> getPostComments(Long postId){
    Call<List<Comment>> request = apiService.getPostComments(postId);
    return getResponse(request).body();
  }

  private static <R> Response<R> getResponse(Call<R> request) {
    Response<R> response = null;
    try {
      response = request.execute();
    } catch (Exception e) {
      throw new ErrorAlConsumirLaApiException(e.getMessage(),response.code());
    }
    if(response.isSuccessful() && response != null) {
      return response;
    } else {
      throw new ErrorAlConsumirLaApiException(response.message(), response.code());
    }
  }

}
