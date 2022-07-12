package com.dominio.astropay.post;

import com.dominio.astropay.AstroPayApplication;
import com.dominio.astropay.domain.Post;
import com.dominio.astropay.repositories.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = AstroPayApplication.class)
public class PostRepositoryTest {

  @Autowired
  PostRepository postRepository;

  @Test
  public void findingPostByIdTest(){
    Post post = new Post();
    post.setUserId(1L);
    post.setTitle("Prueba Repo Persistencia");
    post.setBody("Esta es la prueba del etc etc");

    postRepository.save(post);

    Post respuesta = (Post) postRepository.findById(1L).get();

    System.out.printf("{ \n" +
        "userId : %d \n"+
        "id : %d \n"+
        "title : %s \n"+
        "body : %s \n"+
        "}\n", respuesta.getUserId(), respuesta.getId(), respuesta.getTitle(), respuesta.getBody());

    Assertions.assertEquals(respuesta.getId(), 1L);

  }
}
