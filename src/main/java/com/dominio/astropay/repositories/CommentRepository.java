package com.dominio.astropay.repositories;

import com.dominio.astropay.domain.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment,Long> {

  List<Comment> findAllByPostId(Long postId);

}
