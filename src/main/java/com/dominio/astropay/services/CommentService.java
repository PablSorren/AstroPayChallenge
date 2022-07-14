package com.dominio.astropay.services;

import com.dominio.astropay.api.ApiConsumer;
import com.dominio.astropay.domain.Comment;

import java.util.List;

public interface CommentService {

  Iterable<Comment> persistComments(ApiConsumer apiConsumer);

  List<Comment> getComments();

  List<Comment> getCommentsByPostId(Long postId);
}
