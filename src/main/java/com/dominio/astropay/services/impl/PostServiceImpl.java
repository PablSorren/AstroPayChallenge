package com.dominio.astropay.services.impl;

import com.dominio.astropay.domain.Post;
import com.dominio.astropay.exception.NoSeEncontroElPostException;
import com.dominio.astropay.repositories.PostRepository;
import com.dominio.astropay.api.ApiConsumer;
import com.dominio.astropay.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

  @Autowired
  private PostRepository postRepository;

  @Override
  public List<Post> persistPosts(ApiConsumer apiConsumer) {
    List<Post> posts = apiConsumer.getBlogPosts();
   return postRepository.saveAll(posts);
  }

  @Override
  public List<Post> getPosts() {
    return (List<Post>) postRepository.findAll();
  }

  @Override
  public Post getPostById(Long id) {
    Optional<Post> post = postRepository.findById(id);
    if(post.isPresent()) {
      return post.get();
    } else {
      throw new NoSeEncontroElPostException(id);
    }
  }

  @Override
  public List<Post> getPostsWithWordInTitle(String word) {
    return postRepository.findAllByTitleContaining(word);
  }

  @Override
  public List<Post> getPaginatedPosts(int pageNumber, int pageSize) {
    Page<Post> pages = postRepository.findAll(PageRequest.of(pageNumber, pageSize));
    return pages.getContent();
  }

}
