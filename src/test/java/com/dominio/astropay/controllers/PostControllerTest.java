package com.dominio.astropay.controllers;

import com.dominio.astropay.domain.Post;
import com.dominio.astropay.exception.NoSeEncontroElPostException;
import com.dominio.astropay.services.PostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import java.util.Arrays;
import java.util.List;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
public class PostControllerTest {

  @Mock
  private PostService mockPostService;

  @InjectMocks
  private PostController mockPostController;

  private final Long POST_ID = 50L;
  private final Long USER_ID = 120L;
  private final String POST_TITLE = "Testing a post";
  private final String POST_BODY = "Testing body of the post, suppose it's in latin";

  @Test
  public void getPostByIdTest_OK() {
    //arrange
    when(mockPostService.getPostById(POST_ID)).thenReturn(this.createSimplePost());

    //act
    Post postRecieved = mockPostController.getPostById(POST_ID);

    //assert
    Assertions.assertEquals(USER_ID, postRecieved.getUserId());
  }

  @Test
  public void getPostByIdTest_ERROR() {
    when(mockPostService.getPostById(anyLong())).thenThrow(NoSeEncontroElPostException.class);

  Assertions.assertThrows(NoSeEncontroElPostException.class,
    () -> {
      mockPostController.getPostById(-1L);
    }
    );
  }

  @Test
  public void getPostWithWordInTitleTest_OK() {
    List<Post> postList = this.createSimplePostsList();
    when(mockPostService.getPostsWithWordInTitle(anyString())).thenReturn(postList);

    List<Post> postsFound = mockPostController.getPostsWithWordInTitle(anyString());

    Assertions.assertTrue(!postsFound.isEmpty());
    Assertions.assertEquals(postsFound, postList);
  }

  @Test
  public void getPostWithWordInTitleTest_Empty(){
    when(mockPostService.getPostsWithWordInTitle("omnis dolorem tempora et accusantium")).thenReturn(createSimplePostsList());

    List<Post> postsFound = mockPostController.getPostsWithWordInTitle("QUE SE YO NO SE LATIN");

    Assertions.assertTrue(postsFound.isEmpty());
  }

  @Test
  public void getPaginatedPostWithWordInTitle_OK() {
    List<Post> postList = this.createSimplePostsList();
    when(mockPostService.getPaginatedPosts(anyInt(), anyInt())).thenReturn(postList);

    List<Post> postsFound = mockPostController.getPaginatedPosts(anyInt(), anyInt());

    Assertions.assertTrue(!postsFound.isEmpty());
    Assertions.assertEquals(postsFound, postList);
  }

  @Test
  public void getAllPostsTest_OK(){
    List<Post> postList = this.createSimplePostsList();
    when(mockPostService.getPosts()).thenReturn(postList);

    List<Post> postsFound = mockPostController.getPosts();

    Assertions.assertEquals(postsFound.size(), postList.size());
    Assertions.assertFalse(postsFound.isEmpty());
  }

  private Post createSimplePost() {
    Post post = new Post();
    post.setId(POST_ID);
    post.setUserId(USER_ID);
    post.setTitle(POST_TITLE);
    post.setBody(POST_BODY);
    return post;
  }

  private List<Post> createSimplePostsList() {
    return Arrays.asList(new Post(), new Post(), new Post(), new Post());
  }
}
