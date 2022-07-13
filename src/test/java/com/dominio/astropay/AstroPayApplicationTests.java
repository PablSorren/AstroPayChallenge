package com.dominio.astropay;

import com.dominio.astropay.domain.Comment;
import com.dominio.astropay.domain.Post;
import com.dominio.astropay.api.ApiConsumer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AstroPayApplicationTests {

	@Test
	public void TestGetPostsList() {
		ApiConsumer apiConsumer = new ApiConsumer();

		List<Post> posts = apiConsumer.getBlogPosts();

		posts.forEach(post -> {
			System.out.printf("{ \n" +
					"userId : %d \n"+
					"id : %d \n"+
					"title : %s \n"+
					"body : %s \n"+
					"}\n", post.getUserId(), post.getId(), post.getTitle(), post.getBody());
		});

		Assertions.assertTrue(!posts.isEmpty());
	}

	@Test
	public void TestGetPostCommentsById() {
		ApiConsumer apiConsumer = new ApiConsumer();

		List<Comment> comments = apiConsumer.getPostComments((long) 1);

		comments.forEach(comment -> {
			System.out.printf("{ \n" +
					"postId : %d \n"+
					"id : %d \n"+
					"Name : %s \n"+
					"Email : %s \n"+
					"Body : %s \n"+
					"}\n", comment.getPostId(), comment.getId(), comment.getName(), comment.getEmail(),comment.getBody());
		});

		Assertions.assertTrue(!comments.isEmpty());
	}

	@Test
	public void TestGetAllComments(){
		ApiConsumer apiConsumer = new ApiConsumer();
		List<Comment> comments = apiConsumer.getBlogComments();
		comments.forEach(comment -> {
			System.out.printf("{ \n" +
					"postId : %d \n"+
					"id : %d \n"+
					"Name : %s \n"+
					"Email : %s \n"+
					"Body : %s \n"+
					"}\n", comment.getPostId(), comment.getId(), comment.getName(), comment.getEmail(),comment.getBody());
		});

		Assertions.assertTrue(!comments.isEmpty());
	}

}
