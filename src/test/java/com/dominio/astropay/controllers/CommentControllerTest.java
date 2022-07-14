package com.dominio.astropay.controllers;

import com.dominio.astropay.domain.Comment;
import com.dominio.astropay.services.CommentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
public class CommentControllerTest {

  @Mock
  private CommentService mockCommentService;

  @InjectMocks
  private CommentController mockCommentController;

  @Test
  public void getCommentsByPostIdTest_OK(){
    List<Comment> comments = this.createSimpleCommentsList();
    when(mockCommentService.getCommentsByPostId(anyLong())).thenReturn(comments);

    List<Comment> commentsFound = mockCommentController.getCommentsByPostId(anyLong());

    Assertions.assertFalse(commentsFound.isEmpty());
    Assertions.assertEquals(commentsFound, comments);
  }

  @Test
  public void getCommentsByPostIdTest_NoCommentsForThatPost(){
    when(mockCommentService.getCommentsByPostId(1L)).thenReturn(this.createSimpleCommentsList());

    List<Comment> commentsFound = mockCommentController.getCommentsByPostId(2L);

    Assertions.assertTrue(commentsFound.isEmpty());
  }

  @Test
  public void getCommentsTest_OK(){
    List<Comment> commentsList = this.createSimpleCommentsList();
    when(mockCommentService.getComments()).thenReturn(commentsList);

    List<Comment> commentsFound = mockCommentController.getComments();

    Assertions.assertFalse(commentsFound.isEmpty());
    Assertions.assertEquals(commentsFound, commentsList);
  }

  private List<Comment> createSimpleCommentsList() {
    return Arrays.asList(new Comment(), new Comment());
  }

}
