package com.dominio.astropay.services.impl;

import com.dominio.astropay.api.ApiConsumer;
import com.dominio.astropay.domain.Post;
import com.dominio.astropay.repositories.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
public class PostServiceImplTest {

  @MockBean
  private PostRepository mockPostRepository;

  @Mock
  private ApiConsumer apiConsumer;

  @InjectMocks
  private PostServiceImpl postServiceImpl;

  @BeforeEach
  public void setUp(){
    postServiceImpl = Mockito.mock(PostServiceImpl.class);
    when(mockPostRepository.findAll()).thenReturn(createSimplePostsList());
  }


  private List<Post> createSimplePostsList() {
    return Arrays.asList(new Post(), new Post(), new Post());
  }

}
