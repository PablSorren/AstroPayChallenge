package com.dominio.astropay.controllers;

import com.dominio.astropay.domain.Comment;
import com.dominio.astropay.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/comments")
public class CommentControler {

  @Autowired
  private CommentService commentService;

  @GetMapping(value = "")
  public List<Comment> getComments(){
    return commentService.getComments();
  }

  @GetMapping(value = "/{postId}")
  public List<Comment> getCommentsByPostId(@PathVariable("postId") Long postId){
    return commentService.getCommentsByPostId(postId);
  }
}
