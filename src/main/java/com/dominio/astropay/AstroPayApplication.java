package com.dominio.astropay;

import com.dominio.astropay.domain.Comment;
import com.dominio.astropay.repositories.CommentRepository;
import com.dominio.astropay.services.ApiConsumer;
import com.dominio.astropay.domain.Post;
import com.dominio.astropay.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication()
public class AstroPayApplication implements CommandLineRunner {

	@Autowired
	PostRepository postRepository;

	@Autowired
	CommentRepository commentRepository;

	public static void main(String[] args) {
		SpringApplication.run(AstroPayApplication.class, args);
	}

	@Override
	public void run(String...args) {

		//TODO ABSTRAER LA LOGICA DE LA PERSISTENCIA EN OTROS METODOS Y LUEGO CREAR LOS CONTROLLERS
		System.out.println("**************POSTS!*********** \n \n");
		ApiConsumer apiConsumer = new ApiConsumer();

		List<Post> posts = apiConsumer.getBlogPosts();
		postRepository.saveAll(posts);
		List<Post> persistidos = (List<Post>) postRepository.findAll();


		persistidos.forEach(post -> {
			System.out.printf("{ \n" +
					"userId : %d \n"+
					"id : %d \n"+
					"title : %s \n"+
					"body : %s \n"+
					"}\n", post.getUserId(), post.getId(), post.getTitle(), post.getBody());
		});

		System.out.println("**************COMENTARIOS!*********** \n \n");
		List<Comment> comments= apiConsumer.getBlogComments();
		commentRepository.saveAll(comments);
		List<Comment> comentarios = (List<Comment>) commentRepository.findAll();

		comentarios.forEach(comment -> {
			System.out.printf("{ \n" +
					"postId : %d \n"+
					"id : %d \n"+
					"Name : %s \n"+
					"Email : %s \n"+
					"Body : %s \n"+
					"}\n", comment.getPostId(), comment.getId(), comment.getName(), comment.getEmail(),comment.getBody());
		});
	}

}
