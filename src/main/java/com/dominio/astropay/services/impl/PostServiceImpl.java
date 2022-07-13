package com.dominio.astropay.services.impl;

import com.dominio.astropay.domain.Post;
import com.dominio.astropay.repositories.PostRepository;
import com.dominio.astropay.api.ApiConsumer;
import com.dominio.astropay.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

  @Autowired
  private PostRepository postRepository;

  @Override
  public void persistPosts() {
    ApiConsumer apiConsumer = new ApiConsumer();
    List<Post> posts = apiConsumer.getBlogPosts();
    postRepository.saveAll(posts);
  }

  @Override
  public List<Post> getPosts() {
    return (List<Post>) postRepository.findAll();
  }

  @Override
  public Post getPostById(Long id) {
    return postRepository.findById(id).get();
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
