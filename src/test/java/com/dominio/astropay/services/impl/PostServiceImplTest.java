package com.dominio.astropay.services.impl;

import com.dominio.astropay.api.ApiConsumer;
import com.dominio.astropay.domain.Post;
import com.dominio.astropay.repositories.PostRepository;
import com.dominio.astropay.services.PostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringJUnitConfig
public class PostServiceImplTest {

  @Mock
  private PostRepository mockPostRepository;

  @InjectMocks
  private PostServiceImpl mockPostServiceImpl;

  private ApiConsumer mockApiConsumer;

  @BeforeEach
  public void setUp(){
    mockPostServiceImpl = new PostServiceImpl();
    this.mockApiConsumer = Mockito.mock(ApiConsumer.class);
  }

  @Test
  public void persistPostsTest(){
    when(mockApiConsumer.getBlogPosts()).thenReturn(this.createSimplePostsList());
    when(mockPostRepository.saveAll(Mockito.any(List.class))).thenReturn(this.createSimplePostsList());
    List<Post> postPersisted = mockPostServiceImpl.persistPosts(mockApiConsumer);

    Assertions.assertFalse(postPersisted.isEmpty());
  }

  private List<Post> createSimplePostsList() {
    return Arrays.asList(new Post(), new Post(), new Post());
  }

}
