package com.dominio.astropay;

import com.dominio.astropay.domain.Comment;
import com.dominio.astropay.repositories.CommentRepository;
import com.dominio.astropay.services.CommentService;
import com.dominio.astropay.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication()
public class AstroPayApplication implements CommandLineRunner {

	@Autowired
	PostService postService;

	@Autowired
	CommentService commentService;

	public static void main(String[] args) {
		SpringApplication.run(AstroPayApplication.class, args);
	}

	@Override
	public void run(String...args) {
		postService.persistPosts();
		commentService.persistComments();
	}

}
