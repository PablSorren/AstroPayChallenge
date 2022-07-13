package com.dominio.astropay.services;

import com.dominio.astropay.domain.Comment;

import java.util.List;

public interface CommentService {

  void persistComments();

  List<Comment> getComments();

  List<Comment> getCommentsByPostId(Long postId);
}
