package com.dominio.astropay.services.impl;

import com.dominio.astropay.api.ApiConsumer;
import com.dominio.astropay.domain.Comment;
import com.dominio.astropay.repositories.CommentRepository;
import com.dominio.astropay.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

  @Autowired
  private CommentRepository commentRepository;

  @Override
  public Iterable<Comment> persistComments(ApiConsumer apiConsumer) {
    List<Comment> comments= apiConsumer.getBlogComments();
    return commentRepository.saveAll(comments);
  }

  @Override
  public List<Comment> getComments() {
    return (List<Comment>) commentRepository.findAll();
  }

  @Override
  public List<Comment> getCommentsByPostId(Long postId) {
    return commentRepository.findAllByPostId(postId);
  }
}
